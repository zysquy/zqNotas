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
import java.util.UUID;


/**
 * The persistent class for the persona database table.
 * 
 */
@Entity
@NamedQuery(name="Persona.findAll", query="SELECT p FROM Persona p")
public class Persona implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@SequenceGenerator(name="persona_id_seq")
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

	@Type(type="pg-uuid")
	private UUID uuid;

	//bi-directional many-to-one association to TipoDocumento
	@ManyToOne
	@JoinColumn(name="tipo_documento_id")
	private TipoDocumento tipoDocumento;

	public Persona() {
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

	public UUID getUuid() {
		return uuid;
	}

	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}

	public TipoDocumento getTipoDocumento() {
		return this.tipoDocumento;
	}

	public void setTipoDocumento(TipoDocumento tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

}