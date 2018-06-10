package com.vstu.dao;

import java.util.List;

import com.vstu.entity.Subject;

public interface ISubjectDAO {
	List<Subject> getAllSubject();

	Subject getSubjectById(int idSubject);

	void addSubject(Subject s);

	void updateSubject(Subject s);

	void deleteSubject(int idSubject);

	boolean SubjectExists(int idSubject);
}
