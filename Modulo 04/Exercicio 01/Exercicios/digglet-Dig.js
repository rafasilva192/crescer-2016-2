var diggletDig = function(){
  var i = 1;
  for(; i <= 100; i++){
    if(i%5 === 0 && i%3 === 0){
      console.log('digglet Dig, trio trio trio')
    }
    else if(i%3 === 0){
      console.log('digglet Dig');
    }
    else if(i%5 === 0 && i%3 !== 0){
      console.log('trio trio trio')
    }
    else{
      console.log(i)
    }
  }
}
