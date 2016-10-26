describe('iguais()', function() {
  it('comparando dois objetos iguais deve retornar true', function() {
    var obj = { a: { a: 'a' }, b: 2 };
    var resultado = iguais(obj, obj);
    expect(resultado).toEqual(true);
  });

  it('comparando dois objetos diferentes deve retornar false', function() {
    var obj = { a: { a: 'a' }, b: 2 };
    var resultado = iguais(obj, { a: 1, b: 2 });
    expect(resultado).toEqual(false);
  });

  it('Comparando objetos parecidos com uma pequena diferença return false', function() {
    goku = {
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
    var resultado = iguais(goku,sonGoku);
    expect(resultado).toEqual(false);
  });
});
