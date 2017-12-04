package com.example.model;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserModel {
	private Integer id;
	private String username;
	private String password;
	private String nama;
	private Integer id_role;
	private RoleModel role;
}