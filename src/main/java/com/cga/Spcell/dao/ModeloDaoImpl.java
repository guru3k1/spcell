package com.cga.Spcell.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.cga.Spcell.model.Marca;
import com.cga.Spcell.model.Modelo;
@Repository
@Transactional
public class ModeloDaoImpl extends AbstractSession implements ModeloDao{

	@Override
	public void saveModelo(Modelo modelo) {
		// TODO Auto-generated method stub
		getSession().persist(modelo);
	}

	@Override
	public List<Modelo> findAllModelos() {
		//Para busqueda de todo mostrando solo marca y modelo
		//return getSession().createQuery("select mod.marca.marca as Marca, mod.modelo as Modelo from Modelo mod ORDER BY Marca, Modelo ").list();
		return getSession().createQuery("from Modelo").list();
		
	}
	/*.createQuery("from Terminal t join c.modelo m where c.idModelo = :idModelo")
	.setParameter("idModelo", idModelo).list();*/
	@Override
	public void deleteModeloById(Long idModelo) {
		Modelo modelo = findById(idModelo);
		if (modelo != null) {
			getSession().delete(modelo);
		}
	}

	@Override
	public void updateModelo(Modelo modelo) {
		getSession().update(modelo);
		
	}

	@Override
	public Modelo findById(Long idModelo) {
		// TODO Auto-generated method stub
		return (Modelo)getSession().get(Modelo.class,idModelo);
	}

	@Override
	public Modelo findByNombre(String nombre) {
		// TODO Auto-generated method stub
		return(Modelo)getSession().createQuery("from Modelo Where nombre = :nombre").setParameter("nombre", nombre).uniqueResult();
	}

	@Override
	public List<Modelo> findByMarca(Long idMarca) {
		// TODO Auto-generated method stub
		 return getSession()
				 .createQuery("from Modelo mod Where mod.marca.idMarca = :idMarca")
				 .setParameter("idMarca", idMarca).list();
	}

	@Override
	public Modelo findByIdMarca(Long idMarca) {
		
		return(Modelo)getSession().createQuery("from Modelo Where marca = :marca").setParameter("marca", idMarca).uniqueResult();
	}

}
