package com.cga.Spcell.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cga.Spcell.dao.OrdenDao;
import com.cga.Spcell.model.Orden;

@Service("ordenService")
@Transactional

public class OrdenServiceImpl implements OrdenService{
	@Autowired
	private OrdenDao _ordenDao;
	
	@Override
	public void saveOrden(Orden orden) {
		// TODO Auto-generated method stub
		_ordenDao.saveOrden(orden);
	}

	@Override
	public List<Orden> findAllOrdens() {
		// TODO Auto-generated method stub
		return _ordenDao.findAllOrdens();
	}

	@Override
	public void deleteOrdenById(Long idOrden) {
		// TODO Auto-generated method stub
		_ordenDao.deleteOrdenById(idOrden);
	}

	@Override
	public void updateOrden(Orden orden) {
		// TODO Auto-generated method stub
		_ordenDao.updateOrden(orden);
	}

	@Override
	public Orden findById(Long idOrden) {
		// TODO Auto-generated method stub
		return _ordenDao.findById(idOrden);
	}

	@Override
	public Orden findByName(String name) {
		// TODO Auto-generated method stub
		return _ordenDao.findByName(name);
		
	}

}
