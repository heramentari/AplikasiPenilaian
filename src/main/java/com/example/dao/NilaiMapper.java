package com.example.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.example.model.NilaiMkModel;

@Mapper
public interface NilaiMapper {
	
	@Select("select * from nilai_mk NM join mahasiswa M on NM.npm = M.npm join users U on M.user_id = U.id where NM.kode_mk = #{kode_mk}")
    @Results(value = {
    		@Result(property="id", column="id"),
    		@Result(property="kode_mk", column="kode_mk"),
    		@Result(property="npm", column="npm"),
    		@Result(property="nilai", column="nilai"),
    		@Result(property="nama_mahasiswa", column="nama")
    })
	List<NilaiMkModel> lihatNilai (@Param("kode_mk") String kode_mk);
	
	@Insert("INSERT INTO nilai_mk (kode_mk, npm, nilai) VALUES (#{kode_mk}, #{npm}, #{nilai})")
	void tambahNilai (NilaiMkModel nilaiMk);

	void setNilai(NilaiMkModel nilai);
}
