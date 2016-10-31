describe('Herois', () => {
  describe('foraDaGuerraCivil()', () => {
    it('deve retornar apenas heróis sem eventos com nome Civil War', () => {
      let resultado = new Herois(marvel).foraDaGuerraCivil();
      expect(resultado.length).toEqual(1);
      expect(resultado[0]).toEqual(marvel[0]);
    })

    it('deve retornar apenas um objeto quando tiver apenas um herói que não participou', () => {
      let arrayEntrada = [ {
        id: 43,
        name: 'Teste unitário mítico',
        events: {
          items: [
            { name: 'Churrasco do CRESCER' }
          ]
        }
      } ];
      let resultado = new Herois(arrayEntrada).foraDaGuerraCivil();
      expect(resultado.length).toEqual(1);
      expect(resultado).toEqual(arrayEntrada);
    })


    it('deve retornar array vazio caso todos tenham evento com Civil War', () => {
      let herois = [
        { id: 535, events: { items: [ { name: 'Aniquilação Civil War' } ] } },
        { id: 111, events: { items: [ { name: 'Projeto Civil War CRESCER' } ] } }
      ];
      expect(new Herois(herois).foraDaGuerraCivil()).toEqual([]);
    })

    it('deve não retornar elemento caso nome não seja exatamente igual', () => {
      let herois = [
        { id: 535, events: { items: [ { name: 'civil WAR' } ] } },
      ];
      expect(new Herois(herois).foraDaGuerraCivil()).toEqual([]);
    })
  })

  describe('maisPublicado()', () => {
    it('deve retornar herói com mais publicações entre vários', () => {
      let maisPublicado = marvel[7];
      expect(new Herois(marvel).maisPublicado()).toEqual(maisPublicado);
    })
    it('deve retornar primeiro elemento encontrado com mais publicações', () => {
      let herois = [
        { id: 535, comics: { available: 3 } },
        { id: 123, comics: { available: 30 } },
        { id: 981, comics: { available: 30 } },
      ];
      // criar uma cópia
      let copia = [].concat(herois);
      let resultado = new Herois(copia).maisPublicado();
      expect(resultado).toEqual(herois[1]);
    })
    it('deve retornar undefined com array vazio', () => {
      expect(new Herois([]).maisPublicado()).toBeUndefined();
    })
  })

  describe('mediaPaginas()', () => {
    it('deve retornar media de páginas por personagem com vários dados', () => {
      expect(new Herois(marvel).mediaPaginas()).toEqual(296.25);
    })
    it('deve retornar NaN com array vazio', () => {
      let resultado = new Herois([]).mediaPaginas();
      expect(isNaN(resultado)).toBeTruthy();
    })
    it('deve retornar media de páginas por personagem com array simples', () => {
      let herois = [
        { id: 535, comics: { items: [ { pageCount: 6 } ] } },
        { id: 123, comics: { items: [ { pageCount: 2 } ] } },
        { id: 981, comics: { items: [ { pageCount: 1 } ] } },
      ];
      expect(new Herois(herois).mediaPaginas()).toEqual(3);
    })
  })

  describe('seriesPorLongevidade()', () => {
    it('deve retornar a serie com mais tempo em atividade', () => {
      let herois = [
        { id: 874, series: { items: [ { startYear: 2000, endYear: 2002 } ] } },
        { id: 123, series: { items: [ { startYear: 2000, endYear: 2006 } ] } },
        { id: 234, series: { items: [ { startYear: 2000, endYear: 2004 } ] } }
      ];
      expect(new Herois(herois).seriesPorLongevidade()).toEqual([
        { startYear: 2000, endYear: 2006 },
        { startYear: 2000, endYear: 2004 },
        { startYear: 2000, endYear: 2002 }
      ]);
    })
    it('deve retornar a serie com mais tempo em atividade encontrada primeiro', () => {
      let herois = [
        { id: 874, series: { items: [ { id: 3, startYear: 2000, endYear: 2002 } ] } },
        { id: 123, series: { items: [ { id: 4, startYear: 2000, endYear: 2006 } ] } },
        { id: 234, series: { items: [ { id: 5, startYear: 2000, endYear: 2006 } ] } }
      ];
      expect(new Herois(herois).seriesPorLongevidade()).toEqual([
        { id: 4, startYear: 2000, endYear: 2006 },
        { id: 5, startYear: 2000, endYear: 2006 },
        { id: 3, startYear: 2000, endYear: 2002 }
      ]);
    })
    it('deve retornar array vazio sem heróis', () => {
      let herois = [
        { id: 874, series: { items: [ ] } },
        { id: 123, series: { items: [ ] } },
        { id: 234, series: { items: [ ] } }
      ];
      expect(new Herois(herois).seriesPorLongevidade()).toEqual([]);
    })
  })

  describe('comicMaisCara()', () => {
    it('deve retornar comic mais cara entre várias outras', () => {
      let comicMaisCara = new Herois(marvel).comicMaisCara();
      expect(comicMaisCara.id).toEqual(58609);
    })
  })















})
