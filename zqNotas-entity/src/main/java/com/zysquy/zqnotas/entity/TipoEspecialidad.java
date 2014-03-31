/*******************************************************************************
 * Copyright (c) 2014 Zysquy.
 * All rights reserved. This file is part of zqNotas.
 *
 * zqNotas is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License version 3 as published by
 * the Free Software Foundation.
 * 	
 * zqNotas is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Foobar.  If not, see <http://www.gnu.org/licenses/>.
 *     
 * Contributors:
 *     Zysquy - initial implementation
 *******************************************************************************/
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