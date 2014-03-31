package com.zysquy.zqnotas.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the logro_asig_eval database table.
 * 
 */
@Entity
@Table(name="logro_asig_eval")
@NamedQuery(name="LogroAsigEval.findAll", query="SELECT l FROM LogroAsigEval l")
public class LogroAsigEval implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	private String nombre;

	private Float porcentaje;

	private String uuid;

	//bi-directional many-to-one association to Asignatura
	@ManyToOne
	private Asignatura asignatura;

	//bi-directional many-to-one association to PeriodoEvaluacion
	@ManyToOne
	@JoinColumn(name="periodo_evaluacion_id")
	private PeriodoEvaluacion periodoEvaluacion;

	//bi-directional many-to-one association to LogroAsigEvalItem
	@OneToMany(mappedBy="logroAsigEval")
	private List<LogroAsigEvalItem> logrosAsignaturaEvaluacionItem;

	//bi-directional many-to-one association to LogroEvaluacion
	@OneToMany(mappedBy="logroAsigEval")
	private List<LogroEvaluacion> logrosEvaluacion;

	public LogroAsigEval() {
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

	public Asignatura getAsignatura() {
		return this.asignatura;
	}

	public void setAsignatura(Asignatura asignatura) {
		this.asignatura = asignatura;
	}

	public PeriodoEvaluacion getPeriodoEvaluacion() {
		return this.periodoEvaluacion;
	}

	public void setPeriodoEvaluacion(PeriodoEvaluacion periodoEvaluacion) {
		this.periodoEvaluacion = periodoEvaluacion;
	}

	public List<LogroAsigEvalItem> getLogrosAsignaturaEvaluacionItem() {
		return this.logrosAsignaturaEvaluacionItem;
	}

	public void setLogrosAsignaturaEvaluacionItem(List<LogroAsigEvalItem> logrosAsignaturaEvaluacionItem) {
		this.logrosAsignaturaEvaluacionItem = logrosAsignaturaEvaluacionItem;
	}

	public LogroAsigEvalItem addLogrosAsignaturaEvaluacionItem(LogroAsigEvalItem logrosAsignaturaEvaluacionItem) {
		getLogrosAsignaturaEvaluacionItem().add(logrosAsignaturaEvaluacionItem);
		logrosAsignaturaEvaluacionItem.setLogroAsigEval(this);

		return logrosAsignaturaEvaluacionItem;
	}

	public LogroAsigEvalItem removeLogrosAsignaturaEvaluacionItem(LogroAsigEvalItem logrosAsignaturaEvaluacionItem) {
		getLogrosAsignaturaEvaluacionItem().remove(logrosAsignaturaEvaluacionItem);
		logrosAsignaturaEvaluacionItem.setLogroAsigEval(null);

		return logrosAsignaturaEvaluacionItem;
	}

	public List<LogroEvaluacion> getLogrosEvaluacion() {
		return this.logrosEvaluacion;
	}

	public void setLogrosEvaluacion(List<LogroEvaluacion> logrosEvaluacion) {
		this.logrosEvaluacion = logrosEvaluacion;
	}

	public LogroEvaluacion addLogrosEvaluacion(LogroEvaluacion logrosEvaluacion) {
		getLogrosEvaluacion().add(logrosEvaluacion);
		logrosEvaluacion.setLogroAsigEval(this);

		return logrosEvaluacion;
	}

	public LogroEvaluacion removeLogrosEvaluacion(LogroEvaluacion logrosEvaluacion) {
		getLogrosEvaluacion().remove(logrosEvaluacion);
		logrosEvaluacion.setLogroAsigEval(null);

		return logrosEvaluacion;
	}

}