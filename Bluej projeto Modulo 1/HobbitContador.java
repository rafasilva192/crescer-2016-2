import java.util.*;
public class HobbitContador
{
    private ArrayList<ArrayList<Integer>> arrayDePares = new ArrayList<>();

    public void adicionarPar(int  primeiroPar, int segundoPar){
        arrayDePares.add(new ArrayList<>(Arrays.asList(primeiroPar,segundoPar)));
    }

    public ArrayList<ArrayList<Integer>> getArrayDePares(){
        return arrayDePares;
    }

    public int calcularDiferenca(){
        int multiplicacao =0;
        int valorTotalMultiplicao = 0;
        int diferencaEntreMMCeMultiplicao = 0;
        produtoDosPares();
        MMCDosProdutos();
        for(int i = 0; i < arrayDePares.size(); i++){
            diferencaEntreMMCeMultiplicao += arrayDePares.get(i).get(1);
        }
        return valorTotalMultiplicao - diferencaEntreMMCeMultiplicao;
    }

    private void produtoDosPares(){
        for(int i = 0; i < arrayDePares.size(); i++){
            arrayDePares.get(i).set(0,arrayDePares.get(i).get(0) * arrayDePares.get(i).get(1));
            arrayDePares.get(i).set(1,1);
        }
    }

    private void MMCDosProdutos(){
        int MDCdoArray = 0;
        while(!MMCCalculado()){
            MDCdoArray = calcularMDCDosProdutos();
            for(int i = 0; i < arrayDePares.size(); i++){
                if((arrayDePares.get(i).get(0)%MDCdoArray)==0 && arrayDePares.get(i).get(0) > 1){
                    arrayDePares.get(i).set(0,arrayDePares.get(i).get(0)/MDCdoArray);
                    arrayDePares.get(i).set(1,arrayDePares.get(i).get(1)*MDCdoArray);
                }
            }
        }
    }

    private boolean MMCCalculado(){
        int MMCTodosValoresIgualAUm = 1;
        for(int i = 0; i < arrayDePares.size(); i++){
            MMCTodosValoresIgualAUm *= arrayDePares.get(i).get(0);
        }
        return MMCTodosValoresIgualAUm == 1? true:false;    
    }

    private int calcularMDCDosProdutos(){
        int primeiroNumeroMDC = maiorIndice();
        int segundoNumeroMDC = 0;
        int numeroMDCFinal = 0;
        int primeiroMaiorQueSegundo = 0;
        for(int i = 0; i < arrayDePares.size(); i++){
            segundoNumeroMDC = arrayDePares.get(i).get(0);
            if(segundoNumeroMDC > 1){
                do{
                    if(primeiroNumeroMDC >= segundoNumeroMDC){
                        primeiroMaiorQueSegundo = 1;
                        if(segundoNumeroMDC == 1){
                            return primeiroNumeroMDC;
                        }
                        numeroMDCFinal = primeiroNumeroMDC % segundoNumeroMDC;
                        primeiroNumeroMDC = segundoNumeroMDC;
                        segundoNumeroMDC = numeroMDCFinal;
                    }else{
                        primeiroMaiorQueSegundo = 0;
                        if(primeiroNumeroMDC == 1){
                            return segundoNumeroMDC;
                        }
                        numeroMDCFinal = segundoNumeroMDC % primeiroNumeroMDC;
                        segundoNumeroMDC = primeiroNumeroMDC;
                        primeiroNumeroMDC = numeroMDCFinal;
                    }
                }while(numeroMDCFinal!=0);
            }
        }
        return primeiroMaiorQueSegundo == 1? primeiroNumeroMDC:segundoNumeroMDC;
    }

    private int maiorIndice(){
        int maiorValor = 0;
        for(int i = 0; i < arrayDePares.size(); i++){
            if(arrayDePares.get(i).get(0) > maiorValor) maiorValor = arrayDePares.get(i).get(0);
        }
        return maiorValor;
    }
}

