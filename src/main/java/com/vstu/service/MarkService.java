package com.vstu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vstu.dao.IMarkDAO;
import com.vstu.entity.Mark;

@Service
public class MarkService implements IMarkService {
	@Autowired
	private IMarkDAO markDAO;

	public List<Mark> getAllMark() {

		return markDAO.getAllMark();
	}

	public Mark getMarkById(int idMark) {
		Mark obj = markDAO.getMarkById(idMark);
		return obj;
	}

	public synchronized boolean addMark(Mark m) {
		if (markDAO.MarkExists(m.getStudent(), m.getDate())) {
			return false;
		} else {
			markDAO.addMark(m);

			return true;
		}
	}

	public void updateMark(Mark m) {
		markDAO.updateMark(m);

	}

	public void deleteMark(int idMark) {
		markDAO.deleteMark(idMark);

	}

}
