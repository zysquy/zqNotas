package com.zysquy.persistence;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zysquy.zqnotas.entity.Parametro;


public interface ParametroRepository<T extends Parametro> extends JpaRepository<T, Serializable> {

  public List<T> findByEstado(String estado);
  
}
