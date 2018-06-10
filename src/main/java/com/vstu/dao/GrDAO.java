package com.vstu.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.vstu.entity.Gr;

@Transactional
@Repository
public class GrDAO implements IGrDAO {

	@PersistenceContext
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	public List<Gr> getAllGr() {
		String hql = "from Gr";
		return entityManager.createQuery(hql).getResultList();

	}

	public Gr getGrById(int idGr) {

		return entityManager.find(Gr.class, idGr);
	}

	public void addGr(Gr g) {
		entityManager.persist(g);

	}

	public void updateGr(Gr g) {
		Gr gr = getGrById(g.getIdGroup());
		gr.setIdGroup(g.getIdGroup());
		gr.setName(g.getName());
		gr.setStudCollection(g.getStudCollection());
		entityManager.flush();
	}

	public void deleteGr(int idGr) {
		entityManager.remove(getGrById(idGr));

	}

	public boolean grExists(String name) {
		String hql = "FROM Gr as g WHERE g.name = ? ";
		int count = entityManager.createQuery(hql).setParameter(1, name).getResultList().size();

		return count > 0 ? true : false;
	}

}
