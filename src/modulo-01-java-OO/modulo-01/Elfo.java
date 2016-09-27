public class Elfo {
    private String nome;
    private Item arco;
    private Item flecha;
    
    public Elfo(String n) {
        nome = n;
        arco = new Item("Arco", 1);
        flecha = new Item("Flechas", 2);
    }
    
    public void setNome(String n) {
        nome = n;
    }
    
    public String getNome() {
        return nome;
    }
    
    public void atirarFlecha() {
        flecha.setQuantidade(flecha.getQuantidade() - 1);
    }
}









