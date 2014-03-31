package com.zysquy.zqnotas.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the periodo_lectivo database table.
 * 
 */
@Entity
@Table(name="periodo_lectivo")
@NamedQuery(name="PeriodoLectivo.findAll", query="SELECT p FROM PeriodoLectivo p")
public class PeriodoLectivo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	@Column(name="numero_periodo")
	private Short numeroPeriodo;

	private String uuid;

	//bi-directional many-to-one association to Estudiante
	@OneToMany(mappedBy="periodoLectivo")
	private List<Estudiante> estudiantes;

	//bi-directional many-to-one association to Grado
	@OneToMany(mappedBy="periodoLectivo")
	private List<Grado> grados;

	//bi-directional many-to-one association to EstablecimientoEducativo
	@ManyToOne
	@JoinColumn(name="establecimiento_educativo_id")
	private EstablecimientoEducativo establecimientoEducativo;

	//bi-directional many-to-one association to TipoPeriodo
	@ManyToOne
	@JoinColumn(name="tipo_periodo_id")
	private TipoPeriodo tipoPeriodo;

	//bi-directional many-to-one association to Profesor
	@OneToMany(mappedBy="periodoLectivo")
	private List<Profesor> profesores;

	public PeriodoLectivo() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Short getNumeroPeriodo() {
		return this.numeroPeriodo;
	}

	public void setNumeroPeriodo(Short numeroPeriodo) {
		this.numeroPeriodo = numeroPeriodo;
	}

	public String getUuid() {
		return this.uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public List<Estudiante> getEstudiantes() {
		return this.estudiantes;
	}

	public void setEstudiantes(List<Estudiante> estudiantes) {
		this.estudiantes = estudiantes;
	}

	public Estudiante addEstudiante(Estudiante estudiante) {
		getEstudiantes().add(estudiante);
		estudiante.setPeriodoLectivo(this);

		return estudiante;
	}

	public Estudiante removeEstudiante(Estudiante estudiante) {
		getEstudiantes().remove(estudiante);
		estudiante.setPeriodoLectivo(null);

		return estudiante;
	}

	public List<Grado> getGrados() {
		return this.grados;
	}

	public void setGrados(List<Grado> grados) {
		this.grados = grados;
	}

	public Grado addGrado(Grado grado) {
		getGrados().add(grado);
		grado.setPeriodoLectivo(this);

		return grado;
	}

	public Grado removeGrado(Grado grado) {
		getGrados().remove(grado);
		grado.setPeriodoLectivo(null);

		return grado;
	}

	public EstablecimientoEducativo getEstablecimientoEducativo() {
		return this.establecimientoEducativo;
	}

	public void setEstablecimientoEducativo(EstablecimientoEducativo establecimientoEducativo) {
		this.establecimientoEducativo = establecimientoEducativo;
	}

	public TipoPeriodo getTipoPeriodo() {
		return this.tipoPeriodo;
	}

	public void setTipoPeriodo(TipoPeriodo tipoPeriodo) {
		this.tipoPeriodo = tipoPeriodo;
	}

	public List<Profesor> getProfesores() {
		return this.profesores;
	}

	public void setProfesores(List<Profesor> profesores) {
		this.profesores = profesores;
	}

	public Profesor addProfesore(Profesor profesore) {
		getProfesores().add(profesore);
		profesore.setPeriodoLectivo(this);

		return profesore;
	}

	public Profesor removeProfesore(Profesor profesore) {
		getProfesores().remove(profesore);
		profesore.setPeriodoLectivo(null);

		return profesore;
	}

}