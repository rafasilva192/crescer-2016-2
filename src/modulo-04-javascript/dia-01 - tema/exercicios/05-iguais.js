
function ehObjeto(obj) {
  return typeof obj === 'object';
}

function iguais(obj1, obj2) {

  if (ehObjeto(obj1) && ehObjeto(obj2)) {
    // se tiverem quantidades de campos diferentes, já retorna falso
    if (Object.keys(obj1).length !== Object.keys(obj2).length) {
      return false;
    }

    // comparando recursivamente propriedades;
    for (let prop in obj1) {
      let saoIguais = iguais(obj1[prop], obj2[prop]);
      if (!saoIguais) return false;
    }
    return true;
  }

  return obj1 === obj2;
}
