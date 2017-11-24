package com.example.model;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StatistikNilaiMkModel {
	private Integer id;
	private String kode_mk;
	private Integer id_nilai_tertinggi;
	private Integer id_nilai_terendah;
	private Double nilai_average;
	private Double std_deviasi;
	
	private MataKuliahModel matakuliah;
	private List<NilaiMkModel> nilai_tertinggi;
	private List<NilaiMkModel> nilai_terendah;
}