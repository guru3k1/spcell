package com.cga.Spcell.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cga.Spcell.dao.ClienteDao;
import com.cga.Spcell.model.Cliente;
@Service("clienteService")
@Transactional
public class ClienteServiceImpl implements ClienteService {
	
	@Autowired
	private  ClienteDao _clienteDao;
	
	
	@Override
	public void saveCliente(Cliente cliente) {
		_clienteDao.saveCliente(cliente);
		
	}

	@Override
	public List<Cliente> findAllClientes() {
		// TODO Auto-generated method stub
		return _clienteDao.findAllClientes();
	}

	@Override
	public void deleteClienteById(Long idCliente) {
		_clienteDao.deleteClienteById(idCliente);
		
	}

	@Override
	public void updateCliente(Cliente cliente) {
		// TODO Auto-generated method stub
		_clienteDao.updateCliente(cliente);
	}

	@Override
	public Cliente findById(Long idCliente) {
		// TODO Auto-generated method stub
		return _clienteDao.findById(idCliente);
	}

	@Override
	public Cliente findByNombre(String nombre) {
		// TODO Auto-generated method stub
		return _clienteDao.findByNombre(nombre);
	}

}
