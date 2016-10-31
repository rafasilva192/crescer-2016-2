var objeto1 = {
  abacaxi: 0,
  banana: { peso: 52, preco: 100, origem: { cidade: 'taquari', estado: 'rs' } },
  cereja: 97
};
var objeto2 = {
  banana: { preco: 200, origem: { cidade: 'cachoeira do sul', estado: 'rs' } },
  damasco: 100
};
mesclar(objeto1, objeto2, true);
console.log(objeto1);

describe('mesclar()', function() {

  it('deve fazer mescla no primeiro nível', function() {
    let objeto1 = {
      abacaxi: 0,
      banana: { peso: 52, preco: 100 },
      cereja: 97
    };
    let objeto2 = {
      banana: { preco: 200 },
      damasco: 100
    };
    mesclar(objeto1, objeto2);
    expect(objeto1).toEqual({
      abacaxi: 0,
      banana: { preco: 200 },
      cereja: 97,
      damasco: 100
    });
  });

  it('deve fazer mescla recursiva', function() {
    let objeto1 = {
      abacaxi: 0,
      banana: { peso: 52, preco: 100, origem: { cidade: 'taquari', estado: 'rs' } },
      cereja: 97
    };
    let objeto2 = {
      banana: { preco: 200, origem: { cidade: 'cachoeira do sul', estado: 'rs' } },
      damasco: 100
    };
    mesclar(objeto1, objeto2, true);
    expect(objeto1).toEqual({
      abacaxi: 0,
      banana: { peso: 52, preco: 200, origem: { cidade: 'cachoeira do sul', estado: 'rs' } },
      cereja: 97,
      damasco: 100
    });
  });

});
