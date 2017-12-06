package com.example.rest;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.MataKuliahModel;
import com.example.model.NilaiMkModel;
import com.example.model.StatistikNilaiMkModel;
import com.example.service.PenilaianService;

@RestController
@RequestMapping("/api")
public class PenilaianRestController {
	@Autowired
	PenilaianService penilaianService;

	@RequestMapping("/getNilaiKuliah/{npm}/{kode_mk}")
	public ResponseEntity<Object> getNilaiKuliah(@PathVariable(value = "npm") String npm, @PathVariable(value = "kode_mk") String kode_mk) {
		NilaiMkModel nmk = penilaianService.selectScore(npm, kode_mk);
		
		Map<String, Object> response = new LinkedHashMap<String, Object>();
		HttpStatus status;
		HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
		
		if (nmk != null) {
			response.put("status", 200);
			response.put("msg", "success");
			
			Map<String, Object> nilai = new LinkedHashMap<String, Object>();
			nilai.put("id", nmk.getId());
			nilai.put("npm", nmk.getMahasiswa().getUser_id());
			nilai.put("kode_mk", nmk.getKode_mk());
			nilai.put("nilai", nmk.getNilai());
		    
		    Map<String, Object> result = new LinkedHashMap<String, Object>();
		    result.put("nilai_mk", nilai);
		    
		    status = HttpStatus.OK;
		    response.put("result", result);
		}
		else {
			response.put("status", 404);
			response.put("msg", "Mahasiswa dan atau mata kuliah tidak ditemukan");
			status = HttpStatus.NOT_FOUND;
		}
		
		return new ResponseEntity<Object>(response, headers, status);
	}
	
	@RequestMapping("/getDaftarNilaiKuliah/{kode_mk}")
	public ResponseEntity<Object> getDaftarNilaiKuliah(@PathVariable(value = "kode_mk") String kode_mk) {
		MataKuliahModel mk = penilaianService.selectCourse(kode_mk);
		
		Map<String, Object> response = new LinkedHashMap<String, Object>();
		HttpStatus status;
		HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
		
		if (mk != null) {
			response.put("status", 200);
			response.put("msg", "success");
		    
			List<Object> array = new ArrayList<Object>();
		    for (NilaiMkModel nmk : mk.getNilais()) {
		    		Map<String, Object> nilai = new LinkedHashMap<String, Object>();
		    		nilai.put("npm", nmk.getMahasiswa().getUser_id());
		    		nilai.put("nama", nmk.getMahasiswa().getNama());
		    		nilai.put("nilai", nmk.getNilai());
		    		array.add(nilai);
		    }
		    
		    Map<String, Object> result = new LinkedHashMap<String, Object>();
		    result.put("kode_mk", mk.getKode_mk());
		    result.put("mahasiswa", array);
		    
		    status = HttpStatus.OK;
		    response.put("result", result);
		}
		else {
			response.put("status", 404);
			response.put("msg", "Mata Kuliah tidak ditemukan");
			status = HttpStatus.NOT_FOUND;
		}
		
		return new ResponseEntity<Object>(response, headers, status);
	}
	
	@RequestMapping("/getStatistikNilaiKuliah/{kode_mk}")
	public ResponseEntity<Object> getStatistikNilaiKuliah(@PathVariable(value = "kode_mk") String kode_mk) {
		StatistikNilaiMkModel snmk = penilaianService.lihatStatistikMatkul(kode_mk);
		
		Map<String, Object> response = new LinkedHashMap<String, Object>();
		HttpStatus status;
		HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
		
		if (snmk != null) {
			response.put("status", 200);
			response.put("msg", "success");
			
			Map<String, Object> statistik = new LinkedHashMap<String, Object>();
			statistik.put("kode_mk", snmk.getKode_mk());
			statistik.put("nilai_tertinggi", snmk.getNilai_tertinggi());
			statistik.put("nilai_terendah", snmk.getNilai_terendah());
			statistik.put("nilai_average", snmk.getNilai_average());
			statistik.put("std_deviasi", snmk.getStd_deviasi());
		    
		    Map<String, Object> result = new LinkedHashMap<String, Object>();
		    result.put("statistik_nilai_mk", statistik);
		    
		    status = HttpStatus.OK;
		    response.put("result", result);
		}
		else {
			response.put("status", 404);
			response.put("msg", "Mata Kuliah tidak ditemukan");
			status = HttpStatus.NOT_FOUND;
		}
		
		return new ResponseEntity<Object>(response, headers, status);
	}
}