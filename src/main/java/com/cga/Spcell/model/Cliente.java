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
import javax.persistence.Table;



@Entity
@Table(name="cliente")
public class Cliente implements Serializable{
	
	@Id
	@Column(name="id_cliente")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idCliente;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="apellido")
	private String apellido;
	
	@Column(name="telefono")
	private String telefono;
	
	@Column(name="celular")
	private String celular;
	
	@Column(name="email")
	private String email;
	
	@OneToMany (mappedBy="cliente")
	
	private Set<Terminal>terminales;
	
	@OneToMany(mappedBy="idOrden")
	private Set<Orden>ordenes;
	
	
	public Set<Terminal> getTerminales() {
		return terminales;
	}
	public void setTerminales(Set<Terminal> terminales) {
		this.terminales = terminales;
	}
	public Set<Orden> getOrdenes() {
		return ordenes;
	}
	public void setOrdenes(Set<Orden> ordenes) {
		this.ordenes = ordenes;
	}
	
	
	
	public Cliente(Long idCliente) {
		super();
		this.idCliente = idCliente;
	}
	public Cliente() {
		super();
	}
	public Cliente(String nombre, String apellido, String telefono, String celular, String email) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.telefono = telefono;
		this.celular = celular;
		this.email = email;
	}
	public Long getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getCelular() {
		return celular;
	}
	public void setCelular(String celular) {
		this.celular = celular;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String toString (){
		return nombre +" "+ apellido;
	}
}
