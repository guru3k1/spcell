package com.cga.Spcell.service;

import java.util.List;

import com.cga.Spcell.model.Orden;

public interface OrdenService {

	void saveOrden(Orden orden);

	List<Orden> findAllOrdens();

	void deleteOrdenById(Long idOrden);

	void updateOrden(Orden orden);

	Orden findById(Long idOrden);

	Orden findByName(String name);
}
