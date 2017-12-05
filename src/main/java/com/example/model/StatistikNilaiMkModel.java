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
	private Double nilai_tertinggi;
	private Double nilai_terendah;
	private Double nilai_average;
	private Double std_deviasi;
	private MataKuliahModel matakuliah;
	private List<NilaiMkModel> nilai_tertinggis;
	private List<NilaiMkModel> nilai_terendahs;
}