package com.example.service;

import java.util.List;

import com.example.model.MataKuliahModel;
import com.example.model.NilaiMkModel;
import com.example.model.StatistikNilaiMkModel;
import com.example.model.UserModel;

public interface PenilaianService
{
    UserModel selectUser (String username);
    
    UserModel selectUserById(String id);
    
    MataKuliahModel selectCourse (String kode_mk);

    List<MataKuliahModel> selectCoursesByUser (String id);
    
    NilaiMkModel selectScore(String npm, String kode_mk);
    
    StatistikNilaiMkModel lihatStatistikMatkul (String kode_mk);
    
    List<NilaiMkModel> selectNamaStatistikNilaiTertinggi(String kode_mk);
    
    List <NilaiMkModel> selectNamaStatistikNilaiTerendah (String kode_mk);

	void isiNilai(String kode_mk, String id, double nilaiBaru);
}