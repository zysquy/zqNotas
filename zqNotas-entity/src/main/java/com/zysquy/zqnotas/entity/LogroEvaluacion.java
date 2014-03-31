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
 * The persistent class for the logro_evaluacion database table.
 * 
 */
@Entity
@Table(name="logro_evaluacion")
@NamedQuery(name="LogroEvaluacion.findAll", query="SELECT l FROM LogroEvaluacion l")
public class LogroEvaluacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	private Float nota;

	private String uuid;

	//bi-directional many-to-one association to LogroEvalItem
	@OneToMany(mappedBy="logroEvaluacion")
	private List<LogroEvalItem> logrosEvaluacionItems;

	//bi-directional many-to-one association to Evaluacion
	@ManyToOne
	private Evaluacion evaluacion;

	//bi-directional many-to-one association to LogroAsigEval
	@ManyToOne
	@JoinColumn(name="logro_asig_eval_id")
	private LogroAsigEval logroAsigEval;

	public LogroEvaluacion() {
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

	public List<LogroEvalItem> getLogrosEvaluacionItems() {
		return this.logrosEvaluacionItems;
	}

	public void setLogrosEvaluacionItems(List<LogroEvalItem> logrosEvaluacionItems) {
		this.logrosEvaluacionItems = logrosEvaluacionItems;
	}

	public LogroEvalItem addLogrosEvaluacionItem(LogroEvalItem logrosEvaluacionItem) {
		getLogrosEvaluacionItems().add(logrosEvaluacionItem);
		logrosEvaluacionItem.setLogroEvaluacion(this);

		return logrosEvaluacionItem;
	}

	public LogroEvalItem removeLogrosEvaluacionItem(LogroEvalItem logrosEvaluacionItem) {
		getLogrosEvaluacionItems().remove(logrosEvaluacionItem);
		logrosEvaluacionItem.setLogroEvaluacion(null);

		return logrosEvaluacionItem;
	}

	public Evaluacion getEvaluacion() {
		return this.evaluacion;
	}

	public void setEvaluacion(Evaluacion evaluacion) {
		this.evaluacion = evaluacion;
	}

	public LogroAsigEval getLogroAsigEval() {
		return this.logroAsigEval;
	}

	public void setLogroAsigEval(LogroAsigEval logroAsigEval) {
		this.logroAsigEval = logroAsigEval;
	}

}