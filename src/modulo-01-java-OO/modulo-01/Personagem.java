public abstract class Personagem {
    protected String nome;
    protected int experiencia;
    protected Inventario inventario;
    protected Status status; //= Status.VIVO;
    protected double vida;

    public Personagem(String nome) {
        this.nome = nome;
        this.status = Status.VIVO;
        this.inventario = new Inventario();
    }

    public void setNome(String n) {
        nome = n;
    }

    public String getNome() {
        return nome;
    }

    public Inventario getInventario() {
        return inventario;
    }

    public Status getStatus() {
        return status;
    }

    public int getExperiencia() {
        return experiencia;
    }

    public double getVida() {
        return vida;
    }

    public void adicionarItem(Item item) {
        this.inventario.adicionarItem(item);
    }

    public void perderItem(Item item) {
        this.inventario.removerItem(item);
    }
    
    abstract void inicializarInventario(int quantidadeFlechas);
}
