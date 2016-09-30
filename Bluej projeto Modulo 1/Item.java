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
    
    public void diminuindoUnidade(){
        if(quantidade > 0)quantidade -= 1;
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