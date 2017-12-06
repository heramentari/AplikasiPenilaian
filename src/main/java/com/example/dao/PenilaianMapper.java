package com.example.dao;

import java.sql.JDBCType;
import java.util.List;

import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

import com.example.model.*;

@Mapper
public interface PenilaianMapper {
	
	@Select("SELECT * FROM users WHERE username = #{username}")
	@Results(value = {
			@Result(property = "user_id", column = "id"),
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
	@Results(value = {
			@Result(property = "nama", column = "mata_kuliah.nama"),
			@Result(property = "kode_mk", column = "mata_kuliah.kode_mk"),
			@Result(property = "periode", column = "mata_kuliah.periode"),
			@Result(property = "kuota", column = "mata_kuliah.kuota"),
			@Result(property = "sks", column = "mata_kuliah.sks")
	})
	List<MataKuliahModel> selectCoursesByUser(@Param("id") String id);
	
	@Select("SELECT * FROM mata_kuliah WHERE kode_mk = #{kode_mk}")
	@Results(value = {
			@Result(property = "kode_mk", column = "kode_mk"),
			@Result(property = "nama", column = "nama"),
			@Result(property = "kuota", column = "kuota"),
			@Result(property = "periode", column = "periode"),
			@Result(property = "sks", column = "sks"),
			@Result(property = "nilais", column = "kode_mk",
					javaType = List.class,
					many = @Many(select = "selectScoresByCourse"))
	})
	MataKuliahModel selectCourse(@Param("kode_mk") String kode_mk);
	
	@Select("SELECT * FROM nilai_mk WHERE kode_mk = #{kode_mk}")
	@Results(value = {
			@Result(property = "id", column = "id"),
			@Result(property = "npm", column = "npm"),
			@Result(property = "kode_mk", column = "kode_mk"),
			@Result(property = "nilai", column = "nilai"),
			@Result(property = "mahasiswa", column = "npm",
					javaType = UserModel.class,
					one = @One(select = "selectUserById"))
	})
	List<NilaiMkModel> selectScoresByCourse(@Param("kode_mk") String kode_mk);
		
	@Select("SELECT * FROM users WHERE id = #{id}")
	@Results(value = {
			@Result(property = "user_id", column = "id"),
			@Result(property = "username", column = "username"),
			@Result(property = "password", column = "password"),
			@Result(property = "nama", column = "nama"),
			@Result(property = "role", column = "role"),
			@Result(property = "matakuliahs", column = "id",
					javaType = List.class,
					many = @Many(select = "selectCoursesByUser"))
	})
	UserModel selectUserById(@Param("id") String id);
	
	@Select("SELECT * FROM nilai_mk WHERE npm = #{npm} AND kode_mk = #{kode_mk}")
	@Results(value = {
			@Result(property = "id", column = "id"),
			@Result(property = "npm", column = "npm"),
			@Result(property = "kode_mk", column = "kode_mk"),
			@Result(property = "nilai", column = "nilai"),
			@Result(property = "mahasiswa", column = "npm",
					javaType = UserModel.class,
					one = @One(select = "selectUserById"))
	})
	NilaiMkModel selectScore(@Param("npm") String npm, @Param("kode_mk") String kode_mk);
	
	@Select("SELECT * FROM statistik_nilai_mk, mata_kuliah WHERE statistik_nilai_mk.kode_mata_kuliah = #{kode_mk} AND mata_kuliah.kode_mk = #{kode_mk}")
	@Results(value = {
			@Result(property = "id", column = "statistik_nilai_mk.id"),
			@Result(property = "kode_mk", column = "statistik_nilai_mk.kode_mk"),
			@Result(property = "nilai_tertinggi", column = "statistik_nilai_mk.nilai_tertinggi"),
			@Result(property = "nilai_terendah", column = "statistik_nilai_mk.nilai_terendah"),
			@Result(property = "nilai_average", column = "statistik_nilai_mk.nilai_average"),
			@Result(property = "std_deviasi", column = "statistik_nilai_mk.std_deviasi")
	})
	StatistikNilaiMkModel lihatStatistikMatkul(@Param("kode_mk") String kode_mk);
	
	@Select("SELECT U.id, U.nama FROM users U, nilai_mk N, statistik_nilai_mk S WHERE U.id = N.npm AND N.kode_mk = S.kode_mata_kuliah AND S.nilai_tertinggi = N.nilai AND S.kode_mata_kuliah = #{kode_mata_kuliah}")
	@Results(value = {
			@Result(property = "npmTertinggi", column = "id"),
			@Result(property = "namaTertinggi", column = "nama")
	})
	StatistikNilaiMkModel selectNamaStatistikNilaiTertinggi(@Param("kode_mata_kuliah") String kode_mata_kuliah);
	
	@Select("SELECT U.id, U.nama FROM users U, nilai_mk N, statistik_nilai_mk S WHERE U.id = N.npm AND N.kode_mk = S.kode_mata_kuliah AND S.nilai_terendah = N.nilai AND S.kode_mata_kuliah = #{kode_mata_kuliah}")
	@Results(value = {
			@Result(property = "npmTerendah", column = "id"),
			@Result(property = "namaTerendah", column = "nama")
	})
	StatistikNilaiMkModel selectNamaStatistikNilaiTerendah(@Param("kode_mata_kuliah") String kode_mata_kuliah);
}
