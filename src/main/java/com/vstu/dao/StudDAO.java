package com.vstu.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.vstu.entity.Stud;

@Transactional
@Repository
public class StudDAO implements IStudDAO {

	@PersistenceContext
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	public List<Stud> getAllStud() {

		String hql = "from Stud";
		return entityManager.createQuery(hql).getResultList();
	}

	public Stud getStudById(int idStud) {

		return entityManager.find(Stud.class, idStud);
	}

	public void addStud(Stud s) {
		entityManager.persist(s);

	}

	public void updateStud(Stud s) {
		Stud stud = getStudById(s.getIdStud());
		stud.setCourse(s.getCourse());
		stud.setFirstName(s.getFirstName());
		stud.setGr(s.getGr());
		stud.setIdStud(s.getIdStud());
		stud.setMarkCollection(s.getMarkCollection());
		stud.setPatronymic(s.getPatronymic());
		stud.setSurName(s.getSurName());
		entityManager.flush();

	}

	public void deleteStud(int idStud) {
		entityManager.remove(getStudById(idStud));

	}

	public boolean studExists(String firstName, String surName) {
		String hql = "FROM Stud as s WHERE s.firstname = ? and s.surname = ?";
		int count = entityManager.createQuery(hql).setParameter(1, firstName).setParameter(2, surName).getResultList()
				.size();
		return count > 0 ? true : false;
	}

}
