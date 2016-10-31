angular.module('helloAngular', [])
  .controller('IndexController', function($scope) {
    $scope.herois = marvel;
    $scope.adicionarHeroi = function() {
      $scope.herois.push({ name: 'Super Debug' });
    };
    $scope.excluir = function($index) {
      $scope.herois.splice($index, 1);
    }
  });
