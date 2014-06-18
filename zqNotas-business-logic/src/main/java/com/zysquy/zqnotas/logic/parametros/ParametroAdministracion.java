package com.zysquy.zqnotas.logic.parametros;

import com.zysquy.zqnotas.entity.Parametro;

public interface ParametroAdministracion {

  public abstract Parametro recuperarActivos(Class<? extends Parametro> classParametro);
  
}
