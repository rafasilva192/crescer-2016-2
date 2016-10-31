// construtor
// function Elfo(nome, flechas) {
//   this.nome = nome;
//   this.flechas = flechas || 42;
// }
//
// Elfo.prototype.atirarFlecha = function() {
//   this.flechas--;
// }

class Elfo {
  constructor(nome, flechas = 42) {
    this._nome = nome;
    this.flechas = flechas;
  }
  static alturaMaximaElfos() {
    return 4.5;
  }
  atirarFlecha() {
    this.flechas--;
  }
  get nome() {
    return this._nome.toUpperCase();
  }
  set nome(val) {
    this._nome = val;
  }


}




// public class Elfo {
//  private String nome;
//  private int flechas;
//  public Elfo(String nome, int flechas) {
//    this.nome = nome;
//    this.flechas = flechas;
//  }
// public String getNome() { return nome; }
