
var maiorQueUm = function(elem) {
  return elem > 1;
};

find([ 1, 3, 2 ], 'jabulani');

function find(array, fnFiltro) {

  let resultado = [];
  if (typeof fnFiltro === 'function') {
    for (let i = 0; i < array.length; i++) {
      let encontrou = fnFiltro(array[i]);
      if (encontrou) {
        resultado.push(array[i]);
      }
    }
  }
  return resultado;

}
