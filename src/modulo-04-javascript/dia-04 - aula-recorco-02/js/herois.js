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

    return this.herois
      // ES5:
      // .sort(function(heroi1, heroi2) {
      //   return heroi2.comics.available - heroi1.comics.available;
      // })
      // ES2015 / ES6
      .sort((heroi1, heroi2) =>
        heroi2.comics.available - heroi1.comics.available
      )[0];

  }

  mediaPaginas() {

    // primeiro projetamos todas as comics em um array só (primeiro nível) => flatten
    let todasComics = this.herois
      .map(heroi => heroi.comics.items)
      .reduce(
        (acumulador, comics) => acumulador.concat(comics)
      , []);

    return todasComics
      .map(comic => comic.pageCount)
      .reduce((acumulador, totalPaginas) => acumulador + totalPaginas) / this.herois.length;

  }

  seriesPorLongevidade() {

    let todasSeries =
      this.herois
        .map(heroi => heroi.series.items)
        .reduce(
          (acumulador, series) => acumulador.concat(series)
        , []);

    /* ES5:
    var diff = function(serie) {
      return serie.endYear - serie.startYear;
    }*/
    let diff = serie => serie.endYear - serie.startYear;
    return todasSeries.sort((serie1, serie2) => diff(serie2) - diff(serie1));

  }

  comicMaisCara() {
    let todasComics = this.herois
      .map(heroi => heroi.comics.items)
      .reduce(
        (acumulador, comics) => acumulador.concat(comics)
      , []);

    let somarPrecos = comic => comic.prices.reduce(
      (acumulador, objetoPreco) => acumulador + objetoPreco.price
    , 0)

    // return todasComics.sort(
    //   (comic1, comic2) => somarPrecos(comic2) - somarPrecos(comic1)
    // )[0];
    return todasComics.reduce(
      (maiorAteEntao, comic) =>
        somarPrecos(comic) > somarPrecos(maiorAteEntao) ? comic : maiorAteEntao
    );

  }
}
