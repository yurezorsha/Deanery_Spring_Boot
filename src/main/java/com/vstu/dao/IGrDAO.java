package com.vstu.dao;

import java.util.List;

import com.vstu.entity.Gr;

public interface IGrDAO {
	List<Gr> getAllGr();

	Gr getGrById(int idGr);

	void addGr(Gr g);

	void updateGr(Gr g);

	void deleteGr(int idGr);

	boolean grExists(String name);

}
