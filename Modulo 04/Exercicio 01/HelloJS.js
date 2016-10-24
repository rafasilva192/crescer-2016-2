// Exercicio 1

var gerarPiramide = function (niveis){
  var i = 0;
  var convertedArray = [];
  for(; i <= niveis + 1; i++){
    console.log(Array(i).join('R$'));
  }
}

// Exercicio 2

var diggletDig = function(){
  var i = 1;
  for(; i < 100; i++){
    if(i%5 === 0 && i%3 === 0){
      console.log('digglet Dig, trio trio trio')
    }
    else if(i%3 === 0){
      console.log('digglet Dig');
    }
    else if(i%5 === 0 && i%3 !== 0){
      console.log('trio trio trio')
    }
    else{
      console.log(i)
    }
  }
}

// Exercicio 3

var maiorIgualADois = function (numero){
  return numero >= 2? true:false;
}

var find = function(array, fun){
  if(array instanceof Array){
    var i = 0;
    var len = array.length;
    for(; i < len; i++){
      if(fun(array[i])){
        console.log(array[i]);
      }
    }
  }
}

// Exercicio 4
var i = 0;
var subtrair = function(numero){
  i++;
  if(i===1){
  var primeiroNumero = numero;
}
else return primeiroNumero -= numero;
}
