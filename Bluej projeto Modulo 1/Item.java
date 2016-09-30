public class Item{
    private String descricao;
    private int quantidade;

    public Item(String descricao, int quantidade){
        this.descricao = descricao;
        this.quantidade = quantidade;
    }

    public void setQuantidade(int novaQuantidade){
        quantidade = novaQuantidade;
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
}