package com.vstu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vstu.dao.ITeacherDAO;
import com.vstu.entity.Teacher;

@Service
public class TeacherService implements ITeacherService {

	@Autowired
	private ITeacherDAO TeacherDAO;

	public List<Teacher> getAllTeacher() {

		return TeacherDAO.getAllTeacher();
	}

	public Teacher getTeacherById(int idTeacher) {
		Teacher obj = TeacherDAO.getTeacherById(idTeacher);
		return obj;
	}

	public synchronized boolean addTeacher(Teacher t) {
		if (TeacherDAO.TeacherExists(t.getFirstName(), t.getSurName())) {
			return false;
		} else {
			TeacherDAO.addTeacher(t);

			return true;
		}
	}

	public void updateTeacher(Teacher t) {
		TeacherDAO.updateTeacher(t);

	}

	public void deleteTeacher(int idTeacher) {
		TeacherDAO.deleteTeacher(idTeacher);

	}

}
