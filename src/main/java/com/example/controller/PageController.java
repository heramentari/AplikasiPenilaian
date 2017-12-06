package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.model.MataKuliahModel;
import com.example.model.NilaiMkModel;
import com.example.model.StatistikNilaiMkModel;
import com.example.model.UserModel;
import com.example.service.PenilaianService;

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
		model.addAttribute("mk", mk);
		StatistikNilaiMkModel statistik = penilaianDAO.lihatStatistikMatkul(kode_mk);
		model.addAttribute("statistik", statistik);
		return "statistik-mata-kuliah";
	}
	
	@RequestMapping("/nilai/{id}")
	public String isiNilai(Model model, @PathVariable(value = "id") String id) {
		
		//NilaiMkModel nilai = 
		return "isi-nilai";
	}
}
