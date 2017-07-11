package com.cga.Spcell.controller;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.UriComponentsBuilder;

import com.cga.Spcell.model.Marca;
import com.cga.Spcell.model.Modelo;
import com.cga.Spcell.model.Modelo;
import com.cga.Spcell.model.Terminal;
import com.cga.Spcell.service.ModeloService;
import com.cga.Spcell.service.ModeloService;
import com.cga.Spcell.util.CustomErrorType;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/v1")
public class ModeloController {
	@Autowired
	ModeloService _modeloService;

	// GET ALL /By NAME
	@CrossOrigin
	@RequestMapping(value = "/modelos", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<List<Modelo>> getModelos(@RequestParam(value = "nombre", required = false) String nombre,
			@RequestParam(value = "idMarca", required = false) Long idMarca) {
		List<Modelo> modelos = new ArrayList<>();

		if (nombre == null && idMarca == null) {
			modelos = _modeloService.findAllModelos();
			if (modelos.isEmpty()) {
				return new ResponseEntity(HttpStatus.NO_CONTENT);
			}
			System.out.println("Estoy saliendo por arriba del by name");
			return new ResponseEntity<List<Modelo>>(modelos, HttpStatus.OK);
		} else {

			Modelo modelo = _modeloService.findByNombre(nombre);

			if (modelo == null) {
				return new ResponseEntity(HttpStatus.NOT_FOUND);
			} else {
				modelos.add(modelo);
			}
		}
		System.out.println("Estoy saliendo por abajo");
		return new ResponseEntity<List<Modelo>>(modelos, HttpStatus.OK);
	}

	// GET ALL /by MARCA
	@RequestMapping(value = "/modelosm", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<List<Modelo>> getModelosbymarca(
			@RequestParam(value = "idMarca", required = false) Long idMarca) {
		List<Modelo> modelos = new ArrayList<>();

		if (idMarca == null) {
			modelos = _modeloService.findAllModelos();
			if (modelos.isEmpty()) {
				return new ResponseEntity(HttpStatus.NO_CONTENT);
			}
			System.out.println("Estoy saliendo por arriba del by marca");
			return new ResponseEntity<List<Modelo>>(modelos, HttpStatus.OK);
		} else {
			Long longi = (long) 1;
			// Modelo modelo = _modeloService.findByNombre(nombre);
			Modelo modelo2 = _modeloService.findByIdMarca((long) 1);
			/*
			 * String a = modelo2.getMarca().toString(); System.out.println(a);
			 * 
			 * /*
			 * 
			 * Marca lamarca = modelo.getMarca();
			 * System.out.println(lamarca.getMarca()); /* if (modelo== null ) {
			 * return new ResponseEntity(HttpStatus.NOT_FOUND); }else{
			 * modelos.add(modelo); } if ( lamarca.getMarca()== null ) { return
			 * new ResponseEntity(HttpStatus.NOT_FOUND); }else{
			 * 
			 * modelos.add(modelo); }
			 * System.out.println(modelo.getNombre()+lamarca.getMarca());
			 */

		}
		System.out.println("Estoy saliendo por abajo");
		return new ResponseEntity<List<Modelo>>(modelos, HttpStatus.OK);
	}

	// GET
	@RequestMapping(value = "/modelos/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<Modelo> getModeloById(@PathVariable("id") Long idModelo) {

		if (idModelo == null || idModelo <= 0) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		Modelo modelo = _modeloService.findById(idModelo);
		if (modelo == null) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<Modelo>(modelo, HttpStatus.OK);
	}

	// POST
	@RequestMapping(value = "/modelos", method = RequestMethod.POST, headers = "Accept=application/json")

	public ResponseEntity<?> createModelo(@RequestBody Modelo modelo, UriComponentsBuilder uricomponentsbuilder) {

		if (modelo.getNombre().equals(null) || modelo.getNombre().isEmpty()) {
			return new ResponseEntity(new CustomErrorType("Nombre is required"), HttpStatus.CONFLICT);
		}
		if (_modeloService.findByNombre(modelo.getNombre()) != null) {

			return new ResponseEntity(new CustomErrorType("The name already exists"), HttpStatus.CONFLICT);
		}

		_modeloService.saveModelo(modelo); // Carga el objeto a la base

		Modelo modelocurrent = _modeloService.findByNombre(modelo.getNombre());

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(
				uricomponentsbuilder.path("/v1/modelos/{id}").buildAndExpand(modelocurrent.getIdModelo()).toUri());
		return new ResponseEntity(headers, HttpStatus.CREATED);
	}

	// UPDATE
	@RequestMapping(value = "/modelos/{id}", method = RequestMethod.PATCH, headers = "Accept=application/json")
	public ResponseEntity<?> updateModelo(@PathVariable("id") Long idModelo, @RequestBody Modelo modelo) {

		if (idModelo == null || idModelo <= 0) {
			return new ResponseEntity(new CustomErrorType("The Id is required"), HttpStatus.CONFLICT);
		}
		Modelo currentModelo = _modeloService.findById(idModelo);

		if (currentModelo == null) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		if (modelo.getMarca() != null) {
			Marca marcademodelo = modelo.getMarca();
			Marca currentmarcademodelo = currentModelo.getMarca();
			System.out.println(marcademodelo.getIdMarca());

			if (marcademodelo.getIdMarca() != currentmarcademodelo.getIdMarca()) {
				currentmarcademodelo.setIdMarca(marcademodelo.getIdMarca());
			}

		} else {
			System.out.println("la marca es null");
		}
		currentModelo.setNombre(modelo.getNombre());

		_modeloService.updateModelo(currentModelo);

		return new ResponseEntity<Modelo>(currentModelo, HttpStatus.OK);
	}
	// DELETE

	@RequestMapping(value = "/modelos/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public ResponseEntity<?> deleteModelo(@PathVariable("id") Long idModelo) {
		if (idModelo == null || idModelo <= 0) {
			return new ResponseEntity(new CustomErrorType("IdModelo is required"), HttpStatus.CONFLICT);
		}
		Modelo modelo = _modeloService.findById(idModelo);
		if (modelo == null) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		_modeloService.deleteModeloById(idModelo);
		return new ResponseEntity(HttpStatus.OK);
	}
}
