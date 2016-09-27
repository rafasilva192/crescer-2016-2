public class Elfo
{
    private String nome;
    private Item arco;
    private Item flechas;
    private int experiencia;

    public Elfo(String n){
        nome = n;
        arco = new Item("Arco", 1);
        flechas = new Item("Flechas", 42);
    }

    public void setNome(String n){
        nome = n;
    }

    public String getNome(){
        return nome;
    }
public Item getArco(){
        return arco;
    }
    public void atirarFlecha(){
        flechas.setQuantidade(flechas.getQuantidade()-1);
        experiencia++;
    }

    /*public void atirarFlechaRefactory(){
        experiencia++;
        flechas.setQuantidade(flechas.getQuantidade()-1);
    }*/
}