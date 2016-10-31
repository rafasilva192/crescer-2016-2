// IIFE
// (function () {
//   console.log(arguments);
//   console.log(this);
//   (function() {
//     console.log(arguments);
//   })(1, 2);
// })('primeiro param', 3, { nome: 'nao precisa' })

function imprime(texto) {
  console.log(this);
  console.log(arguments);
  console.log('imprime', texto, this.qualquerCoisa);
}

// 1
// console.log('Chamada normal');
// imprime('olá mundo');
// console.log('--------------------');
// console.log('call');
// imprime.call({ qualquerCoisa: 'sim' }, 'olá mundo');
// console.log('--------------------');
// console.log('apply');
// imprime.apply({ qualquerCoisa: 'via apply' }, [ 'olá mundo', 'dois', 3, false ]);
// console.log('--------------------');

(function teste() {
  this.a = 'a';
  var fn = function() {
    console.log(this.a);
  };
  setTimeout(fn, 1000);
})();



// setInterval(function() {
//   console.log('a cada segundo', new Date().toLocaleString());
// }, 1000);








console.log('está depois, mas vai executar antes');
