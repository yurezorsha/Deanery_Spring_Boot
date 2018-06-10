package com.vstu.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.vstu.entity.Subject;

@Transactional
@Repository
public class SubjectDAO implements ISubjectDAO {

	@PersistenceContext
	private EntityManager entityManager;

	public List<Subject> getAllSubject() {

		String hql = "from Subject";
		return entityManager.createQuery(hql).getResultList();
	}

	public Subject getSubjectById(int idSubject) {

		return entityManager.find(Subject.class, idSubject);
	}

	public void addSubject(Subject s) {
		entityManager.persist(s);

	}

	public void updateSubject(Subject s) {
		Subject subject = getSubjectById(s.getIdSubj());
		subject.setIdSubj(s.getIdSubj());
		subject.setMarkCollection(s.getMarkCollection());
		subject.setName(s.getName());
		subject.setTeacher(s.getTeacher());
	}

	public void deleteSubject(int idSubject) {
		entityManager.remove(getSubjectById(idSubject));

	}

	public boolean SubjectExists(int idSubject) {
		String hql = "FROM Subject as s WHERE s.idSubj = ?";
		int count = entityManager.createQuery(hql).setParameter(1, idSubject).getResultList().size();
		return count > 0 ? true : false;
	}

}
