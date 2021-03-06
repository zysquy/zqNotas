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
import java.util.List;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Type;


/**
 * The persistent class for the periodo_lectivo database table.
 * 
 */
@Entity
@Table(name="periodo_lectivo")
@NamedQuery(name="PeriodoLectivo.findAll", query="SELECT p FROM PeriodoLectivo p")
public class PeriodoLectivo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@SequenceGenerator(name="periodo_lectivo_id_seq")
	private Integer id;

	@Column(name="numero_periodo")
	private Short numeroPeriodo;

	@Type(type="pg-uuid")
	private UUID uuid;

	//bi-directional many-to-one association to Estudiante
	@OneToMany(mappedBy="periodoLectivo")
	private List<Estudiante> estudiantes;

	//bi-directional many-to-one association to Grado
	@OneToMany(mappedBy="periodoLectivo")
	private List<Grado> grados;

	//bi-directional many-to-one association to EstablecimientoEducativo
	@ManyToOne
	@JoinColumn(name="establecimiento_educativo_id")
	private EstablecimientoEducativo establecimientoEducativo;

	//bi-directional many-to-one association to TipoPeriodo
	@ManyToOne
	@JoinColumn(name="tipo_periodo_id")
	private TipoPeriodo tipoPeriodo;

	//bi-directional many-to-one association to Profesor
	@OneToMany(mappedBy="periodoLectivo")
	private List<Profesor> profesores;

	public PeriodoLectivo() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Short getNumeroPeriodo() {
		return this.numeroPeriodo;
	}

	public void setNumeroPeriodo(Short numeroPeriodo) {
		this.numeroPeriodo = numeroPeriodo;
	}

	public UUID getUuid() {
		return uuid;
	}

	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}

	public List<Estudiante> getEstudiantes() {
		return this.estudiantes;
	}

	public void setEstudiantes(List<Estudiante> estudiantes) {
		this.estudiantes = estudiantes;
	}

	public Estudiante addEstudiante(Estudiante estudiante) {
		getEstudiantes().add(estudiante);
		estudiante.setPeriodoLectivo(this);

		return estudiante;
	}

	public Estudiante removeEstudiante(Estudiante estudiante) {
		getEstudiantes().remove(estudiante);
		estudiante.setPeriodoLectivo(null);

		return estudiante;
	}

	public List<Grado> getGrados() {
		return this.grados;
	}

	public void setGrados(List<Grado> grados) {
		this.grados = grados;
	}

	public Grado addGrado(Grado grado) {
		getGrados().add(grado);
		grado.setPeriodoLectivo(this);

		return grado;
	}

	public Grado removeGrado(Grado grado) {
		getGrados().remove(grado);
		grado.setPeriodoLectivo(null);

		return grado;
	}

	public EstablecimientoEducativo getEstablecimientoEducativo() {
		return this.establecimientoEducativo;
	}

	public void setEstablecimientoEducativo(EstablecimientoEducativo establecimientoEducativo) {
		this.establecimientoEducativo = establecimientoEducativo;
	}

	public TipoPeriodo getTipoPeriodo() {
		return this.tipoPeriodo;
	}

	public void setTipoPeriodo(TipoPeriodo tipoPeriodo) {
		this.tipoPeriodo = tipoPeriodo;
	}

	public List<Profesor> getProfesores() {
		return this.profesores;
	}

	public void setProfesores(List<Profesor> profesores) {
		this.profesores = profesores;
	}

	public Profesor addProfesore(Profesor profesore) {
		getProfesores().add(profesore);
		profesore.setPeriodoLectivo(this);

		return profesore;
	}

	public Profesor removeProfesore(Profesor profesore) {
		getProfesores().remove(profesore);
		profesore.setPeriodoLectivo(null);

		return profesore;
	}

}