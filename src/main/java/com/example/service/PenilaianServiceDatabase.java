package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.PenilaianMapper;
import com.example.model.MataKuliahModel;
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
		return penilaianMapper.selectUser(username);
	}


	@Override
	public List<UserModel> selectAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<UserModel> selectStudents() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<UserModel> selectLecturers() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<MataKuliahModel> selectCoursesByUser(String id) {
		return penilaianMapper.selectCoursesByUser(id);
	}

}