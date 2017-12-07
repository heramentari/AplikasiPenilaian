package com.example.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.PenilaianMapper;
import com.example.model.MataKuliahModel;
import com.example.model.NilaiMkModel;
import com.example.model.StatistikNilaiMkModel;
import com.example.model.UserModel;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class PenilaianServiceDatabase implements PenilaianService
{
    @Autowired
    private PenilaianMapper penilaianMapper;

	@Override
	public UserModel selectUser(String username) {
		log.info("Selected user with username {}", username);
		return penilaianMapper.selectUser(username);
	}
	
	@Override
	public UserModel selectUserById(String id) {
		log.info("Selected user with username {}", id);
		return penilaianMapper.selectUserById(id);
	}
	
	@Override
	public MataKuliahModel selectCourse(String kode_mk) {
		log.info("Selected course with kode mk {}", kode_mk);
		return penilaianMapper.selectCourse(kode_mk);
	}
	
	@Override
	public List<MataKuliahModel> selectCoursesByUser(String id) {
		log.info("Selected course by user with id {}", id);
		return penilaianMapper.selectCoursesByUser(id);
	}
	
	@Override
	public List<NilaiMkModel> selectScoresByCourse(String kode_mk){
		log.info("Selected scores by course with kode mk {}", kode_mk);
		return penilaianMapper.selectScoresByCourse(kode_mk);
	}
	
	@Override
	public NilaiMkModel selectScore(String npm, String kode_mk) {
		log.info("Selected score");
		return penilaianMapper.selectScore(npm, kode_mk);
	}

	@Override
	public StatistikNilaiMkModel lihatStatistikMatkul(String kode_mk) {
		log.info("Selected statistic for course {}", kode_mk);
		return penilaianMapper.lihatStatistikMatkul(kode_mk);
	}

	@Override
	public List<NilaiMkModel> selectNamaStatistikNilaiTertinggi(String kode_mk) {
		log.info("Selected student with the highest score for course {}", kode_mk);
		return penilaianMapper.selectNilaiTertinggis(kode_mk);
	}

	@Override
	public List<NilaiMkModel> selectNamaStatistikNilaiTerendah(String kode_mk) {
		log.info("Selected student with the lowest score for course {}", kode_mk);
		return penilaianMapper.selectNilaiTerendahs(kode_mk);
	}

	@Override
	public void isiNilai(String kode_mk, String id, double nilaiBaru) {
		log.info("Updated score for {}", id);
		penilaianMapper.updateNilaiMk(kode_mk, id, nilaiBaru);
	}
	
	@Override
	public void tambahIsiNilai(String kode_mk, String id, double nilaiBaru) {
		log.info("Added score for {}", id);
		penilaianMapper.tambahNilaiMk(kode_mk, id, nilaiBaru);
		
	}
	
	public void insertStatistics(StatistikNilaiMkModel snm) {
		log.info("Insert new statistics for course {}", snm.getKode_mk());
		penilaianMapper.insertStatistics(snm);
	}
	
	public void updateStatistics(StatistikNilaiMkModel snm) {
		log.info("Update statistics for course {}", snm.getKode_mk());
		System.out.println(snm);
		penilaianMapper.updateStatistics(snm);
	}

}
