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

    public void removendoUnidades(String descricao, int quantidade){
        for(int i=0; i < itens.size(); i++){
            if(itens.get(i).descricaoIgual(descricao)){
                itens.get(i).diminuindoUnidade(quantidade);
            }
        }
    }

    public void ganhandoUnidades(int quantidade){
        for(int i=0; i < itens.size(); i++){
            itens.get(i).ganhandoUnidades(quantidade);
        }
    }

    public String getDescricoesItens(){
        String descricaoDosItens=itens.get(0).getDescricao();
        for(int i=1; i < itens.size(); ++i){
            descricaoDosItens += ", ";
            descricaoDosItens += itens.get(i).getDescricao();
        }
        return descricaoDosItens;
    }

    public Item itemMaisPopular(){
        int comparacao = itens.get(0).getQuantidade();
        Item itemPopular = itens.get(0);
        for(int i=1; i < itens.size(); ++i){
            if(comparacao < itens.get(i).getQuantidade()){
                comparacao = itens.get(i).getQuantidade();
                itemPopular = itens.get(i);
            }
        }
        return itemPopular;
    }
}

