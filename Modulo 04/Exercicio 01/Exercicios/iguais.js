var iguais = function (obj1, obj2) {

function ehObjeto(obj){
  return typeof obj1 === 'object'
}
  //Loop through properties in object 1
  if(obj1 === obj2){
    return true;
  }
  else if(!(!obj1 && !obj2) && (ehObjeto(obj1) && ehObjeto(obj2))){
    if(obj1.length !== obj2.length) return false;
    for (let p in obj1) {
      //Check property exists on both objects
      if (obj1.hasOwnProperty(p) !== obj2.hasOwnProperty(p)) return false;

      switch (typeof (obj1[p])) {
        //Deep compare objects
        case 'object':
        if (!iguais(obj1[p], obj2[p])) return false;
        break;
        //Compare function code
        case 'function':
        if (typeof (obj2[p]) == 'undefined' || (p != 'compare' && obj1[p].toString() != obj2[p].toString())) return false;
        break;
        //Compare values
        default:
        if (obj1[p] !== obj2[p]) return false;
      }
    }
    return true;
  }
  return false;
};
