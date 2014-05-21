/**
 * Created by ndochoa on 19/05/14.
 */

var zqDatatablesDirectivesModule = angular.module('zq.datatables.directives', []);


zqDatatablesDirectivesModule.directive('zqDatatable',
  [
    function() {
      return {
        restrict : 'A',
        replace : false,
        link: function($scope, $element, $attrs) {
          $element.dataTable();
        }
      };
    }
  ]);