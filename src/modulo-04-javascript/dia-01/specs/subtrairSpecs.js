describe('subtrair()', function() {
  it('2 - 1 deve retornar 1', function() {
    var resultado = subtrair(2, 1);
    expect(resultado).toEqual(1);
  });

  it('0 - 0 deve retornar 0', function() {
    var resultado = subtrair(0, 0);
    expect(resultado).toEqual(0);
  });

  it('-1 - 2 deve retornar -3', function() {
    var resultado = subtrair(-1, 2);
    expect(resultado).toEqual(-3);
  });
});
