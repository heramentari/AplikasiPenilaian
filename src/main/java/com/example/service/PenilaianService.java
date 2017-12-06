package com.example.service;

import java.util.List;

import com.example.model.MataKuliahModel;
import com.example.model.NilaiMkModel;
import com.example.model.StatistikNilaiMkModel;
import com.example.model.UserModel;

public interface PenilaianService
{
    UserModel selectUser (String username);
    
    MataKuliahModel selectCourse (String kode_mk);

    List<MataKuliahModel> selectCoursesByUser (String id);
    
    NilaiMkModel selectScore(String npm, String kode_mk);
    
    StatistikNilaiMkModel lihatStatistikMatkul (String kode_mk);
    
    StatistikNilaiMkModel selectNamaStatistikNilaiTertinggi(String kode_mk);
    
    StatistikNilaiMkModel selectNamaStatistikNilaiTerendah (String kode_mk);
}