public class Elfo
{
    private String nome;
    private Item arco;
    private Item flechas;
    private int experiencia;
    public Elfo(String n, int f){
        nome = n;
        arco = new Item("Arco", 1);
        flechas = new Item("Flechas", f);
        if(f == 0){
            f = 42;
        }
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
    
    public String toString(){
        
        boolean flechaNoSingular = this.flechas.getQuantidade() == 1;
        boolean nivelNoSingular = this.experiencia == 1;
        return String.format("%s possui %d %s e %d %s de experiência.", this.nome,this.flechas.getQuantidade(), flechaNoSingular ? "flecha" : "flechas", this.experiencia, nivelNoSingular ? "nível" : "níveis");
        //return this.nome + " possui " + this.fle chas.getQuantidade() + " flechas e " + this.experiencia + " níveis de experiência.";
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
