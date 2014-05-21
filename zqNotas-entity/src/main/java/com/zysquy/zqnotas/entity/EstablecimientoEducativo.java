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
 * The persistent class for the establecimiento_educativo database table.
 * 
 */
@Entity
@Table(name="establecimiento_educativo")
@NamedQuery(name="EstablecimientoEducativo.findAll", query="SELECT e FROM EstablecimientoEducativo e")
public class EstablecimientoEducativo implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3786001299657619793L;

	@Id
	@SequenceGenerator(name="establecimiento_educativo_id_seq", sequenceName="establecimiento_educativo_id_seq", allocationSize=1)
	@GeneratedValue(generator="establecimiento_educativo_id_seq", strategy=GenerationType.SEQUENCE)	
	private Integer id;

	private Short dv;

	private String email;

	private String nit;

	@Column(name="razon_social")
	private String razonSocial;

	private String url;

	@Type(type="pg-uuid")
	private UUID uuid = UUID.randomUUID();

	//bi-directional many-to-one association to TipoEspecialidad
	@ManyToOne
	@JoinColumn(name="tipo_especialidad_id")
	private TipoEspecialidad tipoEspecialidad;

	//bi-directional many-to-one association to PeriodoLectivo
	@OneToMany(mappedBy="establecimientoEducativo")	
	private List<PeriodoLectivo> periodosLectivos;

	public EstablecimientoEducativo() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Short getDv() {
		return this.dv;
	}

	public void setDv(Short dv) {
		this.dv = dv;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNit() {
		return this.nit;
	}

	public void setNit(String nit) {
		this.nit = nit;
	}

	public String getRazonSocial() {
		return this.razonSocial;
	}

	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public UUID getUuid() {
		return uuid;
	}

	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}

	public TipoEspecialidad getTipoEspecialidad() {
		return this.tipoEspecialidad;
	}

	public void setTipoEspecialidad(TipoEspecialidad tipoEspecialidad) {
		this.tipoEspecialidad = tipoEspecialidad;
	}

	public List<PeriodoLectivo> getPeriodosLectivos() {
		return this.periodosLectivos;
	}

	public void setPeriodosLectivos(List<PeriodoLectivo> periodosLectivos) {
		this.periodosLectivos = periodosLectivos;
	}

	public PeriodoLectivo addPeriodosLectivo(PeriodoLectivo periodosLectivo) {
		getPeriodosLectivos().add(periodosLectivo);
		periodosLectivo.setEstablecimientoEducativo(this);

		return periodosLectivo;
	}

	public PeriodoLectivo removePeriodosLectivo(PeriodoLectivo periodosLectivo) {
		getPeriodosLectivos().remove(periodosLectivo);
		periodosLectivo.setEstablecimientoEducativo(null);

		return periodosLectivo;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("EstablecimientoEducativo [id=");
		builder.append(id);
		builder.append(", dv=");
		builder.append(dv);
		builder.append(", email=");
		builder.append(email);
		builder.append(", nit=");
		builder.append(nit);
		builder.append(", razonSocial=");
		builder.append(razonSocial);
		builder.append(", url=");
		builder.append(url);
		builder.append(", uuid=");
		builder.append(uuid);
		builder.append("]");
		return builder.toString();
	}

	
	
}