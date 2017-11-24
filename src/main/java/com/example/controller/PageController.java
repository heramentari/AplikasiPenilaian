package com.example.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.model.DosenModel;
import com.example.model.MataKuliahModel;
import com.example.model.UserModel;

@Controller
public class PageController {
	//@Autowired
	//CourseService courseDAO;
	DosenModel dosen;
	
	public PageController() {
		UserModel dosenuser = new UserModel();
		DosenModel dosen = new DosenModel();
		dosenuser.setUsername("remco");
		dosenuser.setPassword("password");
		dosenuser.setNama("Remco");
		dosenuser.setId(1);
		
		dosen.setNip("17550099");
		dosen.setUser(dosenuser);
		
		List<MataKuliahModel> matakuliahs = new ArrayList<MataKuliahModel>();
		
		MataKuliahModel csc01 = new MataKuliahModel();
		csc01.setId(1);
		csc01.setKode_mk("CSC01");
		csc01.setKuota(30);
		csc01.setSks(3);
		csc01.setNama("APAP");
		
		MataKuliahModel csc02 = new MataKuliahModel();
		csc02.setId(2);
		csc02.setKode_mk("CSC02");
		csc02.setKuota(30);
		csc02.setSks(6);
		csc02.setNama("ANAP");
		
		MataKuliahModel csc03 = new MataKuliahModel();
		csc03.setId(3);
		csc03.setKode_mk("CSC03");
		csc03.setKuota(30);
		csc03.setSks(12);
		csc03.setNama("ARAP");
		
		matakuliahs.add(csc01);
		matakuliahs.add(csc02);
		matakuliahs.add(csc03);
		dosen.setMatakuliahs(matakuliahs);
		
		this.dosen = dosen;
	}
	
	@RequestMapping("/login")
	public String login(Model model) {
		return "login";
	}

	@RequestMapping("/dashboard")
	public String dashboard(Model model) {
		model.addAttribute("dosen", this.dosen);
		
		return "dashboard";
	}
	
	@RequestMapping("/detail/{id}")
	public String detailMataKuliah(Model model, @PathVariable(value = "id") String id) {
		return "detail-mata-kuliah";
	}
	
	@RequestMapping("/statistik/{id}")
	public String statistikMataKuliah(Model model, @PathVariable(value = "id") String id) {
		model.addAttribute("dosen", this.dosen);
		
		return "statistik-mata-kuliah";
	}
	
	@RequestMapping("/nilai/{id}")
	public String isiNilai(Model model, @PathVariable(value = "id") String id) {
		return "isi-nilai";
	}
}
