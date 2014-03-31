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
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the periodo_evaluacion database table.
 * 
 */
@Entity
@Table(name="periodo_evaluacion")
@NamedQuery(name="PeriodoEvaluacion.findAll", query="SELECT p FROM PeriodoEvaluacion p")
public class PeriodoEvaluacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_final")
	private Date fechaFinal;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_inicial")
	private Date fechaInicial;

	private String nombre;

	private Short numero;

	private Float porcentaje;

	private String uuid;

	//bi-directional many-to-one association to Evaluacion
	@OneToMany(mappedBy="periodoEvaluacion")
	private List<Evaluacion> evaluaciones;

	//bi-directional many-to-one association to LogroAsigEval
	@OneToMany(mappedBy="periodoEvaluacion")
	private List<LogroAsigEval> logrosAsignaturaEvaluacion;

	//bi-directional many-to-one association to Grado
	@ManyToOne
	private Grado grado;

	public PeriodoEvaluacion() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getFechaFinal() {
		return this.fechaFinal;
	}

	public void setFechaFinal(Date fechaFinal) {
		this.fechaFinal = fechaFinal;
	}

	public Date getFechaInicial() {
		return this.fechaInicial;
	}

	public void setFechaInicial(Date fechaInicial) {
		this.fechaInicial = fechaInicial;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Short getNumero() {
		return this.numero;
	}

	public void setNumero(Short numero) {
		this.numero = numero;
	}

	public Float getPorcentaje() {
		return this.porcentaje;
	}

	public void setPorcentaje(Float porcentaje) {
		this.porcentaje = porcentaje;
	}

	public String getUuid() {
		return this.uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public List<Evaluacion> getEvaluaciones() {
		return this.evaluaciones;
	}

	public void setEvaluaciones(List<Evaluacion> evaluaciones) {
		this.evaluaciones = evaluaciones;
	}

	public Evaluacion addEvaluacione(Evaluacion evaluacione) {
		getEvaluaciones().add(evaluacione);
		evaluacione.setPeriodoEvaluacion(this);

		return evaluacione;
	}

	public Evaluacion removeEvaluacione(Evaluacion evaluacione) {
		getEvaluaciones().remove(evaluacione);
		evaluacione.setPeriodoEvaluacion(null);

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
		logrosAsignaturaEvaluacion.setPeriodoEvaluacion(this);

		return logrosAsignaturaEvaluacion;
	}

	public LogroAsigEval removeLogrosAsignaturaEvaluacion(LogroAsigEval logrosAsignaturaEvaluacion) {
		getLogrosAsignaturaEvaluacion().remove(logrosAsignaturaEvaluacion);
		logrosAsignaturaEvaluacion.setPeriodoEvaluacion(null);

		return logrosAsignaturaEvaluacion;
	}

	public Grado getGrado() {
		return this.grado;
	}

	public void setGrado(Grado grado) {
		this.grado = grado;
	}

}