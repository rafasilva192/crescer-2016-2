class TelaPrincipal {
  
  constructor(seletor) {
    this.$elem = $(seletor);
    this.herois = new Herois();
    this.qtdHeroisPorPagina = 5;
    this.renderizarEstadoInicial();
  }

  registrarBindsEventos(self) {

    $('li[data-heroi-id]').each(function () {
      $(this).click(function () {
        let idHeroi = $(this).attr('data-heroi-id');
        console.log(idHeroi);
        marvelflix.render('#listagem-comics', 'listagem-comics', {
          selecionado: {
            id: idHeroi,
            comic_thumbnail: 'http://d1466nnw0ex81e.cloudfront.net/n_iv/600/1199087.jpg',
            comics: [
              { title: 'Titulo 1' },
              { title: 'Titulo 2' },
              { title: 'Titulo 3' },
              { title: 'Titulo 4' },
            ]
          }
        })
      });
    });

    self.$btnSincronizar = $('#btn-sincronizar-com-marvel');
    self.$btnProximaPagina = $('#btn-proxima-pagina');
    self.$btnPaginaAnterior = $('#btn-pagina-anterior');
    self.$btnSincronizar.on('click', self.sincronizar.bind(self));
    self.$btnProximaPagina.on('click', self.obterProximaPagina.bind(self));
    self.$btnPaginaAnterior.on('click', self.obterPaginaAnterior.bind(self));

    // estado inicial do botão é desabilitado ou quando volta para primeira página
    if (self.paginaAtual <= 1) {
      self.$btnPaginaAnterior.attr('disabled', true);
    } else {
      self.$btnPaginaAnterior.removeAttr('disabled');
      self.$btnProximaPagina.removeAttr('disabled');
    }
    let ultimaPagina = self.paginaAtual * self.qtdHeroisPorPagina >= self.qtdTotalRegistros;
    if (ultimaPagina) {
      self.$btnProximaPagina.attr('disabled', true);
    }

  }

  obterProximaPagina() {
    this.carregarERenderizarHerois(++this.paginaAtual);
  }

  obterPaginaAnterior() {
    this.carregarERenderizarHerois(--this.paginaAtual);    
  }

  sincronizar() {

    let self = this;
    let url = 'https://gateway.marvel.com:443/v1/public/characters?apikey=7ae597c1277cc37f2a4001139b3e2199&orderBy=-modified&limit=20';
    $.get(url).then(
      (res) => {
        res.data.results.forEach(
          (heroiMarvel) => {
            let heroiASerCriado = {
              nome: heroiMarvel.name,
              urlThumbnail: `${heroiMarvel.thumbnail.path}.${heroiMarvel.thumbnail.extension}`
            }
            self.cadastrarNovoHeroi(heroiASerCriado)
          }
        )
      }
    ).catch((err) => {
      console.error('Erro na comunicação com a Marvel. Verifique suas credenciais!');
      console.error(`${err.responseJSON.code} - ${err.responseJSON.message}`);
    });
  }

  cadastrarNovoHeroi(heroi) {
    this.herois.cadastrar(heroi).done((res) => {
      console.log('novo id', res.id);
    });
  }

  carregarERenderizarHerois(pagina) {

    return this.herois.pegarRegistros(pagina, this.qtdHeroisPorPagina)
      .done(function (res) {
        this.qtdTotalRegistros = res.total;
        this.renderizarHerois(res.dados).then(() => {
          this.registrarBindsEventos(this);
        })
      }.bind(this));
  }

  renderizarHerois(heroisServidor) {
    return marvelflix.render('.tela', 'tela-principal', {
      chars: heroisServidor.map(function (item) {
        return {
          id: item.id,
          name: item.nome,
          thumbnail: item.urlThumbnail
        }
      })
    });
  }

  renderizarEstadoInicial() {
    $('section.tela-centralizada').removeClass('tela-centralizada');
    this.$elem.show();
    this.paginaAtual = 1;
    this.carregarERenderizarHerois(this.pagina);
  }
}
