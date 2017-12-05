package com.example.model;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MahasiswaModel {
	private String npm;
	private Integer user_id;
	private UserModel user;
	private List<MataKuliahModel> matakuliahs;
}