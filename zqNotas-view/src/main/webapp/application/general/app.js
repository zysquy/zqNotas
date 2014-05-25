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

var modDependencies = [
  'ngRoute',
  'ngResource',
  'ngCookies',
  'ngTable',
  'pascalprecht.translate',
  'zqNotasApp.administracion.controllers',
  'zqNotasApp.seguridad.controllers',
  'zq.datatables.directives'
  /*,
  'zqNotasApp.administracion.services',
  'zqNotasApp.directives'*/
];
var zqNotasApp = angular.module('zqNotasApp', modDependencies);

zqNotasApp.run(
  [ '$rootScope',
    function($rootScope) {
      $rootScope.$on('$viewContentLoaded', function() {
        pageSetUp();
      });
    }
  ]
);

/*
Config i18n angular-translate
 */
zqNotasApp.config(function($translateProvider){

    
  //$translateProvider.preferredLanguage('es_CO');
  	  
  $translateProvider.useStaticFilesLoader({
    prefix: 'resources/languages/',
    suffix: '.json'
  });
  $translateProvider.useLocalStorage();
  $translateProvider.use('es_CO');
  $translateProvider.preferredLanguage('en_US');

  /*
  $translateProvider.determinePreferredLanguage( function() {
	  return function name() {
		
	}
  });
*/
});

/**
 * Config interceptor for http
 */
zqNotasApp.config(function($provide, $httpProvider) {

  $provide.factory('zqHttpInterceptor',
    function($q, $location) {
      return {
    	  
        responseError: function(rejection) {          
          if( rejection !== undefined && rejection.hasOwnProperty('status')) {
            if( rejection.status == 500 ) {
              $location.path('/error500');
            }
            if(rejection.status == 400) {
            	$location.path('/error404');
            }
          }
          return $q.reject(rejection);
        }
      
      };
    });

  $httpProvider.interceptors.push('zqHttpInterceptor');
});



 