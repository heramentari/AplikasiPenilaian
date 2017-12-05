package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.NilaiMapper;
import com.example.model.NilaiMkModel;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class NilaiServiceDatabase implements NilaiService{
	
	@Autowired
	private NilaiMapper nilaiMapper;

	@Override
	public List<NilaiMkModel> lihatNilai(String kode_mk) {
		log.info("lihat nilai dari mata kuliah dengan kode_mk {}", kode_mk);
		return nilaiMapper.lihatNilai(kode_mk);
	}
	
	public void setNilai (NilaiMkModel nilai) {
		log.info("menambah nilai untuk mahasiswa");
		nilaiMapper.setNilai(nilai);
	}
	
	
}
