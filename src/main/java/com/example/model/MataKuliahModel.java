package com.example.model;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MataKuliahModel {
	private String nama;
	private String kode_mk;
	private String periode;
	private Integer kuota;
	private Integer sks;
	
	private List<UserModel> dosens;
	private List<UserModel> mahasiswas;
	private List<NilaiMkModel> nilais;
}