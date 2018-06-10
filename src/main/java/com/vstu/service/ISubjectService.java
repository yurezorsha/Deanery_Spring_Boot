package com.vstu.service;

import java.util.List;

import com.vstu.entity.Subject;

public interface ISubjectService {
	List<Subject> getAllSubject();

	Subject getSubjectById(int idSubject);

	boolean addSubject(Subject s);

	void updateSubject(Subject s);

	void deleteSubject(int idSubject);

}
