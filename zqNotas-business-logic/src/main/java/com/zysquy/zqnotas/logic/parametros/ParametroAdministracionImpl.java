/*******************************************************************************
 * Copyright (c) 2014 Zysquy.
 * All rights reserved. This file is part of zqNotas.
 *
 * zqNotas is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License version 3 as published by
 * the Free Software Foundation.
 * 	
 * zqNotas is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Zysquy.  If not, see <http://www.gnu.org/licenses/>.
 *     
 * Contributors:
 *     Zysquy - initial implementation
 *******************************************************************************/
package com.zysquy.zqnotas.logic.parametros;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.zysquy.persistence.ParametroRepository;
import com.zysquy.zqnotas.entity.Parametro;

@Service
public class ParametroAdministracionImpl implements ParametroAdministracion {
  
  private Map<String, ParametroRepository<?>> repositorios;

  public ParametroAdministracionImpl() {
   repositorios = new HashMap<String, ParametroRepository<?>>();
  }
  
  public void setRepositorios(Map<String, ParametroRepository<?>> repositorios) {
    this.repositorios = repositorios;
  }

  @Override
  public Parametro recuperarActivos(Class<? extends Parametro> classParametro) {
    if( classParametro != null ) {
      if( repositorios.containsKey(classParametro.getName()) ) {
        this.repositorios.get(classParametro.getName()).findByEstado("A");
      }
    }
    
    return null;
  }

  
  
}
