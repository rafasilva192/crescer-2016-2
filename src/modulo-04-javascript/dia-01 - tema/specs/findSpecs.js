describe('find()', function() {

  it('deve encontrar elementos maiores ou iguais a 2', function() {
    let resultado = find([ 1, 2, 3 ], elemento => elemento >= 2);
    expect(resultado).toEqual([ 2, 3 ]);
  });
  it('deve encontrar elementos que sejam strings', function() {
    let resultado = find([ 'a', 5, null, false, 'false' ], elem => typeof elem === 'string');
    expect(resultado).toEqual([ 'a', 'false' ]);
  });
  it('deve encontrar nenhum elemento', function() {
    let resultado = find([ { nome: 'a' }, { nome: 'b' }  ], elem => typeof elem.nome === 'c');
    expect(resultado).toEqual([]);
  });
  it('deve retornar array vazio caso segundo parâmetro não seja função', function() {
    let resultado = find([ { nome: 'a' }, { nome: 'b' }  ], {});
    expect(resultado).toEqual([]);
  });

});
