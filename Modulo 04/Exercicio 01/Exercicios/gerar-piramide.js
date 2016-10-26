var gerarPiramide = function (niveis){
  var i = 1;
  for(; i <= niveis; i++){
    console.log(Array(i + 1).join('R$'));
  }
}
