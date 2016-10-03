import java.util.*;
public class HobbitContador
{
    private ArrayList<ArrayList<Integer>> arrayDePares = new ArrayList<>();
    private int[] MMCDosPares;

    public void adicionarPar(int  primeiroPar, int segundoPar){
        arrayDePares.add(new ArrayList<>(Arrays.asList(primeiroPar,segundoPar)));
    }

    public ArrayList<ArrayList<Integer>> getArrayDePares(){
        return arrayDePares;
    }

    public int calcularDiferenca(){
        int diferencaEntreMMCeMultiplicao = 0;
        int valorTotalMultiplicao = produtoDosPares();
        MMCDosProdutos();
        for(int i = 0; i < arrayDePares.size(); i++){
            diferencaEntreMMCeMultiplicao += MMCDosPares[i];
        }
        return valorTotalMultiplicao - diferencaEntreMMCeMultiplicao;
    }

    public int produtoDosPares(){
        int valorTotalMultiplicao =0;
        MMCDosPares = new int[arrayDePares.size()];
        for(int i = 0; i < arrayDePares.size(); i++){
            valorTotalMultiplicao += arrayDePares.get(i).get(0) * arrayDePares.get(i).get(1);
            MMCDosPares[i] = 1;
        }
        return valorTotalMultiplicao;
    }

    private void MMCDosProdutos(){
        int MDCdoArray = 0;
        boolean naoMultiplicarMMCDosPares = false; 
        while(!MMCCalculado()){
            MDCdoArray = calcularMDCDosProdutos();
            for(int i = 0; i < arrayDePares.size(); i++){
                if(((arrayDePares.get(i).get(0)%MDCdoArray)==0) && arrayDePares.get(i).get(0) > 1){
                    MMCDosPares[i] *= MDCdoArray;
                    naoMultiplicarMMCDosPares = true;
                    arrayDePares.get(i).set(0,arrayDePares.get(i).get(0)/MDCdoArray);
                }if(((arrayDePares.get(i).get(1)%MDCdoArray)==0) && arrayDePares.get(i).get(1) > 1){
                    if(!naoMultiplicarMMCDosPares)MMCDosPares[i] *= MDCdoArray;
                    arrayDePares.get(i).set(1,arrayDePares.get(i).get(1)/MDCdoArray);
                }
                naoMultiplicarMMCDosPares = false;
            }
        }
    }

    private boolean MMCCalculado(){
        int MMCTodosValoresIgualAUm = 1;
        for(int i = 0; i < arrayDePares.size(); i++){
            MMCTodosValoresIgualAUm *= arrayDePares.get(i).get(0) * arrayDePares.get(i).get(1);
        }
        return MMCTodosValoresIgualAUm == 1? true:false;    
    }

    private int calcularMDCDosProdutos(){
        int primeiroNumeroMDC = maiorIndice();
        int segundoNumeroMDC = menorIndice(primeiroNumeroMDC);
        int numeroMDCFinal = 0;
        for(int i = 0; i < arrayDePares.size(); i++){
            if(segundoNumeroMDC > 1){
                do{
                    if(primeiroNumeroMDC >= segundoNumeroMDC){
                        if(segundoNumeroMDC == 1){
                            return primeiroNumeroMDC;
                        }
                        numeroMDCFinal = primeiroNumeroMDC % segundoNumeroMDC;
                        primeiroNumeroMDC = segundoNumeroMDC;
                        segundoNumeroMDC = numeroMDCFinal;
                    }
                }while(numeroMDCFinal!=0);
            }
        }
        return primeiroNumeroMDC;
    }

    private int maiorIndice(){
        int maiorValor = 0;
        for(int i = 0; i < arrayDePares.size(); i++){
            if(arrayDePares.get(i).get(0) > maiorValor) maiorValor = arrayDePares.get(i).get(0);        
        }
        for(int i = 0; i < arrayDePares.size(); i++){
            if(arrayDePares.get(i).get(1) > maiorValor) maiorValor = arrayDePares.get(i).get(1);        
        }
        return maiorValor;
    }

    private int menorIndice(int maiorValor){
        int menorValor = maiorValor;
        for(int i = 0; i < arrayDePares.size(); i++){
            if(arrayDePares.get(i).get(0) < menorValor && arrayDePares.get(i).get(0) != 1){
                menorValor = arrayDePares.get(i).get(0);
            }
        }
        for(int i = 0; i < arrayDePares.size(); i++){
            if(arrayDePares.get(i).get(1) < menorValor && arrayDePares.get(i).get(1) != 1){ 
                menorValor = arrayDePares.get(i).get(1);
            }        
        }
        return menorValor;
    }
}

