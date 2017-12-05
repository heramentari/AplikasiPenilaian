package com.example.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.example.model.MataKuliahModel;

@Mapper
public interface MataKuliahMapper {
	
	@Select("select * from mk_dosen where nip = #{nip}")
	List<MataKuliahModel> lihatMatkul (@Param("nip") String nip);
	
	@Select("select * from mata_kuliah where kode_mk = #{kode_mk}")
	MataKuliahModel deskripsiMatkul (@Param("kode_mk") String kode_mk);
}
