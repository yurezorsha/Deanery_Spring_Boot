package com.vstu.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.vstu.entity.Mark;
import com.vstu.entity.Stud;

@Transactional
@Repository
public class MarkDAO implements IMarkDAO {

	@PersistenceContext
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	public List<Mark> getAllMark() {

		String hql = "from Mark ORDER BY Mark DESC";
		return entityManager.createQuery(hql).getResultList();
	}

	public Mark getMarkById(int idMark) {
		// TODO Auto-generated method stub
		return null;
	}

	public void addMark(Mark m) {
		// TODO Auto-generated method stub

	}

	public void updateMark(Mark m) {
		// TODO Auto-generated method stub

	}

	public void deleteMark(int idMark) {
		// TODO Auto-generated method stub

	}

	public boolean MarkExists(Stud s, Date date) {
		// TODO Auto-generated method stub
		return false;
	}

}
