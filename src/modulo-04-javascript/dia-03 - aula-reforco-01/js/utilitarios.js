// "Civil War do CRESCER".contem("Civil War") => true

String.prototype.contem = function(subtexto, ignoreCase = false) {
  if (ignoreCase) {
    return this.toUpperCase().indexOf(subtexto.toUpperCase()) !== -1;
  }
  return this.indexOf(subtexto) !== -1;
}

String.prototype.toBacon = function() {
  return this + "BACON!!!!!";
}
