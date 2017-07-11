package com.cga.Spcell.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.cga.Spcell.dao.ModeloDao;
import com.cga.Spcell.model.Marca;
import com.cga.Spcell.model.Modelo;

@Service("modeloService")
@Transactional
public class ModeloServiceImpl implements ModeloService {
	
	@Autowired
	private  ModeloDao _modeloDao;
	
	@Override
	public void saveModelo(Modelo modelo) {
		_modeloDao.saveModelo(modelo);
	}

	@Override
	public List<Modelo> findAllModelos() {
		// TODO Auto-generated method stub
		return _modeloDao.findAllModelos();
	}

	@Override
	public void deleteModeloById(Long idModelo) {
		_modeloDao.deleteModeloById(idModelo);
		
	}

	@Override
	public void updateModelo(Modelo modelo) {
		_modeloDao.updateModelo(modelo);
		
	}

	@Override
	public Modelo findById(Long idModelo) {
		// TODO Auto-generated method stub
		return _modeloDao.findById(idModelo);
	}




	@Override
	public List<Modelo> findByMarca(Long idMarca) {
		// TODO Auto-generated method stub
		return _modeloDao.findByMarca(idMarca);
	}

	@Override
	public Modelo findByNombre(String nombre) {
		// TODO Auto-generated method stub
		return _modeloDao.findByNombre(nombre);
	}

	@Override
	public Modelo findByIdMarca(Long idMarca) {
		return _modeloDao.findByIdMarca(idMarca);
	}

}
