package com.cga.Spcell.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name="terminal")
public class Terminal implements Serializable{
	@Id
	@Column(name="id_terminal")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idTerminal;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="id_marca")
	private Marca marca;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="id_modelo")
	private Modelo modelo;
	
	@Column(name="numero_serie")
	private String numero_serie;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="id_cliente")
	@JsonIgnore
	private Cliente cliente;
	
	
	public Terminal() {
		super();
	}
	
	public Terminal(Marca marca, Modelo modelo, String numero_serie, Cliente cliente) {
		super();
		this.marca = marca;
		this.modelo = modelo;
		this.numero_serie = numero_serie;
	}

	public Long getIdTerminal() {
		return idTerminal;
	}
	public void setIdTerminal(Long idTerminal) {
		this.idTerminal = idTerminal;
	}
	
	public Marca getMarca() {
		return marca;
	}
	public void setMarca(Marca marca) {
		this.marca = marca;
	}
	
	public Modelo getModelo() {
		return modelo;
	}
	public void setModelo(Modelo modelo) {
		this.modelo = modelo;
	}
	public String getNumero_serie() {
		return numero_serie;
	}
	public void setNumero_serie(String numero_serie) {
		this.numero_serie = numero_serie;
	} 
	
	
}
