console.log('funcionando');
class Herois {
  constructor(heroi){
    this.heroi = heroi || [];
  }

  foraDaGuerraCivil(){
    return this.heroi.filter(heroi => heroi.events.items.filter(e => e.name.contem('Civil War')).length === 0)
  }

  maisPublicado(){
    return this.heroi.filter(heroi => heroi.comics.available === this.heroi.map(heroi => heroi.comics.available).sort(function(a,b){return b-a})[0]);
  }

  mediaPaginas(){
    let mediaDeCada = 0;
    let quantidadeQuadrinhos = 0;
    for(let chaveHeroi in this.heroi){
      let arrayItems = this.heroi.map(heroi => heroi.comics.items)[chaveHeroi];
      for(let chaveItem in arrayItems){
        mediaDeCada += arrayItems[chaveItem].pageCount;
        quantidadeQuadrinhos += 1;
      }
    }
    return mediaDeCada/quantidadeQuadrinhos;
  }

}
