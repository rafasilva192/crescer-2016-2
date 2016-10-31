// console.log(subtrair(-2)(-1)); // 1
// var fn = subtrair(-1);
// console.log(fn(2));

function subtrair(num1) {
  return function(num2) {
    return num1 - num2;
  }
}
