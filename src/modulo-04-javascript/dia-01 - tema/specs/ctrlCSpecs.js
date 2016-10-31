describe('ctrlC()', function() {

  it('deve clonar valores de um objeto simples', function() {
    let origem = { a: '1' };
    let destino = ctrlC(origem);
    expect(origem === destino).toBeFalsy();
    expect(iguais(origem, destino)).toBeTruthy();
  });

  it('deve clonar com objetos complexos internos', function() {
    let origem = { a: '1', b: { c: 'd' } };
    let destino = ctrlC(origem);
    expect(origem.b).toEqual(destino.b);
  });

});
