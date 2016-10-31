describe('Herois', () => {
  describe('foraDaGuerraCivil', () => {
    it('deve retornar apenas heróis sem eventos com nome Civil War', () => {
      let resultado = new Herois(marvel).foraDaGuerraCivil();
      expect(resultado.length).toEqual(1);
      expect(resultado[0].id).toEqual(1011299);
    })
    it('deve retornar array vazio caso todos tenham evento com Civil War', () => {
      let herois = [
        { id: 535, events: { items: [ { name: 'Aniquilação Civil War' } ] } },
        { id: 111, events: { items: [ { name: 'Projeto Civil War CRESCER' } ] } }
      ];
      expect(new Herois(herois).foraDaGuerraCivil()).toEqual([]);
    })
    // it('deve retornar elemento caso nome não seja exatamente igual', () => {
    //   let herois = [
    //     { id: 535, events: { items: [ { name: 'CIVIL WAR' } ] } },
    //   ];
    //   expect(new Herois(herois).foraDaGuerraCivil()).toEqual([
    //     { id: 535, events: { items: [ { name: 'CIVIL WAR' } ] } },
    //   ]);
    // })
  })
})
