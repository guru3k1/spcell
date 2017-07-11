package com.cga.Spcell.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cga.Spcell.dao.MarcaDao;

import com.cga.Spcell.model.Marca;
@Service("marcaService")
@Transactional
public class MarcaServiceImpl implements MarcaService {
	
	@Autowired
	private  MarcaDao _marcaDao;
	
	@Override
	public void saveMarca(Marca marca) {
		// TODO Auto-generated method stub
		_marcaDao.saveMarca(marca);
	}

	@Override
	public List<Marca> findAllMarcas() {
		// TODO Auto-generated method stub
		return _marcaDao.findAllMarcas();
	}

	@Override
	public List<Marca> findByMarca(Long idMarca) {
		// TODO Auto-generated method stub
		return _marcaDao.findByMarca(idMarca);
	}

	@Override
	public void deleteMarcaById(Long idMarca) {
		// TODO Auto-generated method stub
		_marcaDao.deleteMarcaById(idMarca);
	}

	@Override
	public void updateMarca(Marca marca) {
		_marcaDao.updateMarca(marca);
		
	}

	@Override
	public Marca findById(Long idMarca) {
		// TODO Auto-generated method stub
		return _marcaDao.findById(idMarca);
	}

	@Override
	public Marca findByNombre(String name) {
		// TODO Auto-generated method stub
		return _marcaDao.findByName(name);
	}

}
