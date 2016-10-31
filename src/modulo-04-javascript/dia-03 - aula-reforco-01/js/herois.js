class Herois {

  constructor(array) {
    this.herois = array;
  }

  foraDaGuerraCivil() {

    return this.herois.filter(heroi =>
      heroi.events.items.filter(e => e.name.contem('CiVIl war', true)).length === 0
    )

  }

  maisPublicado() {

    return this.herois.sort((h1, h2) => h2.comics.available - h1.comics.available)[0];

  }

  mediaPaginas() {

    let totalPaginas =
      this.herois
        .map(heroi =>
          heroi.comics.items.reduce((acum, comic) => acum + comic.pageCount, 0)
        )
        .reduce((acum, paginas) => acum + paginas, 0);
    return totalPaginas / this.herois.length;

  }

  seriesPorLongevidade() {

    let diff = serie => serie.endYear - serie.startYear;
    // #cryMaicon
    return this.herois
      .reduce((acc, heroi) => acc.concat(heroi.series.items) , [])
      .sort((serie1, serie2) => diff(serie2) - diff(serie1));

  }

  comicMaisCara() {

    let totalizarPrecos = comic => comic.prices.reduce(
      (acumulador, objetoPreco) => acumulador + objetoPreco.price
    , /* valor inicial da redução */ 0);
    return this.herois
      .reduce((acc, heroi) => acc.concat(heroi.comics.items) , [])
      .sort((comic1, comic2) => totalizarPrecos(comic2) - totalizarPrecos(comic1))[0]

  }
}
