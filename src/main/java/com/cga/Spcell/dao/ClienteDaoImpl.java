package com.cga.Spcell.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.cga.Spcell.model.Cliente;

@Repository
@Transactional
public class ClienteDaoImpl  extends AbstractSession implements ClienteDao {
	
	
	
	
	

	public void saveCliente(Cliente cliente) {
		getSession().persist(cliente);
	}

	public List<Cliente>findAllClientes() {
		// TODO Auto-generated method stub
		return getSession().createQuery("from Cliente").list();
	}

	public void deleteClienteById(Long idCliente) {
		Cliente cliente = findById(idCliente);
		if (cliente != null) {
			getSession().delete(cliente);
		}
		
	}

	public void updateCliente(Cliente cliente) {
		getSession().update(cliente);
		
	}

	public Cliente findById(Long idCliente) {
		// TODO Auto-generated method stub
		return (Cliente)getSession().get(Cliente.class,idCliente);
	}

	public Cliente findByNombre(String nombre) {
		// TODO Auto-generated method stub
		return (Cliente)getSession().createQuery("from Cliente Where nombre = :nombre").setParameter("nombre", nombre).uniqueResult();
	}



}
