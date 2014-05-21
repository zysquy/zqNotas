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

import org.hibernate.annotations.Type;

import java.util.List;
import java.util.UUID;


/**
 * The persistent class for the tipo_periodo database table.
 * 
 */
@Entity
@Table(name="tipo_periodo")
@NamedQuery(name="TipoPeriodo.findAll", query="SELECT t FROM TipoPeriodo t")
public class TipoPeriodo implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = -6382218200768577064L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@SequenceGenerator(name="tipo_periodo_id_seq")
	private Short id;

	private String descripcion;

	private String estado;

	private String nombre;

	@Type(type="pg-uuid")
	private UUID uuid;

	//bi-directional many-to-one association to PeriodoLectivo
	@OneToMany(mappedBy="tipoPeriodo")
	private List<PeriodoLectivo> periodosLectivos;

	public TipoPeriodo() {
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

	public UUID getUuid() {
		return uuid;
	}

	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}

	public List<PeriodoLectivo> getPeriodosLectivos() {
		return this.periodosLectivos;
	}

	public void setPeriodosLectivos(List<PeriodoLectivo> periodosLectivos) {
		this.periodosLectivos = periodosLectivos;
	}

	public PeriodoLectivo addPeriodosLectivo(PeriodoLectivo periodosLectivo) {
		getPeriodosLectivos().add(periodosLectivo);
		periodosLectivo.setTipoPeriodo(this);

		return periodosLectivo;
	}

	public PeriodoLectivo removePeriodosLectivo(PeriodoLectivo periodosLectivo) {
		getPeriodosLectivos().remove(periodosLectivo);
		periodosLectivo.setTipoPeriodo(null);

		return periodosLectivo;
	}

}