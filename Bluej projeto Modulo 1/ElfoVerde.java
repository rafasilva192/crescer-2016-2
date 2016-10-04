import java.util.*;

public class ElfoVerde extends Elfo
{
    {
        getArco().setDescricao("Arco de Vidro");
        getFlechas().setDescricao("Flecha de Vidro");
    }
    public ElfoVerde(String Nome,int quantidade){
        super(Nome, quantidade);
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
            getFlechas().setQuantidade(quantidade-1);
            experiencia += 2;
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
            "Arco de Vidro",
            "Flecha de Vidro"
        };
    }

}
