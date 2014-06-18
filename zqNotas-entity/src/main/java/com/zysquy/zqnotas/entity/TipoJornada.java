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
 * along with Foobar.  If not, see <http://www.gnu.org/licenses/>.
 *     
 * Contributors:
 *     Zysquy - initial implementation
 *******************************************************************************/
package com.zysquy.zqnotas.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * The persistent class for the tipo_jornada database table.
 * 
 */
@Entity
@Table(name="tipo_jornada")
@NamedQuery(name="TipoJornada.findAll", query="SELECT t FROM TipoJornada t")
public class TipoJornada extends Parametro implements Serializable {

  private static final long serialVersionUID = 1L;

}