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

    public int getExperiencia(){
        return experiencia;
    }

    public Item getFlechas(){
        return flechas;
    }

    public void atirarFlecha(){
        if(flechas.getQuantidade() > 0){     
            flechas.setQuantidade(flechas.getQuantidade()-1);
            experiencia++;
        }
    }

    public void atirarFlechaNoDwarf(Dwarf dwarf){
        if(flechas.getQuantidade() > 0){
            flechas.setQuantidade(flechas.getQuantidade()-1);
            dwarf.perderVida();
            experiencia++;
        }   
    }
}

/*public void atirarFlechaRefactory(){
experiencia++;
flechas.setQuantidade(flechas.getQuantidade()-1);
}*/
