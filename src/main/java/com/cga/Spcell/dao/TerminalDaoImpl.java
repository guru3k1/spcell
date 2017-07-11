package com.cga.Spcell.dao;

import com.cga.Spcell.model.Terminal;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class TerminalDaoImpl extends AbstractSession implements TerminalDao{

	@Override
	public void saveTerminal(Terminal terminal) {
		getSession().persist(terminal);
	}

	@Override
	public void deleteTerminalById(Long idTerminal) {
		Terminal terminal = findById(idTerminal);
		if (terminal != null){
			getSession().delete(terminal);
		}
	}

	@Override
	public void updateTerminal(Terminal terminal) {
		getSession().update(terminal);
	}

	@Override
	public Terminal findById(Long idTerminal) {
		// TODO Auto-generated method stub
		return (Terminal) getSession().get(Terminal.class, idTerminal);
	}


	@Override
	public Terminal findBySerie(String numero_serie) {
		// TODO Auto-generated method stub
		return (Terminal) getSession().createQuery("from Terminal Where numero_serie = :numero_serie")
				.setParameter("numero_serie", numero_serie).uniqueResult();
	}

	@Override
	public List<Terminal> findByIdModelo(Long idModelo) {
		return (List<Terminal>) getSession()
				.createQuery("from Terminal t join c.modelo m where c.idModelo = :idModelo")
				.setParameter("idModelo", idModelo).list();
	}

	@Override
	public List<Terminal> findAllTerminales() {
		// TODO Auto-generated method stub
		return (List<Terminal>) getSession().createQuery("from Terminal").list();
	}

}
