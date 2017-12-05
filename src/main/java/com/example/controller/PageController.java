package com.example.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.model.MataKuliahModel;
import com.example.model.NilaiMkModel;
import com.example.model.UserModel;
import com.example.service.PenilaianService;
import com.example.service.MataKuliahService;
import com.example.service.NilaiService;

@Controller
public class PageController {
	@Autowired
	PenilaianService penilaianDAO;
	
	@Autowired
	NilaiService nilaiDAO;
	
	@Autowired
	MataKuliahService mataKuliahDAO;
	
	NilaiMkModel nilaiModel;
	
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
		MataKuliahModel matkul = mataKuliahDAO.deskripsiMatkul(kode_mk);
		
		List<NilaiMkModel> kumpulanNilai = nilaiDAO.lihatNilai(kode_mk);
		if (kumpulanNilai != null) {
			model.addAttribute("kumpulanNilai", kumpulanNilai);
			model.addAttribute("matkul", matkul);
			return "detail-mata-kuliah";
		} else {
			return "dashboard";
		}
	}
	
	@RequestMapping("/statistik/{id}")
	public String statistikMataKuliah(Model model, @PathVariable(value = "id") String id) {
		return "statistik-mata-kuliah";
	}
	
	@RequestMapping("/nilai/{id}")
	public String isiNilai(Model model, @PathVariable(value = "id") String id) {
		
		//NilaiMkModel nilai = 
		return "isi-nilai";
	}
}
