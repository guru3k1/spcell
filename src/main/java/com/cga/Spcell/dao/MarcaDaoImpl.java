package com.cga.Spcell.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.cga.Spcell.model.Cliente;
import com.cga.Spcell.model.Marca;
@Repository
@Transactional
public class MarcaDaoImpl extends AbstractSession implements MarcaDao  {

	@Override
	public void saveMarca(Marca marca) {
		// TODO Auto-generated method stub
		getSession().persist(marca);
	}

	@Override
	public List<Marca> findAllMarcas() {
		// TODO Auto-generated method stub
		return getSession().createQuery("from Marca").list();
	}

	@Override
	public List<Marca> findByMarca(Long idMarca) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteMarcaById(Long idMarca) {
		// TODO Auto-generated method stub
		Marca marca = findById(idMarca);
		if (marca != null) {
			getSession().delete(marca);
		}
	}

	@Override
	public void updateMarca(Marca marca) {
		getSession().update(marca);
		
	}

	@Override
	public Marca findById(Long idMarca) {
		// TODO Auto-generated method stub
		return (Marca)getSession().get(Marca.class,idMarca);
	}

	@Override
	public Marca findByName(String name) {
		// TODO Auto-generated method stub
		return (Marca)getSession().createQuery("from Marca Where marca = :name").setParameter("name", name).uniqueResult();
	}

}
