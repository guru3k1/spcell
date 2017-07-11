package com.cga.Spcell.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cga.Spcell.dao.TerminalDao;
import com.cga.Spcell.model.Terminal;
@Service("terminalService")
@Transactional
public class TerminalServiceImpl implements TerminalService {
	
	@Autowired
	private TerminalDao _terminalDao;
	
	@Override
	public void saveTerminal(Terminal terminal) {
		
		_terminalDao.saveTerminal(terminal);
	}

	@Override
	public void deleteTerminalById(Long idTerminal) {
		// TODO Auto-generated method stub
		_terminalDao.deleteTerminalById(idTerminal);
	}

	@Override
	public void updateTerminal(Terminal terminal) {
		// TODO Auto-generated method stub
		_terminalDao.updateTerminal(terminal);
	}

	@Override
	public Terminal findById(Long idTerminal) {
		// TODO Auto-generated method stub
		return _terminalDao.findById(idTerminal);
	}

	@Override
	public List<Terminal> findByIdModelo(Long idModelo) {
		// TODO Auto-generated method stub
		return _terminalDao.findByIdModelo(idModelo);
	}

	@Override
	public Terminal findBySerie(String numero_serie) {
		// TODO Auto-generated method stub
		return _terminalDao.findBySerie(numero_serie);
	}

	@Override
	public List<Terminal> findAllTerminales() {
		// TODO Auto-generated method stub
		return _terminalDao.findAllTerminales();
	}

}
