package com.vstu.service;

import java.util.List;

import com.vstu.entity.Stud;

public interface IStudService {
	List<Stud> getAllStud();

	Stud getStudById(int idStud);

	boolean addStud(Stud s);

	void updateStud(Stud s);

	void deleteStud(int idStud);

}
