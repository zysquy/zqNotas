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
 * The persistent class for the acudiente database table.
 * 
 */
@Entity
@NamedQuery(name="Acudiente.findAll", query="SELECT a FROM Acudiente a")
public class Acudiente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@SequenceGenerator(name="acudiente_id_seq")
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

	//bi-directional many-to-one association to Estudiante
	@OneToMany(mappedBy="acudiente")
	private List<Estudiante> estudiantes;

	public Acudiente() {
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

	public List<Estudiante> getEstudiantes() {
		return this.estudiantes;
	}

	public void setEstudiantes(List<Estudiante> estudiantes) {
		this.estudiantes = estudiantes;
	}

	public Estudiante addEstudiante(Estudiante estudiante) {
		getEstudiantes().add(estudiante);
		estudiante.setAcudiente(this);

		return estudiante;
	}

	public Estudiante removeEstudiante(Estudiante estudiante) {
		getEstudiantes().remove(estudiante);
		estudiante.setAcudiente(null);

		return estudiante;
	}

}