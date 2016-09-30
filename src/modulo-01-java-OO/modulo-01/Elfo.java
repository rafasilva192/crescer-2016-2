public class Elfo {
    private String nome;
    private int experiencia;
    private Status status;
    private Inventario inventario;

    public Elfo(String n) {
        // Chamando construtor debaixo
        this(n, 42);
    }

    public Elfo(String nome, int quantidadeFlechas) {
        this.nome = nome;
        this.inventario = new Inventario();
        this.inventario.adicionarItem(new Item("Arco", 1));
        this.inventario.adicionarItem(new Item("Flechas", quantidadeFlechas >= 0 ? quantidadeFlechas : 42));
        status = Status.VIVO;
    }

    public void setNome(String n) {
        nome = n;
    }

    public String getNome() {
        return nome;
    }

    public Item getArco() {
        return this.inventario.getItens().get(0);
    }

    public int getExperiencia() {
        return experiencia;
    }

    public Item getFlecha() {
        return this.inventario.getItens().get(1);
    }

    public Status getStatus() {
        return status;
    }

    public void atirarFlecha(Dwarf dwarf) {
        int quantidadeFlechas = getFlecha().getQuantidade();
        boolean temFlecha = quantidadeFlechas > 0;
        if (temFlecha) {
            getFlecha().setQuantidade(quantidadeFlechas - 1);
            experiencia++;
            dwarf.perderVida();
        }
    }

    public String toString() {
        //return "<nome> possui <flechas> flechas e <exp> níveis de experiência.";

        int quantidadeFlechas = this.getFlecha().getQuantidade();
        boolean flechaNoSingular = quantidadeFlechas == 1;
        boolean experienciaNoSingular = this.experiencia == 0 || this.experiencia == 1;

        return String.format("%s possui %d %s e %d %s de experiência.",
            this.nome,
            quantidadeFlechas,
            // ?:
            flechaNoSingular ? "flecha" : "flechas",
            this.experiencia,
            experienciaNoSingular ? "nível" : "níveis"
        );
    }

    /*public void atirarFlechaRefactory() {
    experiencia++;
    flecha.setQuantidade(flecha.getQuantidade()-1);
    }*/
}

