package com.cga.Spcell.controller;


import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.UriComponentsBuilder;

import com.cga.Spcell.model.Marca;

import com.cga.Spcell.service.MarcaService;
import com.cga.Spcell.util.CustomErrorType;


@Controller
@RequestMapping("/v1")
public class MarcaController {

	@Autowired
	MarcaService _marcaService;

	// GET
	@CrossOrigin
	@RequestMapping(value = "/marcas", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<List<Marca>> getMarcas(@RequestParam(value = "marca", required = false) String marca) {
		List<Marca> marcas = new ArrayList<>();

		if (marca == null) {
			marcas = _marcaService.findAllMarcas();
			if (marcas.isEmpty()) {
				return new ResponseEntity(new CustomErrorType("IdMarca is required"), HttpStatus.CONFLICT);
			}
			
			return new ResponseEntity<List<Marca>>(marcas, HttpStatus.OK);
		} else {
			Marca marcaza = _marcaService.findByNombre(marca);
			if (marcaza == null) {
				return new ResponseEntity(HttpStatus.NOT_FOUND);
			}
			marcas.add(marcaza);
		}
		return new ResponseEntity<List<Marca>>(marcas, HttpStatus.OK);
	}

	// GET
	@RequestMapping(value = "/marcas/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<Marca> getMarcaById(@PathVariable("id") Long idMarca) {

		if (idMarca == null || idMarca <= 0) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		Marca marca = _marcaService.findById(idMarca);
		if (marca == null) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<Marca>(marca, HttpStatus.OK);
	}

	// POST
	@RequestMapping(value = "/marcas", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<?> createMarca(@RequestBody Marca marca, UriComponentsBuilder uricomponentsbuilder) {
		if (marca.getMarca().equals(null) || marca.getMarca().isEmpty()) {
			return new ResponseEntity(new CustomErrorType("Marca name is required"), HttpStatus.CONFLICT);
		}
		if (_marcaService.findByNombre(marca.getMarca()) != null) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		_marcaService.saveMarca(marca);
		Marca marca2 = _marcaService.findByNombre(marca.getMarca());
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uricomponentsbuilder.path("/v1/marcas/{id}").buildAndExpand(marca2.getIdMarca()).toUri());
		return new ResponseEntity<String>(headers, HttpStatus.CREATED);
	}

	// UPDATE
	@RequestMapping(value = "/marcas/{id}", method = RequestMethod.PATCH, headers = "Accept=application/json")
	public ResponseEntity<?> updateMarca(@PathVariable("id") Long idMarca, @RequestBody Marca marca) {
		if (idMarca == null || idMarca <= 0) {

		}
		Marca currentMarca = _marcaService.findById(idMarca);
		if (currentMarca == null) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		currentMarca.setMarca(marca.getMarca());

		_marcaService.updateMarca(marca);

		return new ResponseEntity<Marca>(currentMarca, HttpStatus.OK);
	}
	// DELETE

	@RequestMapping(value = "/marcas/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public ResponseEntity<?> deleteMarca(@PathVariable("id") Long idMarca) {
		if (idMarca == null || idMarca <= 0) {
			return new ResponseEntity(new CustomErrorType("IdMarca is required"), HttpStatus.CONFLICT);
		}
		Marca marca = _marcaService.findById(idMarca);
		if (marca == null) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		_marcaService.deleteMarcaById(idMarca);
		return new ResponseEntity<Marca>(HttpStatus.OK);
	}

	public static final String MARCA_UPLOADED_FOLDER = "images/Marcas/";

	// CREATE IMAGE - Metodo no implementado
	@RequestMapping(value = "/marcas/images", method = RequestMethod.POST, headers = ("content-type=multipart/form-data"))
	public ResponseEntity<byte[]> uploadImage(@RequestParam("id_marca") Long idMarca,
			@RequestParam("file") MultipartFile multipartFile, UriComponentsBuilder componentsBuilder) {
		if (idMarca == null) {
			return new ResponseEntity(new CustomErrorType("IdMarca is required"), HttpStatus.CONFLICT);
		}
		if (multipartFile.isEmpty()) {
			return new ResponseEntity(new CustomErrorType("Please select a file to upload"), HttpStatus.CONFLICT);
		}
		Marca marca = _marcaService.findById(idMarca);
		if (marca == null) {
			return new ResponseEntity(new CustomErrorType("Marca con idMarca: " + idMarca + " not found"),
					HttpStatus.CONFLICT);
		}
		/*
		 * if (!marca.getLogo().isEmpty() || marca.getLogo() !=null ) {
		 * //implementar metodos version final String filename =
		 * marca.getLogo(); Path path = Path.get(filename); File f =
		 * path.toFile(); if (f.exists()) { f.delete(); } }
		 */
		try {
			Date date = new Date();
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
			String dateName = dateFormat.format(date);

			String fileName = String.valueOf(idMarca) + "-pictureMarca-" + dateName + "."
					+ multipartFile.getContentType().split("/")[1];
			// marca.setLogo(MARCA_UPLOADED_FOLDER + fileName); //implementar
			// metodos version final
			byte[] bytes = multipartFile.getBytes();
			Path path = Paths.get(MARCA_UPLOADED_FOLDER + fileName);
			Files.write(path, bytes);

			_marcaService.updateMarca(marca);
			return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(bytes);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return new ResponseEntity(
					new CustomErrorType("Error during upload: " + multipartFile.getOriginalFilename()),
					HttpStatus.CONFLICT);
		}

	}
}
