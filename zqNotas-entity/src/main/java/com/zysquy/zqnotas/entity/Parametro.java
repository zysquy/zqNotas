package com.zysquy.zqnotas.entity;

import java.util.UUID;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.SequenceGenerator;

import org.hibernate.annotations.Type;


@MappedSuperclass
public class Parametro {

  @Id
  @GeneratedValue(strategy=GenerationType.SEQUENCE)
  @SequenceGenerator(name="parametro_id_seq")
  private Short id;
    
  private String estado;

  private String descripcion;

  private String nombre;

  @Type(type="pg-uuid")
  private UUID uuid;
  
  public String getEstado() {
    return estado;
  }

  public void setEstado(String estado) {
    this.estado = estado;
  }

  public Short getId() {
    return id;
  }

  public void setId(Short id) {
    this.id = id;
  }

  public String getDescripcion() {
    return descripcion;
  }

  public void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public UUID getUuid() {
    return uuid;
  }

  public void setUuid(UUID uuid) {
    this.uuid = uuid;
  }
    
}
