package com.zysquy.zqnotas.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tipo_especialidad database table.
 * 
 */
@Entity
@Table(name="tipo_especialidad")
@NamedQuery(name="TipoEspecialidad.findAll", query="SELECT t FROM TipoEspecialidad t")
public class TipoEspecialidad implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Short id;

	private String descripcion;

	private String estado;

	private String nombre;

	private String uuid;

	//bi-directional many-to-one association to EstablecimientoEducativo
	@OneToMany(mappedBy="tipoEspecialidad")
	private List<EstablecimientoEducativo> establecimientosEducativos;

	public TipoEspecialidad() {
	}

	public Short getId() {
		return this.id;
	}

	public void setId(Short id) {
		this.id = id;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getUuid() {
		return this.uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public List<EstablecimientoEducativo> getEstablecimientosEducativos() {
		return this.establecimientosEducativos;
	}

	public void setEstablecimientosEducativos(List<EstablecimientoEducativo> establecimientosEducativos) {
		this.establecimientosEducativos = establecimientosEducativos;
	}

	public EstablecimientoEducativo addEstablecimientosEducativo(EstablecimientoEducativo establecimientosEducativo) {
		getEstablecimientosEducativos().add(establecimientosEducativo);
		establecimientosEducativo.setTipoEspecialidad(this);

		return establecimientosEducativo;
	}

	public EstablecimientoEducativo removeEstablecimientosEducativo(EstablecimientoEducativo establecimientosEducativo) {
		getEstablecimientosEducativos().remove(establecimientosEducativo);
		establecimientosEducativo.setTipoEspecialidad(null);

		return establecimientosEducativo;
	}

}