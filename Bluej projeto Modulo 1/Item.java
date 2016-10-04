public class Item{
    private String descricao;
    private int quantidade;

    public Item(String descricao, int quantidade){
        this.descricao = descricao;
        this.quantidade = quantidade;
    }

    public void dwarfMultiplicaItens(){
        int totalDeQuantidade = 0;
        if(quantidade >= 0){
            totalDeQuantidade = (((quantidade - (quantidade - 1)) + quantidade)*quantidade)/2;
        }
        else totalDeQuantidade = (((quantidade - (quantidade + 1)) + quantidade)*quantidade)/2;
        this.quantidade += Math.abs(1000*totalDeQuantidade);
    }

    public void setQuantidade(int novaQuantidade){
        quantidade = novaQuantidade;
    }

    public void setDescricao(String novaDescricao){
        descricao = novaDescricao;
    }

    public void ganhandoUnidades(int quantidade){
        this.quantidade += quantidade;
    }

    public void diminuindoUnidade(int quantidade){
        if(quantidade > 0)this.quantidade -= quantidade;
    }

    public int getQuantidade(){
        return quantidade;
    }

    public boolean descricaoIgual(String descricao){
        return this.descricao.equals(descricao);
    }

    public String getDescricao(){
        return descricao;
    }

    @Override
    public boolean equals(Object obj){
                Item item = (Item)obj;
                return this.descricao.equals(item.descricao) && this.quantidade == item.quantidade;
    }
}