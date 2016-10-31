var ctrlC = function (obj) {

  let resultado = {};
  for (var prop in obj) {
    resultado[prop] = obj[prop];
  }
  return resultado;

}
