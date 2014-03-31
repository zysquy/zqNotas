package com.zysquy.zqnotas.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tipo_periodo database table.
 * 
 */
@Entity
@Table(name="tipo_periodo")
@NamedQuery(name="TipoPeriodo.findAll", query="SELECT t FROM TipoPeriodo t")
public class TipoPeriodo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Short id;

	private String descripcion;

	private String estado;

	private String nombre;

	private String uuid;

	//bi-directional many-to-one association to PeriodoLectivo
	@OneToMany(mappedBy="tipoPeriodo")
	private List<PeriodoLectivo> periodosLectivos;

	public TipoPeriodo() {
	}

	public Short getId() {
		return this.id;
	}

	public void setId(Short id) {
		this.id = id;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getUuid() {
		return this.uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public List<PeriodoLectivo> getPeriodosLectivos() {
		return this.periodosLectivos;
	}

	public void setPeriodosLectivos(List<PeriodoLectivo> periodosLectivos) {
		this.periodosLectivos = periodosLectivos;
	}

	public PeriodoLectivo addPeriodosLectivo(PeriodoLectivo periodosLectivo) {
		getPeriodosLectivos().add(periodosLectivo);
		periodosLectivo.setTipoPeriodo(this);

		return periodosLectivo;
	}

	public PeriodoLectivo removePeriodosLectivo(PeriodoLectivo periodosLectivo) {
		getPeriodosLectivos().remove(periodosLectivo);
		periodosLectivo.setTipoPeriodo(null);

		return periodosLectivo;
	}

}