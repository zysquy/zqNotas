package com.zysquy.zqnotas.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the grupo database table.
 * 
 */
@Entity
@NamedQuery(name="Grupo.findAll", query="SELECT g FROM Grupo g")
public class Grupo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	private String nomenclatura;

	private String uuid;

	//bi-directional many-to-one association to Grado
	@ManyToOne
	private Grado grado;

	//bi-directional many-to-one association to Profesor
	@ManyToOne
	private Profesor profesor;

	//bi-directional many-to-one association to TipoJornada
	@ManyToOne
	@JoinColumn(name="tipo_jornada_id")
	private TipoJornada tipoJornada;

	public Grupo() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNomenclatura() {
		return this.nomenclatura;
	}

	public void setNomenclatura(String nomenclatura) {
		this.nomenclatura = nomenclatura;
	}

	public String getUuid() {
		return this.uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public Grado getGrado() {
		return this.grado;
	}

	public void setGrado(Grado grado) {
		this.grado = grado;
	}

	public Profesor getProfesor() {
		return this.profesor;
	}

	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}

	public TipoJornada getTipoJornada() {
		return this.tipoJornada;
	}

	public void setTipoJornada(TipoJornada tipoJornada) {
		this.tipoJornada = tipoJornada;
	}

}