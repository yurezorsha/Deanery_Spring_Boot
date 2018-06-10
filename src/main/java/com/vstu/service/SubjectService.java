package com.vstu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vstu.dao.ISubjectDAO;
import com.vstu.entity.Subject;

@Service
public class SubjectService implements ISubjectService {
	@Autowired
	private ISubjectDAO subjectDAO;

	public List<Subject> getAllSubject() {

		return subjectDAO.getAllSubject();
	}

	public Subject getSubjectById(int idSubject) {
		Subject obj = subjectDAO.getSubjectById(idSubject);
		return obj;
	}

	public synchronized boolean addSubject(Subject s) {
		if (subjectDAO.SubjectExists(s.getIdSubj())) {
			return false;
		} else {
			subjectDAO.addSubject(s);

			return true;
		}
	}

	public void updateSubject(Subject s) {
		subjectDAO.updateSubject(s);

	}

	public void deleteSubject(int idSubject) {
		subjectDAO.deleteSubject(idSubject);

	}

}
