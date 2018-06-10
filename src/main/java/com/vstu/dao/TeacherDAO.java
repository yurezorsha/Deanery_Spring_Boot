package com.vstu.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.vstu.entity.Teacher;

@Transactional
@Repository
public class TeacherDAO implements ITeacherDAO {

	@PersistenceContext
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	public List<Teacher> getAllTeacher() {
		String hql = "from Teacher";
		return entityManager.createQuery(hql).getResultList();
	}

	public Teacher getTeacherById(int idTeacher) {

		return entityManager.find(Teacher.class, idTeacher);
	}

	public void addTeacher(Teacher t) {
		entityManager.persist(t);

	}

	public void updateTeacher(Teacher t) {
		Teacher teacher = getTeacherById(t.getIdTeach());
		teacher.setFirstName(t.getFirstName());
		teacher.setIdTeach(t.getIdTeach());
		teacher.setSurName(t.getSurName());
		teacher.setPatronymic(t.getPatronymic());
		teacher.setSubjectCollection(t.getSubjectCollection());
		entityManager.flush();
	}

	public void deleteTeacher(int idTeacher) {

		entityManager.remove(getTeacherById(idTeacher));

	}

	public boolean TeacherExists(String firstName, String surName) {
		String hql = "FROM Teacher as t WHERE t.firstname = ? and t.surname = ?";
		int count = entityManager.createQuery(hql).setParameter(1, firstName).setParameter(2, surName).getResultList()
				.size();
		return count > 0 ? true : false;
	}

}
