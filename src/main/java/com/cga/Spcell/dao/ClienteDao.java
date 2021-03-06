package com.cga.Spcell.dao;

import java.util.List;

import com.cga.Spcell.model.Cliente;



public interface ClienteDao {
	void saveCliente (Cliente cliente);
	
	List <Cliente> findAllClientes();
	
	void deleteClienteById(Long idCliente);
	
	void updateCliente(Cliente cliente);
	
	Cliente findById(Long idCliente);
	
	Cliente findByNombre(String nombre);
	
	
}
