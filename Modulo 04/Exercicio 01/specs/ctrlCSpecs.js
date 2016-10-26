describe('ctrlC()',function(){
  it('Copia um objeto que é diferente do original',function(){
    var obj = { a: { a: 'a' }, b: 2 };
    var outroObj = ctrlC(obj);
    var resultado = obj === outroObj;
    expect(false).toEqual(resultado);
    expect(true).toEqual(iguais(obj,outroObj))
  });
});
