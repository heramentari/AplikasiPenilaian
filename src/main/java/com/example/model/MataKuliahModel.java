package com.example.model;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MataKuliahModel {
	private int id;
	private String nama;
	private String kode_mk;
	private int kuota;
	private String periode;
	private int sks;
	private List<DosenModel> dosens;
	private List<MahasiswaModel> mahasiswas;
}