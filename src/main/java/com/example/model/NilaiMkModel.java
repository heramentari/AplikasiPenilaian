package com.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NilaiMkModel {
	private int id;
	private String kode_mk;
	private String npm;
	private double nilai;
	private String nama_mahasiswa;
}