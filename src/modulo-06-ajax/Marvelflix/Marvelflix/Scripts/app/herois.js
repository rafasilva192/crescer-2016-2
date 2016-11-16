class Herois {

  pegarRegistros(pagina, qtdHeroisPorPagina) {
    return $.get('/api/herois', {
      pagina: pagina,
      tamanhoPagina: qtdHeroisPorPagina
    });
  }

  cadastrar(heroi) {
    return $.post('/api/herois', heroi);
  }

}