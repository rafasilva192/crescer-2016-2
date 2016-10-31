console.log('Olá "JS"!');
console.log('Olá \'JS\'!');

console.log("Nome: 'oi'", elfo.nome);
elfo.flechas = 42;
console.log(elfo.flechas);
delete elfo.nome;
elfo.flechas = undefined;
elfo['Nome Completo'] = 'Legolas da Silva';
// public void atirarFlecha (Dwarf dwarf) { }
elfo.atirarFlecha = function(dwarf, opt, boolean, batman) {
  //opt();
  dwarf.vida -= 10;
  elfo.experiencia++;
  dwarf.feliz = false;
  return dwarf;
};

// IIFE
(function() {
  console.log('oi');
})();

var dwarf = elfo.atirarFlecha({ vida: 110 }, 'oi', true, 'batman');


console.log(elfo, dwarf);

elfo.nome = 'Fingolfin';
exibirElfoNaTela(elfo);
// console.log(maiusculo(elfo.nome)); ReferenceError
