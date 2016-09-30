import java.util.ArrayList;
public class Elfo
{
    private String nome;
    private Inventario inventarioElfo;
    private int experiencia;
    private Status status;
    private Item item;

    public Elfo(String n){
        //chamando construtor de baixo
        this(n, 42);
    }

    public Elfo(String nome, int quantidadeFlechas){
        inventarioElfo = new Inventario();
        this.nome = nome;
        inventarioElfo.adicionarItem("Arco",1);
        inventarioElfo.adicionarItem("Flechas",quantidadeFlechas >= 0 ? quantidadeFlechas : 42);
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

    public String getArco(){
        return inventarioElfo.getItens().get(0).getDescricao();
    }

    public int getExperiencia(){
        return experiencia;
    }

    public int getFlechas(){
        return inventarioElfo.getItens().get(1).getQuantidade();
    }

    public String toString(){

        boolean flechaNoSingular = this.inventarioElfo.getItens().get(1).getQuantidade() == 1;
        boolean nivelNoSingular = this.experiencia == 1;
        return String.format("%s possui %d %s e %d %s de experiência.", this.nome,this.inventarioElfo.getItens().get(1).getQuantidade(), flechaNoSingular ? "flecha" : "flechas", this.experiencia, nivelNoSingular ? "nível" : "níveis");
        //return this.nome + " possui " + this.fle chas.getQuantidade() + " flechas e " + this.experiencia + " níveis de experiência.";
    }

    public void atirarFlecha(){
        if(inventarioElfo.getItens().get(1).getQuantidade() > 0){     
            inventarioElfo.removendoUmaUnidade("Flechas");
            experiencia++;
        }
    }

    public void atirarFlechaNoDwarf(Dwarf dwarf){
        if(inventarioElfo.getItens().get(1).getQuantidade() > 0){
            inventarioElfo.removendoUmaUnidade("Flechas");
            experiencia++;
            dwarf.perderVida();
            }
        }
    }


/*public void atirarFlechaRefactory(){
experiencia++;
flechas.setQuantidade(flechas.getQuantidade()-1);
}*/
