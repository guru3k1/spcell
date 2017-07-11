package com.cga.Spcell.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.cga.Spcell.model.Orden;
@Repository
@Transactional
public class OrdenDaoImpl extends AbstractSession implements  OrdenDao{

	@Override
	public void saveOrden(Orden orden) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Orden> findAllOrdens() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteOrdenById(Long idOrden) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateOrden(Orden orden) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Orden findById(Long idOrden) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Orden findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}
