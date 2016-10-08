import java.util.*;
public class HobbitBolseiro
{
    public int obterMaiorMultiploDeTresAte(int Numero){
        int resultadoFinal = 0;
        while(true){
            resultadoFinal =  Numero%3;
            if(resultadoFinal == 0 || Numero < 3) break;
            Numero--;
        }
        return Numero;
    }
    
    public List<Integer> obterListaMultiploDeTresAte(int Numero){
        int resultadoFinal = 0;
        int incrementador = 0;
        List<Integer> lista = new ArrayList<Integer>();
        do{
            incrementador++;
            resultadoFinal =  incrementador%3;
            if(resultadoFinal == 0) lista.add(incrementador);
        }while(Numero!=incrementador);
        return lista;
    }
}
