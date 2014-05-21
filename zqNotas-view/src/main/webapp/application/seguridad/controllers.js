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

var modSeguridadControllersDeps = [];
var modSeguridadControllers = angular.module('zqNotasApp.seguridad.controllers', modSeguridadControllersDeps);

modSeguridadControllers.controller('SeguridadAutenticacionCtrl',
  [ '$scope', '$http', '$resource', '$window',
    function($scope, $http, $resource, $window) {

      $scope.init = function() {

      };

      $scope.autenticar = function(user) {

        if( user !== null ) {
          var config = {};
          config.data = {
            username : user.username,
            password : user.password
          };
          config.transformRequest = function(data, getHeaders) {
            var headers = getHeaders();
            headers["Content-Type"] = "application/x-www-form-urlencoded; charset=utf-8";
            var buffer = [];
            buffer.push(encodeURIComponent('username') + "=" + encodeURIComponent(data.username));
            buffer.push(encodeURIComponent('password') + "=" + encodeURIComponent(data.password));
            return buffer.join("&");
          };
          $http.post('j_spring_security_check', config.data, config).success( function(data, status, getHeaders, config) {
            if( getHeaders('authenticated') === 'true' ) {
              $scope.authenticated = true;
              var location = "/";
              if( getHeaders('location') !== undefined ) {
                location = getHeaders('location');
              }
              $window.location.href = location;              
            } else if( getHeaders('authenticated') === 'false' ) {
            	$scope.msgErrorAuth = getHeaders('message-error-auth');
            	$scope.authenticated = false;
            }
          });
        }
      };

    }
  ]
);