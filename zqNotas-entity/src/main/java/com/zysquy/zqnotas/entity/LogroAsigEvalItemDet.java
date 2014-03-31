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
 * The persistent class for the logro_asig_eval_item_det database table.
 * 
 */
@Entity
@Table(name="logro_asig_eval_item_det")
@NamedQuery(name="LogroAsigEvalItemDet.findAll", query="SELECT l FROM LogroAsigEvalItemDet l")
public class LogroAsigEvalItemDet implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	private String nombre;

	private Float porcentaje;

	private String uuid;

	//bi-directional many-to-one association to LogroAsigEvalItem
	@ManyToOne
	@JoinColumn(name="logro_asig_eval_item_id")
	private LogroAsigEvalItem logroAsigEvalItem;

	//bi-directional many-to-one association to LogroEvalItemDet
	@OneToMany(mappedBy="logroAsigEvalItemDet")
	private List<LogroEvalItemDet> logrosEvaluacionItems;

	public LogroAsigEvalItemDet() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
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

	public LogroAsigEvalItem getLogroAsigEvalItem() {
		return this.logroAsigEvalItem;
	}

	public void setLogroAsigEvalItem(LogroAsigEvalItem logroAsigEvalItem) {
		this.logroAsigEvalItem = logroAsigEvalItem;
	}

	public List<LogroEvalItemDet> getLogrosEvaluacionItems() {
		return this.logrosEvaluacionItems;
	}

	public void setLogrosEvaluacionItems(List<LogroEvalItemDet> logrosEvaluacionItems) {
		this.logrosEvaluacionItems = logrosEvaluacionItems;
	}

	public LogroEvalItemDet addLogrosEvaluacionItem(LogroEvalItemDet logrosEvaluacionItem) {
		getLogrosEvaluacionItems().add(logrosEvaluacionItem);
		logrosEvaluacionItem.setLogroAsigEvalItemDet(this);

		return logrosEvaluacionItem;
	}

	public LogroEvalItemDet removeLogrosEvaluacionItem(LogroEvalItemDet logrosEvaluacionItem) {
		getLogrosEvaluacionItems().remove(logrosEvaluacionItem);
		logrosEvaluacionItem.setLogroAsigEvalItemDet(null);

		return logrosEvaluacionItem;
	}

}