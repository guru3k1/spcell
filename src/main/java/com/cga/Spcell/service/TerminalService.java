package com.cga.Spcell.service;

import java.util.List;


import com.cga.Spcell.model.Terminal;

public interface TerminalService {
	void saveTerminal (Terminal terminal); //Guardar Terminal

	void deleteTerminalById(Long idTerminal); //Eliminar Terminal

	void updateTerminal(Terminal terminal); //Actualizar Terminal

	Terminal findById(Long idTerminal); //Buscar Terminal por nro de Id

	List<Terminal> findByIdModelo(Long idModelo); // Buscar la terminal por el nombre del modelo
	
	Terminal findBySerie(String numero_serie); //Buscar la terminal por numero de serie
	
	List<Terminal> findAllTerminales();
}
