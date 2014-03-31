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


/**
 * The persistent class for the logro_eval_item_det database table.
 * 
 */
@Entity
@Table(name="logro_eval_item_det")
@NamedQuery(name="LogroEvalItemDet.findAll", query="SELECT l FROM LogroEvalItemDet l")
public class LogroEvalItemDet implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	private Float nota;

	private String uuid;

	//bi-directional many-to-one association to LogroAsigEvalItemDet
	@ManyToOne
	@JoinColumn(name="logro_asig_eval_item_det_id")
	private LogroAsigEvalItemDet logroAsigEvalItemDet;

	//bi-directional many-to-one association to LogroEvalItem
	@ManyToOne
	@JoinColumn(name="logro_eval_item_id")
	private LogroEvalItem logroEvalItem;

	public LogroEvalItemDet() {
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

	public String getUuid() {
		return this.uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public LogroAsigEvalItemDet getLogroAsigEvalItemDet() {
		return this.logroAsigEvalItemDet;
	}

	public void setLogroAsigEvalItemDet(LogroAsigEvalItemDet logroAsigEvalItemDet) {
		this.logroAsigEvalItemDet = logroAsigEvalItemDet;
	}

	public LogroEvalItem getLogroEvalItem() {
		return this.logroEvalItem;
	}

	public void setLogroEvalItem(LogroEvalItem logroEvalItem) {
		this.logroEvalItem = logroEvalItem;
	}

}