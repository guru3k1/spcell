package com.cga.Spcell.service;

import java.util.List;

import com.cga.Spcell.model.Marca;

public interface MarcaService {
void saveMarca (Marca Marca);
	
	List <Marca> findAllMarcas();
	
	List <Marca> findByMarca(Long idMarca);
	
	void deleteMarcaById(Long idMarca);
	
	void updateMarca(Marca Marca);
	
	Marca findById(Long idMarca);
	
	Marca findByNombre(String name);
}
