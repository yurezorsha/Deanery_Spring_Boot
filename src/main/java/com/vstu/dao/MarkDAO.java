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

		String hql = "from Mark ";
		return entityManager.createQuery(hql).getResultList();
	}

	public Mark getMarkById(int idMark) {
		return entityManager.find(Mark.class, idMark);
	}

	public void addMark(Mark m) {
		entityManager.persist(m);

	}

	public void updateMark(Mark m) {
		Mark mark = getMarkById(m.getIdMark());
		mark.setIdMark(m.getIdMark());
		mark.setDate(m.getDate());
		mark.setStudent(m.getStudent());
		mark.setSubject(m.getSubject());
		mark.setMark(m.getMark());
		entityManager.flush();
	}

	public void deleteMark(int idMark) {
		entityManager.remove(getMarkById(idMark));

	}

	public boolean MarkExists(Stud s, Date date) {
		String hql = "FROM Mark as m WHERE m.student = ? and m.date = ?";
		int count = entityManager.createQuery(hql).setParameter(1, s).setParameter(2, date).getResultList().size();

		return count > 0 ? true : false;
	}

}
