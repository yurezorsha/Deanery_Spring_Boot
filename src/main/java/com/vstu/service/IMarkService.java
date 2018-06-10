package com.vstu.service;

import java.util.List;

import com.vstu.entity.Mark;

public interface IMarkService {
	List<Mark> getAllMark();

	Mark getMarkById(int idMark);

	boolean addMark(Mark m);

	void updateMark(Mark m);

	void deleteMark(int idMark);

}
