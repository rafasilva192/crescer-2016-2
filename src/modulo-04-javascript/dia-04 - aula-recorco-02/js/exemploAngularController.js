angular.module('helloAngular', [])
  .controller('ExemploAngularController', function($scope) {
    $scope.herois = marvel
      .map(heroi => {
        heroi.modified = new Date(heroi.modified);
        heroi.imgPath = `${heroi.thumbnail.path}.${heroi.thumbnail.extension}`;
        return heroi;
      });
  });
