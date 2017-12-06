package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.model.MataKuliahModel;
import com.example.model.NilaiMkModel;
import com.example.model.StatistikNilaiMkModel;
import com.example.model.UserModel;
import com.example.service.PenilaianService;

import java.util.List;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class PageController {
	@Autowired
	PenilaianService penilaianDAO;
	
	@RequestMapping("/login")
	public String login(Model model) {
		return "login";
	}

	@RequestMapping("/dashboard")
	public String dashboard(Model model) {
		// User object is of type Object and needs to be casted in order to get contents
		User loggedInUser = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		UserModel dosen = penilaianDAO.selectUser(loggedInUser.getUsername());
		
		model.addAttribute("dosen", dosen);
		
		return "dashboard";
	}
	
	@RequestMapping("/detail/{kode_mk}")
	public String detailMataKuliah(Model model, @PathVariable(value = "kode_mk") String kode_mk) {
		MataKuliahModel mk = penilaianDAO.selectCourse(kode_mk);
		model.addAttribute("mk", mk);
		return "detail-mata-kuliah";
	}
	
	@RequestMapping("/statistik/{kode_mk}")
	public String statistikMataKuliah(Model model, @PathVariable(value = "kode_mk") String kode_mk) {
		MataKuliahModel mk = penilaianDAO.selectCourse(kode_mk);
		
		StatistikNilaiMkModel statistik = penilaianDAO.lihatStatistikMatkul(kode_mk);
		if (statistik == null) { statistik = this.updateStatistics(kode_mk); }
		
		List<NilaiMkModel> tertinggis = penilaianDAO.selectNamaStatistikNilaiTertinggi(kode_mk);
		List<NilaiMkModel> terendahs = penilaianDAO.selectNamaStatistikNilaiTerendah(kode_mk);
		
		model.addAttribute("tertinggis", tertinggis);
		model.addAttribute("terendahs", terendahs);
		model.addAttribute("mk", mk);
		model.addAttribute("statistik", statistik);
		return "statistik-mata-kuliah";
	}
	
	@RequestMapping("/detail/{kode_mk}/nilai/{id}")
	public String isiNilai(Model model, @PathVariable(value = "id") String id, @PathVariable(value = "kode_mk") String kode_mk) {
		
		UserModel mahasiswa = penilaianDAO.selectUserById(id);
		NilaiMkModel nilaiMk = penilaianDAO.selectScore(id, kode_mk);
		
		model.addAttribute("mahasiswa", mahasiswa);
		model.addAttribute("nilaiMk", nilaiMk);
		
		return "isi-nilai";
	}
	
	@RequestMapping(value = "/detail/{kode_mk}/nilai/{id}/submit", method = RequestMethod.POST)
	public String submitNilai(Model model, @PathVariable(value = "id") String id, @PathVariable(value = "kode_mk") String kode_mk,
			@RequestParam(value = "nilaiBaru", required = false) double nilaiBaru
		) {
		
		penilaianDAO.isiNilai(kode_mk, id, nilaiBaru);
		
		this.updateStatistics(kode_mk);
		
		return "redirect:/detail/" + kode_mk;
	}
	
	public StatistikNilaiMkModel updateStatistics(String kode_mk) {
		StatistikNilaiMkModel snm = penilaianDAO.lihatStatistikMatkul(kode_mk);
		List<NilaiMkModel> nilais = penilaianDAO.selectScoresByCourse(kode_mk);
		boolean isNew = false;
		
		if (snm == null) {
			isNew = true;
			snm = new StatistikNilaiMkModel();
		}
		
		NilaiMkModel highest = null;
		NilaiMkModel lowest = null;
		
		double total = 0.0;
		
		for (NilaiMkModel nmk : nilais) {
			// for calculating average later
			total += nmk.getNilai();
			if (highest == null || nmk.getNilai() > highest.getNilai()) {
				highest = nmk;
			}
			if (lowest == null || nmk.getNilai() < lowest.getNilai()) {
				lowest = nmk;
			}
		}
		
		double avg = total / nilais.size();
		
		// calculate standard deviation
		double tsd = 0;
		for (NilaiMkModel nmk : nilais) {
		    tsd += Math.pow(nmk.getNilai() - avg, 2) / nilais.size();
		}
		double sd = Math.sqrt(tsd);
		
		snm.setNilai_average(avg);
		snm.setNilai_terendah(lowest.getNilai());
		snm.setNilai_tertinggi(highest.getNilai());
		snm.setStd_deviasi(sd);
		
		if (isNew) {
			snm.setKode_mk(kode_mk);
			penilaianDAO.insertStatistics(snm);
		}
		else {
			penilaianDAO.updateStatistics(snm);
		}
		
		return snm;
	}
}
