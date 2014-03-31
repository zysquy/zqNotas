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