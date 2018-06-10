package com.vstu.dao;

import java.util.List;

import com.vstu.entity.Stud;

public interface IStudDAO {
	List<Stud> getAllStud();

	Stud getStudById(int idStud);

	void addStud(Stud s);

	void updateStud(Stud s);

	void deleteStud(int idStud);

	boolean studExists(String firstName, String surName);
}
