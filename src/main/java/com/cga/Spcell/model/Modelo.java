package com.cga.Spcell.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="modelo_marca")
public class Modelo  implements Serializable {
	
	@Id
	@Column(name="id_modelo")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idModelo;
	
	@Column(name="nombre")
	private String nombre;
	
	//Entidad Hijo
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="id_marca")
	//@JsonIgnore
	private Marca marca;






	public Modelo() {
		super();
	}

	public Modelo(String nombre, Marca marca) {
		super();
		this.nombre = nombre;
		this.marca = marca;
	}

	public Long getIdModelo() {
		return idModelo;
	}

	public void setIdModelo(Long idModelo) {
		this.idModelo = idModelo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Marca getMarca() {
		return  marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}
	
	public String toString(){
		return nombre;
	}
	
	
}