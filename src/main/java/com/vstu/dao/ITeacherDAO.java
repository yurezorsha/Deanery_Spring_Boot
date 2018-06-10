package com.vstu.dao;

import java.util.List;

import com.vstu.entity.Teacher;

public interface ITeacherDAO {
	List<Teacher> getAllTeacher();

	Teacher getTeacherById(int idTeacher);

	void addTeacher(Teacher t);

	void updateTeacher(Teacher t);

	void deleteTeacher(int idTeacher);

	boolean TeacherExists(String firstName, String surName);

}
