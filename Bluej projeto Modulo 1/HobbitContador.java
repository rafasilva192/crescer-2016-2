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

public int getPares(){
    return arrayDePares.get(0).get(0);
}

public int calcularDiferenca(){
    int multiplicacao = 0;
    for(int i = 0; i < arrayDePares.size(); i++){
        multiplicacao = arrayDePares.get(0).get(0) * arrayDePares.get(0).get(1);
        
    }
    return multiplicacao;
}
}

// diferenca é 840

