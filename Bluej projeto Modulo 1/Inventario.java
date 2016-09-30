import java.util.ArrayList;

public class Inventario
{
    private ArrayList<Item> itens = new ArrayList<>();

    public void adicionarItem(String descricao, int quantidade){
        itens.add(new Item(descricao, quantidade));
    }

    public void removerItem(String descricao){
        for(int i=0; i < itens.size(); i++){
            if(itens.get(i).descricaoIgual(descricao)){
                itens.remove(i);
            }
        }
    }
    
    public ArrayList<Item> getItens(){
        return this.itens;
    }
    
    public int removendoUmaUnidade(String descricao){
        for(int i=0; i < itens.size(); i++){
            if(itens.get(i).descricaoIgual(descricao)){
                itens.get(i).diminuindoUnidade();
                return itens.get(i).getQuantidade();
            }
        }
        return 0;
    }
}
