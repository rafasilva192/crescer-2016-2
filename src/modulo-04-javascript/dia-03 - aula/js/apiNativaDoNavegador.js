let ulPersonagens = document.querySelector('.verde');
marvel
  .sort((heroi1, heroi2) => heroi2.comics.available - heroi1.comics.available)
  .forEach(heroi => {
  // criar um list-item
  let liHeroi = document.createElement('li');
  // com informações do heroi
  // comics.available
  let spanHeroi = document.createElement('span');
  spanHeroi.innerText = `${ heroi.name } possui ${ heroi.comics.available } HQs`;
  liHeroi.appendChild(spanHeroi);

  // depois "appendar" como filho da ulPersonagens
  ulPersonagens.appendChild(liHeroi);
});








let botaoComeca = document.getElementById('btn');
let quandoClicar = function() {
  let h1 = document.getElementById('cabecalho');
  setInterval(function() {
    h1.innerText = new Date().toLocaleString()
  }, 1000);
}
botaoComeca.addEventListener('click', quandoClicar);
//
