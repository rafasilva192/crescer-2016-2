class TelaPrincipal {
  
  constructor(seletor) {
    this.$elem = $(seletor);
    this.qtdHeroisPorPagina = 5;
    this.renderizarEstadoInicial();
  }

  registrarBindsEventos(self) {

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
    let url = 'https://gateway.marvel.com:443/v1/public/characters?apikey=&orderBy=-modified&limit=20';
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
    $.post('/api/herois', heroi).done((res) => {
      console.log('novo id', res.id);
    });
  }

  carregarERenderizarHerois(pagina) {
    return $.get('/api/herois', {
      pagina: pagina,
      tamanhoPagina: this.qtdHeroisPorPagina
    }).done(function (res) {
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
