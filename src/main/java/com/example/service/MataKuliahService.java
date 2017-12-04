package com.example.service;

import java.util.List;

import com.example.model.MataKuliahModel;

public interface MataKuliahService {
	List<MataKuliahModel> lihatMatkul (String nip);
	MataKuliahModel deskripsiMatkul (String kode_mk);
}
