var mesclar = function(obj1, obj2, recursiva = false) {

  for (var prop in obj2) {
    if (recursiva && typeof obj2[prop] === 'object') {
      mesclar(obj1[prop], obj2[prop], recursiva);
    } else {
      obj1[prop] = obj2[prop];
    }
  }

}
