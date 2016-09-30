import java.util.ArrayList;

public class Inventario
{
    private ArrayList<Item> itens = new ArrayList<>();

    public void adicionarItem(Item item){
        itens.add(item);
    }

    public void removerItem(Item item){
        itens.remove(item);
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
        String descricaoDosItens="";
        /*for(int i=0; i < itens.size(); ++i){
        descricaoDosItens += itens.get(i).getDescricao() + ",";
        }*/
        for(Item item: itens){
            descricaoDosItens += item.getDescricao() + ",";
        }
        return descricaoDosItens.isEmpty() ? "" : descricaoDosItens.substring(0,descricaoDosItens.length()-1);
    }

    public Item itemMaisPopular(){
        int comparacao = 0;
        Item itemPopular = null;
        for(int i=0; i < itens.size(); ++i){
            if(comparacao < itens.get(i).getQuantidade()){
                comparacao = itens.get(i).getQuantidade();
                itemPopular = itens.get(i);
            }
        }
        return itens.isEmpty() ? null:itemPopular;
    }
    
    public void ordernarItens(){
        Item comparacao = null;
                for(int i=0; i < itens.size(); ++i){
            for(int j=0; j< itens.size()-1; ++j){
            if(itens.get(j).getQuantidade() > itens.get(j+1).getQuantidade()){
                comparacao = itens.get(j);
                itens.set(j,itens.get(j+1));
                itens.set(j+1,comparacao);
            }
        }
    }
    }
}

