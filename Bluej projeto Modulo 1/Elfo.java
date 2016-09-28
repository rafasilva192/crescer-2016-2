public class Elfo
{
    private String nome;
    private Item arco;
    private Item flechas;
    private int experiencia;
    private Dwarf vida;
    public Elfo(String n){
        nome = n;
        arco = new Item("Arco", 1);
        flechas = new Item("Flechas", 42);
        vida = new Dwarf();
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
    public Item getFlechas(){
        return flechas;
    }
    public Dwarf getVida(){
        return vida;
    }
    public void atirarFlecha(){
        if(flechas.getQuantidade() == 0){     
        }
        else{
        flechas.setQuantidade(flechas.getQuantidade()-1);
        experiencia++;
    }
    }
     public void atirarFlechaNoDwarf(){
        if(flechas.getQuantidade() == 0){}
        else{
        flechas.setQuantidade(flechas.getQuantidade()-1);
        if(vida.getVida() == 0){}
        else{
        vida.setVida(vida.getVida()-10);
        experiencia++;
    }
    }
    }

    /*public void atirarFlechaRefactory(){
    experiencia++;
    flechas.setQuantidade(flechas.getQuantidade()-1);
    }*/
}