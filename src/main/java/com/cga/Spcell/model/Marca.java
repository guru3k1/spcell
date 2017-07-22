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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;


@Entity
@Table(name="marca")
public class Marca implements Serializable{
	
	@Id
	@Column(name="id_marca")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idMarca;
	
	@Column(name="marca")
	private String marca;
	
	//Entidad Padre
	@OneToMany (mappedBy="marca",cascade = CascadeType.MERGE)
	//@JoinColumn(name="id_marca")
	private Set<Modelo>modelos;
	
	public Marca(Long idMarca) {
		super();
		this.idMarca = idMarca;
	}
	public Marca() {
		super();
	}
	public Marca(String marca) {
		super();
		this.marca = marca;
	}
	public Long getIdMarca() {
		return idMarca;
	}
	public void setIdMarca(Long idMarca) {
		this.idMarca = idMarca;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	
	public String toString (){
		return marca;
		
	}
}
