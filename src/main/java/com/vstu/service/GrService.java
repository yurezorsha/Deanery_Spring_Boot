package com.vstu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vstu.dao.IGrDAO;
import com.vstu.entity.Gr;

@Service
public class GrService implements IGrService {
	@Autowired
	IGrDAO grDAO;

	public List<Gr> getAllGr() {

		return grDAO.getAllGr();
	}

	public Gr getGrById(int idGr) {
		Gr obj = grDAO.getGrById(idGr);
		return obj;
	}

	public boolean addGr(Gr g) {
		if (grDAO.grExists(g.getName())) {
			return false;
		} else {
			grDAO.addGr(g);

			return true;
		}
	}

	public void updateGr(Gr g) {
		grDAO.updateGr(g);

	}

	public void deleteGr(int idGr) {
		grDAO.deleteGr(idGr);

	}

}
