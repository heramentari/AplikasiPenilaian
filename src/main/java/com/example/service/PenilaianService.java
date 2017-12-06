package com.example.service;

import java.util.List;

import com.example.model.MataKuliahModel;
import com.example.model.StatistikNilaiMkModel;
import com.example.model.UserModel;

public interface PenilaianService
{
    UserModel selectUser (String username);
    
    MataKuliahModel selectCourse (String kode_mk);

    List<UserModel> selectAllUsers ();
    
    List<UserModel> selectStudents ();
    
    List<UserModel> selectLecturers ();
    
    List<MataKuliahModel> selectCoursesByUser (String id);
    
    StatistikNilaiMkModel lihatStatistikMatkul (String kode_mk);
}