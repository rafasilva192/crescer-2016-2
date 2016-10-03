import java.util.ArrayList;

public class Inventario
{
    private ArrayList<Item> itens = new ArrayList<>();
    private TipoOrdenacao ordenacao;

    public void adicionarItem(Item item){
        itens.add(item);
    }

    public void removerItem(Item item){
        itens.remove(item);
    }

    public ArrayList<Item> getItens(){
        return this.itens;
    }

    public void dwarfMuitaSorte(){
        for(int i=0; i < itens.size(); i++){
            itens.get(i).dwarfMultiplicaItens();
        }
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

    public void ordernarItensAscendente(){
        this.ordernarItens(TipoOrdenacao.ASCENDENTE);
    }

    public void ordernarItens(TipoOrdenacao ordenacao){
        Item comparacao = null;
        boolean ascendente = ordenacao == TipoOrdenacao.ASCENDENTE;
        for(int i=0; i < itens.size(); ++i){
            for(int j=0; j< itens.size()-1; ++j){
                Item itemAtual = this.itens.get(j);
                Item proximo = this.itens.get(j + 1);
                //TO-DO Fazer logica pra decrescente
                boolean precisaTrocar = ascendente ? 
                        itemAtual.getQuantidade() > proximo.getQuantidade() : itemAtual.getQuantidade() < proximo.getQuantidade();
                if(precisaTrocar){
                    itens.set(j,proximo);
                    itens.set(j+1,itemAtual);
                }
            }
        }

    }
}

