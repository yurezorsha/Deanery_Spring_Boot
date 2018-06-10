package com.vstu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vstu.dao.IStudDAO;
import com.vstu.entity.Stud;

@Service
public class StudService implements IStudService {

	@Autowired
	private IStudDAO studDAO;

	public List<Stud> getAllStud() {

		return studDAO.getAllStud();
	}

	public Stud getStudById(int idStud) {
		Stud obj = studDAO.getStudById(idStud);
		return obj;
	}

	public synchronized boolean addStud(Stud s) {
		if (studDAO.studExists(s.getFirstName(), s.getSurName())) {
			return false;
		} else {
			studDAO.addStud(s);

			return true;
		}
	}

	public void updateStud(Stud s) {
		studDAO.updateStud(s);

	}

	public void deleteStud(int idStud) {
		studDAO.deleteStud(idStud);

	}

}
