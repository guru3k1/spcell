package com.cga.Spcell.service;

import java.util.List;

import com.cga.Spcell.model.Modelo;



public interface ModeloService {
	void saveModelo (Modelo modelo);
	
	List <Modelo> findAllModelos();
	
	List <Modelo> findByMarca(Long idMarca);
	
	void deleteModeloById(Long idModelo);
	
	void updateModelo(Modelo modelo);
	
	Modelo findById(Long idModelo);
	
	Modelo findByNombre(String nombre);
	Modelo findByIdMarca (Long idMarca);
}
