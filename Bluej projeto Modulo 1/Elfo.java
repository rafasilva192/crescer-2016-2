import java.util.ArrayList;
public class Elfo extends Personagem
{
    public Elfo(String n){
        //chamando construtor de baixo
        this(n, 42);
    }

    public Elfo(String nome, int quantidadeFlechas){
        super(nome);
        this.vida = 100;
        inventario.adicionarItem(new Item("Arco", 1));
        inventario.adicionarItem(new Item ("Flechas",quantidadeFlechas >= 0 ? quantidadeFlechas : 42));
    }
    
    public Item getArco(){
        return this.inventario.getItens().get(0);
    }

    public Item getFlechas(){
        return this.inventario.getItens().get(1);
    }

    public String toString(){

        boolean flechaNoSingular = this.inventario.getItens().get(1).getQuantidade() == 1;
        boolean nivelNoSingular = this.experiencia == 1;
        return String.format("%s possui %d %s e %d %s de experiência.", this.nome,getFlechas().getQuantidade(), flechaNoSingular ? "flecha" : "flechas", this.experiencia, nivelNoSingular ? "nível" : "níveis");
        //return this.nome + " possui " + this.fle chas.getQuantidade() + " flechas e " + this.experiencia + " níveis de experiência.";
    }

    public void atirarFlecha(){
        if(getFlechas().getQuantidade() > 0){     
            inventario.removendoUnidades("Flechas", 1);
            experiencia++;
        }
    }
    
    protected void atirarFlechas(Dwarf dwarf, int fatorExp){
        if(getFlechas().getQuantidade() > 0){
            inventario.removendoUnidades("Flechas", 1);
            experiencia += 1 * fatorExp;
            dwarf.perderVida();
        }
    }

    public void atirarFlecha(Dwarf dwarf){
        if(getFlechas().getQuantidade() > 0){
            atirarFlecha();
            dwarf.perderVida();
        }
    }
}

/*public void atirarFlechaRefactory(){
experiencia++;
flechas.setQuantidade(flechas.getQuantidade()-1);
}*/
