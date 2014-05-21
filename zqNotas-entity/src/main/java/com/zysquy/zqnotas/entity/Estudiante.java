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

import java.util.Date;
import java.util.List;
import java.util.UUID;


/**
 * The persistent class for the estudiante database table.
 * 
 */
@Entity
@NamedQuery(name="Estudiante.findAll", query="SELECT e FROM Estudiante e")
public class Estudiante implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@SequenceGenerator(name="estudiante_id_seq")
	private Integer id;

	private String apellido1;

	private String apellido2;

	private String email;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_nacimiento")
	private Date fechaNacimiento;

	@Column(name="nombre_fin")
	private String nombreFin;

	@Column(name="nombre_ini")
	private String nombreIni;

	@Column(name="numero_documento")
	private String numeroDocumento;

	@Column(name="tipo_documento_id")
	private Short tipoDocumentoId;

	@Type(type="pg-uuid")
	private UUID uuid;

	//bi-directional many-to-one association to Acudiente
	@ManyToOne
	private Acudiente acudiente;

	//bi-directional many-to-one association to Grado
	@ManyToOne
	private Grado grado;

	//bi-directional many-to-one association to PeriodoLectivo
	@ManyToOne
	@JoinColumn(name="periodo_lectivo_id")
	private PeriodoLectivo periodoLectivo;

	//bi-directional many-to-one association to Evaluacion
	@OneToMany(mappedBy="estudiante")
	private List<Evaluacion> evaluaciones;

	public Estudiante() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getApellido1() {
		return this.apellido1;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	public String getApellido2() {
		return this.apellido2;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getFechaNacimiento() {
		return this.fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getNombreFin() {
		return this.nombreFin;
	}

	public void setNombreFin(String nombreFin) {
		this.nombreFin = nombreFin;
	}

	public String getNombreIni() {
		return this.nombreIni;
	}

	public void setNombreIni(String nombreIni) {
		this.nombreIni = nombreIni;
	}

	public String getNumeroDocumento() {
		return this.numeroDocumento;
	}

	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}

	public Short getTipoDocumentoId() {
		return this.tipoDocumentoId;
	}

	public void setTipoDocumentoId(Short tipoDocumentoId) {
		this.tipoDocumentoId = tipoDocumentoId;
	}

	public UUID getUuid() {
		return uuid;
	}

	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}

	public Acudiente getAcudiente() {
		return this.acudiente;
	}

	public void setAcudiente(Acudiente acudiente) {
		this.acudiente = acudiente;
	}

	public Grado getGrado() {
		return this.grado;
	}

	public void setGrado(Grado grado) {
		this.grado = grado;
	}

	public PeriodoLectivo getPeriodoLectivo() {
		return this.periodoLectivo;
	}

	public void setPeriodoLectivo(PeriodoLectivo periodoLectivo) {
		this.periodoLectivo = periodoLectivo;
	}

	public List<Evaluacion> getEvaluaciones() {
		return this.evaluaciones;
	}

	public void setEvaluaciones(List<Evaluacion> evaluaciones) {
		this.evaluaciones = evaluaciones;
	}

	public Evaluacion addEvaluacione(Evaluacion evaluacione) {
		getEvaluaciones().add(evaluacione);
		evaluacione.setEstudiante(this);

		return evaluacione;
	}

	public Evaluacion removeEvaluacione(Evaluacion evaluacione) {
		getEvaluaciones().remove(evaluacione);
		evaluacione.setEstudiante(null);

		return evaluacione;
	}

}