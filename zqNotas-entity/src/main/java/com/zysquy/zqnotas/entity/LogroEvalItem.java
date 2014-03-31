package com.zysquy.zqnotas.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the logro_eval_item database table.
 * 
 */
@Entity
@Table(name="logro_eval_item")
@NamedQuery(name="LogroEvalItem.findAll", query="SELECT l FROM LogroEvalItem l")
public class LogroEvalItem implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	private Float nota;

	private String uuid;

	//bi-directional many-to-one association to LogroAsigEvalItem
	@ManyToOne
	@JoinColumn(name="logro_asig_eval_item_id")
	private LogroAsigEvalItem logroAsigEvalItem;

	//bi-directional many-to-one association to LogroEvaluacion
	@ManyToOne
	@JoinColumn(name="logro_evaluacion_id")
	private LogroEvaluacion logroEvaluacion;

	//bi-directional many-to-one association to LogroEvalItemDet
	@OneToMany(mappedBy="logroEvalItem")
	private List<LogroEvalItemDet> logrosEvaluacionItemsDetalle;

	public LogroEvalItem() {
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

	public LogroAsigEvalItem getLogroAsigEvalItem() {
		return this.logroAsigEvalItem;
	}

	public void setLogroAsigEvalItem(LogroAsigEvalItem logroAsigEvalItem) {
		this.logroAsigEvalItem = logroAsigEvalItem;
	}

	public LogroEvaluacion getLogroEvaluacion() {
		return this.logroEvaluacion;
	}

	public void setLogroEvaluacion(LogroEvaluacion logroEvaluacion) {
		this.logroEvaluacion = logroEvaluacion;
	}

	public List<LogroEvalItemDet> getLogrosEvaluacionItemsDetalle() {
		return this.logrosEvaluacionItemsDetalle;
	}

	public void setLogrosEvaluacionItemsDetalle(List<LogroEvalItemDet> logrosEvaluacionItemsDetalle) {
		this.logrosEvaluacionItemsDetalle = logrosEvaluacionItemsDetalle;
	}

	public LogroEvalItemDet addLogrosEvaluacionItemsDetalle(LogroEvalItemDet logrosEvaluacionItemsDetalle) {
		getLogrosEvaluacionItemsDetalle().add(logrosEvaluacionItemsDetalle);
		logrosEvaluacionItemsDetalle.setLogroEvalItem(this);

		return logrosEvaluacionItemsDetalle;
	}

	public LogroEvalItemDet removeLogrosEvaluacionItemsDetalle(LogroEvalItemDet logrosEvaluacionItemsDetalle) {
		getLogrosEvaluacionItemsDetalle().remove(logrosEvaluacionItemsDetalle);
		logrosEvaluacionItemsDetalle.setLogroEvalItem(null);

		return logrosEvaluacionItemsDetalle;
	}

}