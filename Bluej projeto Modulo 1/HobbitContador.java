import java.util.*;
public class HobbitContador
{
    private ArrayList<ArrayList<Integer>> arrayDePares = new ArrayList<>();
    private ArrayList<ArrayList<Integer>> arreyDoMMC = new ArrayList<>();
    private int[] MMCDosPares;

    public void adicionarPar(int  primeiroPar, int segundoPar){
        arrayDePares.add(new ArrayList<>(Arrays.asList(primeiroPar,segundoPar)));
        arreyDoMMC.add(new ArrayList<>(Arrays.asList(primeiroPar,segundoPar)));
    }

    public ArrayList<ArrayList<Integer>> getArrayDePares(){
        return arrayDePares;
    }

    public int calcularDiferenca(){
        int diferencaEntreMMCeMultiplicao = 0;
        int valorTotalMultiplicao = produtoDosPares();
        MMCDosPares();
        for(int i = 0; i < arreyDoMMC.size(); i++){
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

    private void MMCDosPares(){
        int MDCdoArray = 0;
        boolean multiplicarMMCDosPares = false; 
        while(!MMCCalculado()){
            for(int i = 0; i < arreyDoMMC.size(); i++){
                MDCdoArray = calcularMDCDosPares(i);
                for(int j = 0; j < 2; j++){
                    if(((arreyDoMMC.get(i).get(j)%MDCdoArray)==0) && arreyDoMMC.get(i).get(j) > 1){
                        multiplicarMMCDosPares = true;
                        arreyDoMMC.get(i).set(j,arreyDoMMC.get(i).get(j)/MDCdoArray);
                    }
                }
                if(multiplicarMMCDosPares)MMCDosPares[i] *= MDCdoArray;
                multiplicarMMCDosPares = false;
            }
        }
    }

    private boolean MMCCalculado(){
        int MMCTodosValoresIgualAUm = 1;
        for(int i = 0; i < arreyDoMMC.size(); i++){
            MMCTodosValoresIgualAUm *= arreyDoMMC.get(i).get(0) * arreyDoMMC.get(i).get(1);
        }
        return MMCTodosValoresIgualAUm == 1? true:false;    
    }

    private int calcularMDCDosPares(int indice){
        int primeiroNumeroMDC = maiorIndice(indice);
        int segundoNumeroMDC = menorIndice(primeiroNumeroMDC, indice);
        int numeroMDCFinal = 0;
        do{
            if(segundoNumeroMDC <= 1){
                return primeiroNumeroMDC;
            }
            numeroMDCFinal = primeiroNumeroMDC % segundoNumeroMDC;
            primeiroNumeroMDC = segundoNumeroMDC;
            segundoNumeroMDC = numeroMDCFinal;
        }while(numeroMDCFinal!=0);
        return primeiroNumeroMDC;
    }

    private int maiorIndice(int indice){
        int maiorValor = 0;
        for(int j = 0; j < 2; j++){
            if(arreyDoMMC.get(indice).get(j) > maiorValor){
                maiorValor = arreyDoMMC.get(indice).get(j);
            }
        }
        return maiorValor;
    }

    private int menorIndice(int maiorValor, int indice){
        int menorValor = maiorValor;
        for(int j = 0; j < 2; j++){
            if(arreyDoMMC.get(indice).get(j) < menorValor && arreyDoMMC.get(indice).get(j) > 1){
                menorValor = arreyDoMMC.get(indice).get(j);
            }
        }
        return menorValor;
    }
}

