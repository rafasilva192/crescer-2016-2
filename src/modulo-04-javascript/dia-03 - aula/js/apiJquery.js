let $ulPersonagens = $('.verde');
marvel
  .sort((heroi1, heroi2) => heroi2.comics.available - heroi1.comics.available)
  .forEach(heroi => {
  // criar um list-item
  $ulPersonagens
    .append(
      $('<li>')
        .append(
          $('<span>').text(`${ heroi.name } possui ${ heroi.comics.available } HQs`)
        )
        .append(
          $('<img>').attr('src', `${heroi.thumbnail.path}.${heroi.thumbnail.extension}`).attr('height', 200)
        )
    );
});








let botaoComeca = $('#btn');
let quandoClicar = function() {
  let h1 = $('#cabecalho');
  setInterval(function() {
    h1.text(new Date().toLocaleString())
  }, 1000);
}
botaoComeca.click(quandoClicar);
//
