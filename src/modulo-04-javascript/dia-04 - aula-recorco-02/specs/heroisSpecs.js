describe('Herois', () => {

  let heroisMarvel = [];
  beforeEach(() => {
    heroisMarvel = marvel.concat();
  });

  describe('foraDaGuerraCivil()', () => {
    it('deve retornar apenas heróis sem eventos com nome Civil War', () => {
      let resultado = new Herois(marvel).foraDaGuerraCivil();
      expect(resultado.length).toEqual(1);
      expect(resultado[0]).toEqual(marvel[0]);
    })
    it('deve retornar array vazio caso todos tenham evento com Civil War', () => {
      let herois = [
        { id: 535, events: { items: [ { name: 'Aniquilação Civil War' } ] } },
        { id: 111, events: { items: [ { name: 'Projeto Civil War CRESCER' } ] } }
      ];
      expect(new Herois(herois).foraDaGuerraCivil()).toEqual([]);
    })
    it('deve retornar elemento caso nome não seja exatamente igual', () => {
      let herois = [
        { id: 535, events: { items: [ { name: 'CIVIL WAR' } ] } },
      ];
      expect(new Herois(herois).foraDaGuerraCivil()).toEqual([ ]);
    })
  })
  describe('maisPublicado()', () => {
    it('deve retornar o herói com maior número de publicações', () => {
      let resultado = new Herois(heroisMarvel).maisPublicado();
      expect(resultado).toEqual(marvel[7]);
    })
    it('deve retornar undefined com array vazio', () => {
      let resultado = new Herois([]).maisPublicado();
      expect(resultado).toBeUndefined();
    })
    it('deve retornar o primeiro encontrado com iguais', () => {
      let entrada = [
        { id: 71, comics: { available: 1 } },
        { id: 31, comics: { available: 4 } },
        { id: 63, comics: { available: 4 } },
      ];
      let resultado = new Herois(entrada).maisPublicado();
      expect(resultado).toEqual({ id: 31, comics: { available: 4 } });
    })
  })
  describe('mediaPaginas()', () => {
    it ('deve retornar média para vários personagens', () => {
      expect(new Herois(marvel).mediaPaginas()).toEqual(296.25);
    })
  })
  describe('seriesPorLongevidade()', () => {
    it('deve ordenar séries por mais tempo sendo produzidas', () => {
      let entrada = [
        { id: 71, series: { items: [ { startYear: 2010, endYear: 2012 } ] } },
        { id: 653, series: { items: [ { startYear: 2010, endYear: 2016 } ] } },
        { id: 125, series: { items: [ { startYear: 2010, endYear: 2013 } ] } },
      ];
      expect(new Herois(entrada).seriesPorLongevidade()).toEqual([
        { startYear: 2010, endYear: 2016 },
        { startYear: 2010, endYear: 2013 },
        { startYear: 2010, endYear: 2012 }
      ])
    })
  })







})
