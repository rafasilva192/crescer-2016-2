describe('iguais()', function() {
  it('deve retornar true para o mesmo objeto', function() {
    let obj = { a: { a: 'a' }, b: 2 };
    let resultado = iguais(obj, obj);
    expect(resultado).toBeTruthy();
  });
  it('deve retornar false para objetos com campos com mesmos nomes mas valores diferentes', function() {
    let obj = { a: { a: 'a' }, b: 2 };
    let resultado = iguais(obj, { a: 1, b: 2 });
    expect(resultado).toBeFalsy();
  });
  it ('deve retornar false caso os objetos tenham quantidades diferentes de propriedades', function() {
    expect(iguais({ a: 1 }, { a: 1, b: 2 })).toBeFalsy();
  });
  it('deve retornar false para objetos com arrays com posições diferentes', function() {
    let goku = {
      nome: 'Goku',
      nivel: 'SSJ4',
      golpes: [
        { nome: 'kamehameha', dano: 45 }, { nome: 'genki-dama', dano: 99 }
      ]
    }, sonGoku = {
      nome: 'Goku',
      nivel: 'SSJ4',
      golpes: [
        { nome: 'genki-dama', dano: 99 }, { nome: 'kamehameha', dano: 45 }
      ]
    };
    let resultado = iguais(goku, sonGoku);
    expect(resultado).toBeFalsy();
  });
});
