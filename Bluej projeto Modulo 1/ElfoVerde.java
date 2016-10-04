import java.util.*;

public class ElfoVerde extends Elfo
{
    public ElfoVerde(String Nome,int quantidade){
        super(Nome);
    }

    public void adicionarItem(Item item){
        //if(item.getDescricao().equals("Espada de aço valiriano") || item.getDescricao().equals("Arco e Flecha de Vidro")){
        String[] validas = getNomesValidos();
        boolean podeAdicionar = item != null && new ArrayList<>(Arrays.asList(validas)).contains(item.getDescricao());

        if (podeAdicionar) {
            super.adicionarItem(item);
        }
        //}
    }

    public void atirarFlecha(){
        int quantidade = getFlechas().getQuantidade();
        if(quantidade > 0){     
            super.atirarFlecha();
            experiencia++;
        }
    }

    public void atirarFlecha(Dwarf dwarf){
        if(getFlechas().getQuantidade() > 0){
            atirarFlecha();
            dwarf.perderVida();
        }
    }

    private String[] getNomesValidos(){
        return new String[] { 
            "Espada de aço valiriano", 
            "Arco e Flecha de Vidro"
        };
    }

}
