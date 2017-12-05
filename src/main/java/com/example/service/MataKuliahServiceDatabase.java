package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.MataKuliahMapper;
import com.example.model.MataKuliahModel;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class MataKuliahServiceDatabase implements MataKuliahService{
	
	@Autowired
	private MataKuliahMapper mataKuliahMapper;
	
	@Override
	public List<MataKuliahModel> lihatMatkul(String nip) {
		log.info("lihat mata kuliah berdasarkan dosen yang mengajar dengan nip {}", nip);
		return mataKuliahMapper.lihatMatkul(nip);
	}

	@Override
	public MataKuliahModel deskripsiMatkul(String kode_mk) {
		log.info("lihat mata kuliah dengan kode_mk {}", kode_mk);
		return mataKuliahMapper.deskripsiMatkul(kode_mk);
	}

}
