public class Elfo
{
    private String nome;
    private Item arco;
    private Item flechas;
    private int experiencia;
    private Status status;

    public Elfo(String n){
        //chamando construtor de baixo
        this(n, 42);
    }

    public Elfo(String nome, int quantidadeFlechas){
        this.nome = nome;
        arco = new Item("Arco", 1);
        flechas = new Item("Flechas", quantidadeFlechas >= 0 ? quantidadeFlechas : 42);
        status = Status.VIVO;    
    }
    
    public Status getStatus(){
        return status;
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
            experiencia++;
            dwarf.perderVida();
            }
        }
    }


/*public void atirarFlechaRefactory(){
experiencia++;
flechas.setQuantidade(flechas.getQuantidade()-1);
}*/
