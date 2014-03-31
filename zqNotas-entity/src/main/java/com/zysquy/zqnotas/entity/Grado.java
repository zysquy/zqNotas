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
 * The persistent class for the grado database table.
 * 
 */
@Entity
@NamedQuery(name="Grado.findAll", query="SELECT g FROM Grado g")
public class Grado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	private String uuid;

	//bi-directional many-to-one association to Asignatura
	@OneToMany(mappedBy="grado")
	private List<Asignatura> asignaturas;

	//bi-directional many-to-one association to Estudiante
	@OneToMany(mappedBy="grado")
	private List<Estudiante> estudiantes;

	//bi-directional many-to-one association to PeriodoLectivo
	@ManyToOne
	@JoinColumn(name="periodo_lectivo_id")
	private PeriodoLectivo periodoLectivo;

	//bi-directional many-to-one association to TipoGrado
	@ManyToOne
	@JoinColumn(name="tipo_grado_id")
	private TipoGrado tipoGrado;

	//bi-directional many-to-one association to Grupo
	@OneToMany(mappedBy="grado")
	private List<Grupo> grupos;

	//bi-directional many-to-one association to PeriodoEvaluacion
	@OneToMany(mappedBy="grado")
	private List<PeriodoEvaluacion> periodosEvaluacion;

	public Grado() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUuid() {
		return this.uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public List<Asignatura> getAsignaturas() {
		return this.asignaturas;
	}

	public void setAsignaturas(List<Asignatura> asignaturas) {
		this.asignaturas = asignaturas;
	}

	public Asignatura addAsignatura(Asignatura asignatura) {
		getAsignaturas().add(asignatura);
		asignatura.setGrado(this);

		return asignatura;
	}

	public Asignatura removeAsignatura(Asignatura asignatura) {
		getAsignaturas().remove(asignatura);
		asignatura.setGrado(null);

		return asignatura;
	}

	public List<Estudiante> getEstudiantes() {
		return this.estudiantes;
	}

	public void setEstudiantes(List<Estudiante> estudiantes) {
		this.estudiantes = estudiantes;
	}

	public Estudiante addEstudiante(Estudiante estudiante) {
		getEstudiantes().add(estudiante);
		estudiante.setGrado(this);

		return estudiante;
	}

	public Estudiante removeEstudiante(Estudiante estudiante) {
		getEstudiantes().remove(estudiante);
		estudiante.setGrado(null);

		return estudiante;
	}

	public PeriodoLectivo getPeriodoLectivo() {
		return this.periodoLectivo;
	}

	public void setPeriodoLectivo(PeriodoLectivo periodoLectivo) {
		this.periodoLectivo = periodoLectivo;
	}

	public TipoGrado getTipoGrado() {
		return this.tipoGrado;
	}

	public void setTipoGrado(TipoGrado tipoGrado) {
		this.tipoGrado = tipoGrado;
	}

	public List<Grupo> getGrupos() {
		return this.grupos;
	}

	public void setGrupos(List<Grupo> grupos) {
		this.grupos = grupos;
	}

	public Grupo addGrupo(Grupo grupo) {
		getGrupos().add(grupo);
		grupo.setGrado(this);

		return grupo;
	}

	public Grupo removeGrupo(Grupo grupo) {
		getGrupos().remove(grupo);
		grupo.setGrado(null);

		return grupo;
	}

	public List<PeriodoEvaluacion> getPeriodosEvaluacion() {
		return this.periodosEvaluacion;
	}

	public void setPeriodosEvaluacion(List<PeriodoEvaluacion> periodosEvaluacion) {
		this.periodosEvaluacion = periodosEvaluacion;
	}

	public PeriodoEvaluacion addPeriodosEvaluacion(PeriodoEvaluacion periodosEvaluacion) {
		getPeriodosEvaluacion().add(periodosEvaluacion);
		periodosEvaluacion.setGrado(this);

		return periodosEvaluacion;
	}

	public PeriodoEvaluacion removePeriodosEvaluacion(PeriodoEvaluacion periodosEvaluacion) {
		getPeriodosEvaluacion().remove(periodosEvaluacion);
		periodosEvaluacion.setGrado(null);

		return periodosEvaluacion;
	}

}