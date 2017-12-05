package com.example.dao;

import java.util.List;

import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.example.model.*;

@Mapper
public interface PenilaianMapper {
	
	@Select("SELECT * FROM users WHERE username = #{username}")
	@Results(value = {
			@Result(property = "id", column = "id"),
			@Result(property = "username", column = "username"),
			@Result(property = "password", column = "password"),
			@Result(property = "nama", column = "nama"),
			@Result(property = "role", column = "role"),
			@Result(property = "matakuliahs", column = "id",
					javaType = List.class,
					many = @Many(select = "selectCoursesByUser"))
	})
	UserModel selectUser(@Param("username") String username);
	
	@Select("SELECT * FROM mk_users, mata_kuliah WHERE mata_kuliah.kode_mk = mk_users.kode_mk AND mk_users.id = #{id}")
	List<MataKuliahModel> selectCoursesByUser(@Param("id") String id);
}
