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

import com.cga.Spcell.model.Cliente;
import com.cga.Spcell.service.ClienteService;

@Controller
@RequestMapping("/v1")
public class ClienteController {

	@Autowired
	ClienteService _clienteService;

	// GET ALL /By NAME
	@RequestMapping(value = "/clientes", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<List<Cliente>> getClientes(@RequestParam(value = "nombre", required = false) String nombre) {
		List<Cliente> clientes = new ArrayList<>();

		if (nombre == null ) {
			clientes = _clienteService.findAllClientes();
			if (clientes.isEmpty()) {
				return new ResponseEntity(HttpStatus.NO_CONTENT);
			}
			
			return new ResponseEntity<List<Cliente>>(clientes, HttpStatus.OK);
		} else {

			Cliente cliente = _clienteService.findByNombre(nombre);

			if (cliente == null) {
				return new ResponseEntity(HttpStatus.NOT_FOUND);
			} else {
				clientes.add(cliente);
			}
		}
		
		return new ResponseEntity<List<Cliente>>(clientes, HttpStatus.OK);
	}

}
