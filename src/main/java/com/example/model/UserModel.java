package com.example.model;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserModel {
	private String user_id;
	private String username;
	private String password;
	private String nama;
	private String role;
	
	private List<MataKuliahModel> matakuliahs;
	private List<NilaiMkModel> nilais;
}