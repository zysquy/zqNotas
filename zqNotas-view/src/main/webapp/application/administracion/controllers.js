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

var modAdministracionControllersDeps = ['ngTable'];
var modAdministracionControllers = angular.module('zqNotasApp.administracion.controllers', modAdministracionControllersDeps);

modAdministracionControllers.controller('AdmEstablecimientosEduCtrl',
  [ '$scope', '$http', '$resource', 'ngTableParams',
    function($scope, $http, $resource, ngTableParams) {

      var EstablecimientoEducativoResource = $resource('api/establecimientos/:id', {id:'@id'});

      $scope.init = function() {
        $scope.getList();
      };

      $scope.guardar = function(establecimientoEducativo) {
        var eu = new EstablecimientoEducativoResource();
        angular.copy(establecimientoEducativo, eu);
        eu.$save();
        EstablecimientoEducativoResource.get({id:1});
        //$scope.loadDTParams();
        /*
        $http.post('establecimientos/add', establecimientoEducativo).success( function(data, status, headers, config) {
          console.log('Success send establecimientos/add', data);
          console.log('Success send establecimientos/add', status);
        });
        */
      };

      $scope.getList = function() {
    	  var establecimientos = EstablecimientoEducativoResource.get( function() {
    		  $scope.listEstablecimientosEdu = establecimientos.data;
    		  $scope.loadDTParams();
    	  });
    	  
    	  /*
        $http.post('establecimientos/list').success( function(data, status, headers, config) {
          $scope.listEstablecimientosEdu = data;
          $scope.loadDTParams();
        }).error( function(data, status, headers, config) {
          console.log('Error on invoke',data);
        });
        */
      };
      
      $scope.loadDTParams = function() {    	  
    	  $scope.dtEstEduParams = new ngTableParams(
    			  	{
    			  		page: 1, 
    			  		count: 20
    			  	}, 
    			  	{
    			  		counts: [],
    			  		total: $scope.listEstablecimientosEdu.length,
    			  		getData: function($defer, params) {
    			  			$defer.resolve($scope.listEstablecimientosEdu.slice((params.page() - 1) * params.count(), params.page() * params.count()));
						}
    			  	}
    			  );
    			  
      };
      
    }
  ]
);