var elfo = { nome: 'Legolas', experiencia: 1 };

(function (array) {
  var i = 0
    , len = array.length;
  for (; i < len; i++) {
    console.log(array[i]);
  }
  console.log('i', i);
})( [ 4, '3', false, 'oi' ] );

function exibirElfoNaTela(elfo) {

  var maiusculo = function oi(texto) {
    return texto.toUpperCase();
  }

  alert(maiusculo(elfo.nome));

  if (elfo === undefined) {
    var minusculo = elfo.nome.toLowerCase();
  }
  minusculo += 'oi';
}
