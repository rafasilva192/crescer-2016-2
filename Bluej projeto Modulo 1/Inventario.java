import java.util.ArrayList;

public class Inventario
{
    ArrayList<Item> itens = new ArrayList<>();

    public void adicionarItem(String descricao, int quantidade){        
       itens.add(new Item(descricao, quantidade));
    }
    
    public void removerItem(String descricao){
        for(int i = 0; i < itens.size(); i++){
            Item itemAtual = itens.get(i);
            if(descricao.equals(itemAtual.getDescricao())){
                itens.remove(descricao);
            }
        }
    }
}
