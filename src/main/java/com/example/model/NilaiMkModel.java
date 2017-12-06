package com.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NilaiMkModel {
	private Integer id;
	private String kode_mk;
	private String npm;
	private String npmTertinggi;
	private String namaTertinggi;
	private String npmTerendah;
	private String namaTerendah;
	private Double nilai;
	
	private UserModel mahasiswa;
}