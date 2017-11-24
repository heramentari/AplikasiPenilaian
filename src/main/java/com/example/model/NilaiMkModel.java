package com.example.model;

import java.util.List;
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
	private Double nilai;
}