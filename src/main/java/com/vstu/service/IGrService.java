package com.vstu.service;

import java.util.List;

import com.vstu.entity.Gr;

public interface IGrService {
	List<Gr> getAllGr();

	Gr getGrById(int idGr);

	boolean addGr(Gr g);

	void updateGr(Gr g);

	void deleteGr(int idGr);

}
