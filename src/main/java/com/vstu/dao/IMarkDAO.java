package com.vstu.dao;

import java.util.Date;
import java.util.List;

import com.vstu.entity.Mark;
import com.vstu.entity.Stud;

public interface IMarkDAO {
	List<Mark> getAllMark();

	Mark getMarkById(int idMark);

	void addMark(Mark m);

	void updateMark(Mark m);

	void deleteMark(int idMark);

	boolean MarkExists(Stud s, Date date);

}
