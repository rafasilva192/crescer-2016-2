class Herois {

  constructor(array) {
    this.herois = array;
  }

  foraDaGuerraCivil() {

    return this.herois.filter(heroi =>
      heroi.events.items.filter(e => e.name.contem('CiVIl war', true)).length === 0
    )

  }

}
