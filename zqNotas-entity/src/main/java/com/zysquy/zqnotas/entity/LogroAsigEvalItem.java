package com.zysquy.zqnotas.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the logro_asig_eval_item database table.
 * 
 */
@Entity
@Table(name="logro_asig_eval_item")
@NamedQuery(name="LogroAsigEvalItem.findAll", query="SELECT l FROM LogroAsigEvalItem l")
public class LogroAsigEvalItem implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	private String nombre;

	private Float porcentaje;

	private String uuid;

	//bi-directional many-to-one association to LogroAsigEval
	@ManyToOne
	@JoinColumn(name="logro_asig_eval_id")
	private LogroAsigEval logroAsigEval;

	//bi-directional many-to-one association to LogroAsigEvalItemDet
	@OneToMany(mappedBy="logroAsigEvalItem")
	private List<LogroAsigEvalItemDet> logrosAsignaturaEvaluacionItem;

	//bi-directional many-to-one association to LogroEvalItem
	@OneToMany(mappedBy="logroAsigEvalItem")
	private List<LogroEvalItem> logrosEvaluacionItems;

	public LogroAsigEvalItem() {
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

	public LogroAsigEval getLogroAsigEval() {
		return this.logroAsigEval;
	}

	public void setLogroAsigEval(LogroAsigEval logroAsigEval) {
		this.logroAsigEval = logroAsigEval;
	}

	public List<LogroAsigEvalItemDet> getLogrosAsignaturaEvaluacionItem() {
		return this.logrosAsignaturaEvaluacionItem;
	}

	public void setLogrosAsignaturaEvaluacionItem(List<LogroAsigEvalItemDet> logrosAsignaturaEvaluacionItem) {
		this.logrosAsignaturaEvaluacionItem = logrosAsignaturaEvaluacionItem;
	}

	public LogroAsigEvalItemDet addLogrosAsignaturaEvaluacionItem(LogroAsigEvalItemDet logrosAsignaturaEvaluacionItem) {
		getLogrosAsignaturaEvaluacionItem().add(logrosAsignaturaEvaluacionItem);
		logrosAsignaturaEvaluacionItem.setLogroAsigEvalItem(this);

		return logrosAsignaturaEvaluacionItem;
	}

	public LogroAsigEvalItemDet removeLogrosAsignaturaEvaluacionItem(LogroAsigEvalItemDet logrosAsignaturaEvaluacionItem) {
		getLogrosAsignaturaEvaluacionItem().remove(logrosAsignaturaEvaluacionItem);
		logrosAsignaturaEvaluacionItem.setLogroAsigEvalItem(null);

		return logrosAsignaturaEvaluacionItem;
	}

	public List<LogroEvalItem> getLogrosEvaluacionItems() {
		return this.logrosEvaluacionItems;
	}

	public void setLogrosEvaluacionItems(List<LogroEvalItem> logrosEvaluacionItems) {
		this.logrosEvaluacionItems = logrosEvaluacionItems;
	}

	public LogroEvalItem addLogrosEvaluacionItem(LogroEvalItem logrosEvaluacionItem) {
		getLogrosEvaluacionItems().add(logrosEvaluacionItem);
		logrosEvaluacionItem.setLogroAsigEvalItem(this);

		return logrosEvaluacionItem;
	}

	public LogroEvalItem removeLogrosEvaluacionItem(LogroEvalItem logrosEvaluacionItem) {
		getLogrosEvaluacionItems().remove(logrosEvaluacionItem);
		logrosEvaluacionItem.setLogroAsigEvalItem(null);

		return logrosEvaluacionItem;
	}

}