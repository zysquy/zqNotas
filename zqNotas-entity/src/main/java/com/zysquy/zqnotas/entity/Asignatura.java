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
 * The persistent class for the asignatura database table.
 * 
 */
@Entity
@NamedQuery(name="Asignatura.findAll", query="SELECT a FROM Asignatura a")
public class Asignatura implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	@Column(name="intensidad_horaria")
	private Short intensidadHoraria;

	private String uuid;

	//bi-directional many-to-one association to Grado
	@ManyToOne
	private Grado grado;

	//bi-directional many-to-one association to Profesor
	@ManyToOne
	private Profesor profesor;

	//bi-directional many-to-one association to TipoAsignatura
	@ManyToOne
	@JoinColumn(name="tipo_asignatura_id")
	private TipoAsignatura tipoAsignatura;

	//bi-directional many-to-one association to Evaluacion
	@OneToMany(mappedBy="asignatura")
	private List<Evaluacion> evaluaciones;

	//bi-directional many-to-one association to LogroAsigEval
	@OneToMany(mappedBy="asignatura")
	private List<LogroAsigEval> logrosAsignaturaEvaluacion;

	public Asignatura() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Short getIntensidadHoraria() {
		return this.intensidadHoraria;
	}

	public void setIntensidadHoraria(Short intensidadHoraria) {
		this.intensidadHoraria = intensidadHoraria;
	}

	public String getUuid() {
		return this.uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public Grado getGrado() {
		return this.grado;
	}

	public void setGrado(Grado grado) {
		this.grado = grado;
	}

	public Profesor getProfesor() {
		return this.profesor;
	}

	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}

	public TipoAsignatura getTipoAsignatura() {
		return this.tipoAsignatura;
	}

	public void setTipoAsignatura(TipoAsignatura tipoAsignatura) {
		this.tipoAsignatura = tipoAsignatura;
	}

	public List<Evaluacion> getEvaluaciones() {
		return this.evaluaciones;
	}

	public void setEvaluaciones(List<Evaluacion> evaluaciones) {
		this.evaluaciones = evaluaciones;
	}

	public Evaluacion addEvaluacione(Evaluacion evaluacione) {
		getEvaluaciones().add(evaluacione);
		evaluacione.setAsignatura(this);

		return evaluacione;
	}

	public Evaluacion removeEvaluacione(Evaluacion evaluacione) {
		getEvaluaciones().remove(evaluacione);
		evaluacione.setAsignatura(null);

		return evaluacione;
	}

	public List<LogroAsigEval> getLogrosAsignaturaEvaluacion() {
		return this.logrosAsignaturaEvaluacion;
	}

	public void setLogrosAsignaturaEvaluacion(List<LogroAsigEval> logrosAsignaturaEvaluacion) {
		this.logrosAsignaturaEvaluacion = logrosAsignaturaEvaluacion;
	}

	public LogroAsigEval addLogrosAsignaturaEvaluacion(LogroAsigEval logrosAsignaturaEvaluacion) {
		getLogrosAsignaturaEvaluacion().add(logrosAsignaturaEvaluacion);
		logrosAsignaturaEvaluacion.setAsignatura(this);

		return logrosAsignaturaEvaluacion;
	}

	public LogroAsigEval removeLogrosAsignaturaEvaluacion(LogroAsigEval logrosAsignaturaEvaluacion) {
		getLogrosAsignaturaEvaluacion().remove(logrosAsignaturaEvaluacion);
		logrosAsignaturaEvaluacion.setAsignatura(null);

		return logrosAsignaturaEvaluacion;
	}

}