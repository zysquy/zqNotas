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
'use strict';

zqNotasApp.config(
  [ '$routeProvider',
    function($routeProvider) {
      $routeProvider.when('/establecimientos/administracion', {
        templateUrl: 'pages/establecimientos/administracion.html'
      });
   }
  ]
);

 