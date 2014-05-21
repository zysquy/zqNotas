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
 * The persistent class for the evaluacion database table.
 * 
 */
@Entity
@NamedQuery(name="Evaluacion.findAll", query="SELECT e FROM Evaluacion e")
public class Evaluacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@SequenceGenerator(name="evaluacion_id_seq")
	private Integer id;

	private Float nota;

	private String recomendacion;

	@Type(type="pg-uuid")
	private UUID uuid;

	//bi-directional many-to-one association to Asignatura
	@ManyToOne
	private Asignatura asignatura;

	//bi-directional many-to-one association to Estudiante
	@ManyToOne
	private Estudiante estudiante;

	//bi-directional many-to-one association to PeriodoEvaluacion
	@ManyToOne
	@JoinColumn(name="periodo_evaluacion_id")
	private PeriodoEvaluacion periodoEvaluacion;

	//bi-directional many-to-one association to LogroEvaluacion
	@OneToMany(mappedBy="evaluacion")
	private List<LogroEvaluacion> logrosEvaluacion;

	public Evaluacion() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Float getNota() {
		return this.nota;
	}

	public void setNota(Float nota) {
		this.nota = nota;
	}

	public String getRecomendacion() {
		return this.recomendacion;
	}

	public void setRecomendacion(String recomendacion) {
		this.recomendacion = recomendacion;
	}

	public UUID getUuid() {
		return uuid;
	}

	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}

	public Asignatura getAsignatura() {
		return this.asignatura;
	}

	public void setAsignatura(Asignatura asignatura) {
		this.asignatura = asignatura;
	}

	public Estudiante getEstudiante() {
		return this.estudiante;
	}

	public void setEstudiante(Estudiante estudiante) {
		this.estudiante = estudiante;
	}

	public PeriodoEvaluacion getPeriodoEvaluacion() {
		return this.periodoEvaluacion;
	}

	public void setPeriodoEvaluacion(PeriodoEvaluacion periodoEvaluacion) {
		this.periodoEvaluacion = periodoEvaluacion;
	}

	public List<LogroEvaluacion> getLogrosEvaluacion() {
		return this.logrosEvaluacion;
	}

	public void setLogrosEvaluacion(List<LogroEvaluacion> logrosEvaluacion) {
		this.logrosEvaluacion = logrosEvaluacion;
	}

	public LogroEvaluacion addLogrosEvaluacion(LogroEvaluacion logrosEvaluacion) {
		getLogrosEvaluacion().add(logrosEvaluacion);
		logrosEvaluacion.setEvaluacion(this);

		return logrosEvaluacion;
	}

	public LogroEvaluacion removeLogrosEvaluacion(LogroEvaluacion logrosEvaluacion) {
		getLogrosEvaluacion().remove(logrosEvaluacion);
		logrosEvaluacion.setEvaluacion(null);

		return logrosEvaluacion;
	}

}