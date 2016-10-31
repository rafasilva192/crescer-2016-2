function diglettDig() {
  for (let i = 1; i <= 100; i++) {
    let divisivelPor3 = i % 3 === 0;
    let divisivelPor5 = i % 5 === 0;
    let texto;

    if (divisivelPor3 && divisivelPor5) {
      texto = 'Diglett dig, trio trio trio';
    } else if (divisivelPor3) {
      texto = 'Diglett dig';
    } else if (divisivelPor5) {
      texto = 'trio trio trio';
    } else {
      texto = i;
    }
    console.log(texto);
  }
  console.log(texto.toUpperCase());
}
