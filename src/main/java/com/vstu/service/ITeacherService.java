package com.vstu.service;

import java.util.List;

import com.vstu.entity.Teacher;

public interface ITeacherService {
	List<Teacher> getAllTeacher();

	Teacher getTeacherById(int idTeacher);

	boolean addTeacher(Teacher t);

	void updateTeacher(Teacher t);

	void deleteTeacher(int idTeacher);

}
