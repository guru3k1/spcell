package com.cga.Spcell.dao;

import java.util.List;

import com.cga.Spcell.model.Orden;

public interface OrdenDao {

	void saveOrden(Orden orden);

	List<Orden> findAllOrdens();

	void deleteOrdenById(Long idOrden);

	void updateOrden(Orden orden);

	Orden findById(Long idOrden);

	Orden findByName(String name);

}
