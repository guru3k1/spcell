package com.cga.Spcell.model;

import java.io.Serializable;
import java.util.Date;

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

@Entity
@Table(name="orden")
public class Orden implements Serializable{
	@Id
	@Column(name="id_orden")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idOrden;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="id_cliente")
	private Cliente cliente;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Terminal terminal;
	
	@Column(name="estado_reparacion")
	private Long estado_reparacion;
	
	@Column(name="fecha_ingreso")
	private Date fecha_ingreso;
	
	@Column(name="fecha_aprobado")
	private Date fecha_aprobado;
	
	@Column(name="fecha_reparado")
	private Date fecha_reparado;
	
	@Column(name="estado_aprobacion")
	private String estado_aprobacion;
	
	@Column(name="desc_falla")
	private String desc_falla;
	
	@Column(name="desc_estado")
	private String desc_estado;
	
	@Column(name="estado_garantia")
	private Long estado_garantia;
	
	
	
	public Orden() {
		super();
	}
	public Orden(Cliente cliente, Terminal terminal, Long estado_reparacion, Date fecha_ingreso, 
			 String desc_falla, String desc_estado) {
		super();
		this.cliente = cliente;
		this.terminal = terminal;
		this.estado_reparacion = estado_reparacion;
		this.fecha_ingreso = fecha_ingreso;
		this.desc_falla = desc_falla;
		this.desc_estado = desc_estado;
	}
	public Long getIdOrden() {
		return idOrden;
	}
	public void setIdOrden(Long idOrden) {
		this.idOrden = idOrden;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Terminal getTerminal() {
		return terminal;
	}
	public void setTerminal(Terminal terminal) {
		this.terminal = terminal;
	}
	public Long getEstado_reparacion() {
		return estado_reparacion;
	}
	public void setEstado_reparacion(Long estado_reparacion) {
		this.estado_reparacion = estado_reparacion;
	}
	public Date getFecha_ingreso() {
		return fecha_ingreso;
	}
	public void setFecha_ingreso(Date fecha_ingreso) {
		this.fecha_ingreso = fecha_ingreso;
	}
	public Date getFecha_aprobado() {
		return fecha_aprobado;
	}
	public void setFecha_aprobado(Date fecha_aprobado) {
		this.fecha_aprobado = fecha_aprobado;
	}
	public Date getFecha_reparado() {
		return fecha_reparado;
	}
	public void setFecha_reparado(Date fecha_reparado) {
		this.fecha_reparado = fecha_reparado;
	}
	public String getEstado_aprobacion() {
		return estado_aprobacion;
	}
	public void setEstado_aprobacion(String estado_aprobacion) {
		this.estado_aprobacion = estado_aprobacion;
	}
	public String getDesc_falla() {
		return desc_falla;
	}
	public void setDesc_falla(String desc_falla) {
		this.desc_falla = desc_falla;
	}
	public String getDesc_estado() {
		return desc_estado;
	}
	public void setDesc_estado(String desc_estado) {
		this.desc_estado = desc_estado;
	}
	public Long getEstado_garantia() {
		return estado_garantia;
	}
	public void setEstado_garantia(Long estado_garantia) {
		this.estado_garantia = estado_garantia;
	}
	
	
	
}
