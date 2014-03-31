package com.zysquy.zqnotas.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the evaluacion database table.
 * 
 */
@Entity
@NamedQuery(name="Evaluacion.findAll", query="SELECT e FROM Evaluacion e")
public class Evaluacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	private Float nota;

	private String recomendacion;

	private String uuid;

	//bi-directional many-to-one association to Asignatura
	@ManyToOne
	private Asignatura asignatura;

	//bi-directional many-to-one association to Estudiante
	@ManyToOne
	private Estudiante estudiante;

	//bi-directional many-to-one association to PeriodoEvaluacion
	@ManyToOne
	@JoinColumn(name="periodo_evaluacion_id")
	private PeriodoEvaluacion periodoEvaluacion;

	//bi-directional many-to-one association to LogroEvaluacion
	@OneToMany(mappedBy="evaluacion")
	private List<LogroEvaluacion> logrosEvaluacion;

	public Evaluacion() {
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

	public String getRecomendacion() {
		return this.recomendacion;
	}

	public void setRecomendacion(String recomendacion) {
		this.recomendacion = recomendacion;
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

	public Estudiante getEstudiante() {
		return this.estudiante;
	}

	public void setEstudiante(Estudiante estudiante) {
		this.estudiante = estudiante;
	}

	public PeriodoEvaluacion getPeriodoEvaluacion() {
		return this.periodoEvaluacion;
	}

	public void setPeriodoEvaluacion(PeriodoEvaluacion periodoEvaluacion) {
		this.periodoEvaluacion = periodoEvaluacion;
	}

	public List<LogroEvaluacion> getLogrosEvaluacion() {
		return this.logrosEvaluacion;
	}

	public void setLogrosEvaluacion(List<LogroEvaluacion> logrosEvaluacion) {
		this.logrosEvaluacion = logrosEvaluacion;
	}

	public LogroEvaluacion addLogrosEvaluacion(LogroEvaluacion logrosEvaluacion) {
		getLogrosEvaluacion().add(logrosEvaluacion);
		logrosEvaluacion.setEvaluacion(this);

		return logrosEvaluacion;
	}

	public LogroEvaluacion removeLogrosEvaluacion(LogroEvaluacion logrosEvaluacion) {
		getLogrosEvaluacion().remove(logrosEvaluacion);
		logrosEvaluacion.setEvaluacion(null);

		return logrosEvaluacion;
	}

}