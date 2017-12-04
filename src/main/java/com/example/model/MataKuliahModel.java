package com.example.model;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MataKuliahModel {
	private Integer id;
	private String nama;
	private String kode_mk;
	private Integer kuota;
	private Integer sks;
	private List<DosenModel> dosens;
	private List<MahasiswaModel> mahasiswas;
}