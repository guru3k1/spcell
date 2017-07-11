package com.cga.Spcell.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cga.Spcell.model.Terminal;
import com.cga.Spcell.service.TerminalService;
import com.cga.Spcell.util.CustomErrorType;

@Controller
@RequestMapping("/v1")
public class TerminalController {

		@Autowired
		TerminalService _terminalService;
		
		  // GET
	@RequestMapping(value = "/terminales", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<List<Terminal>> getTerminals(@RequestParam(value = "serie", required = false) String numero_serie) {
		List<Terminal> terminales = new ArrayList<>();

		if (numero_serie == null) {
			terminales = _terminalService.findAllTerminales();
			if (terminales.isEmpty()) {
				return new ResponseEntity(new CustomErrorType("IMEI is required"), HttpStatus.CONFLICT);
			}
			return new ResponseEntity<List<Terminal>>(terminales, HttpStatus.OK);
		} else {
			Terminal terminaliza = (Terminal)_terminalService.findBySerie(numero_serie);
			
			if (terminaliza == null) {
				return new ResponseEntity(HttpStatus.NOT_FOUND);
			}
			terminales.add(terminaliza);
		}
		return new ResponseEntity<List<Terminal>>(terminales, HttpStatus.OK);
	}
		 
		 
}
