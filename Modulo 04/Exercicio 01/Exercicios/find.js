var find = function(array, fnFiltro){
  if(array instanceof Array && typeof fnFiltro == 'function'){
    let i = 0;
    let len = array.length;
    for(; i < len; i++){
      var resultado = [];
      if(fnFiltro(array[i])){
        resultado.push(array[i]);
        console.log(array[i]);
      }
    }
    return resultado;
  }
  else console.log('Primeiro parametro não é uma array ou o segundo não é uma função')
}
