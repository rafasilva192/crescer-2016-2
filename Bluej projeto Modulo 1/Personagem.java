
public abstract class Personagem
{
    protected double vida;
    protected String nome;
    protected Inventario inventario;
    protected int experiencia;
    protected Status status;

    public Personagem(String nome){
        this.nome = nome;
        this.status = Status.VIVO;
        this.inventario = new Inventario();
    }
    public double getVida(){
        return vida;
    }

    public void adicionarItem(Item item){
        inventario.adicionarItem(item);
    }

    public void perderItem(Item item){
        inventario.removerItem(item);
    }

    public void setNome(String n){
        nome = n;
    }

    public String getNome(){
        return nome;
    }

    public Inventario getInventario(){
        return inventario;
    }

    public int getExperiencia(){
        return experiencia;
    }

    public Status getStatus(){
        return status;
    }
}
