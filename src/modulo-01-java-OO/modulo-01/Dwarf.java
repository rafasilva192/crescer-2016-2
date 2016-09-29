public class Dwarf {
    private int vida, experiencia;
    private DataTerceiraEra dataNascimento;
    private String nome;
    private Status status; //= Status.VIVO;

    // java type initializer
    // vai ser replicado para cada construtor
    {
        vida = 110;
        //status = Status.VIVO;
    }

    public Dwarf() {
        this(null, new DataTerceiraEra(1,1,1));
    }

    public Dwarf(String nome, DataTerceiraEra dataNascimento) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.status = Status.VIVO;
    }

    public void perderVida() {
        boolean estaMorto = status.equals(Status.MORTO);
        // sai do método
        if (estaMorto) {
            return;
        }

        double numero = this.getNumeroSorte();
        if (numero < 0) {
            this.experiencia += 2;
        }
        if (numero > 100) {
            int vidaAposFlechada = this.vida - 10;
            if (vidaAposFlechada == 0) {
                status = Status.MORTO;
            }
            if (vida > 0) {
                vida = vidaAposFlechada;
            }
        }
    }

    public int getVida() {
        return vida;
    }

    public int getExperiencia() {
        return experiencia;
    }

    public String getNome() {
        return this.nome;
    }

    public Status getStatus() {
        return status;
    }

    public DataTerceiraEra getDataNascimento() {
        return this.dataNascimento;
    }

    public double getNumeroSorte() {
        double resultado = 101.;
        boolean ehBissexto = dataNascimento.ehBissexto();

        if (ehBissexto && this.vida >= 80 && this.vida <= 90) {
            resultado *= -33.0;
        }
        //if (!dataNascimento.ehBissexto() && this.nome != null && (this.nome.equals("Seixas") || this.nome.equals("Meireles"))) {
        if (!ehBissexto && ("Seixas".equals(this.nome) || "Meireles".equals(this.nome))) {
            resultado = resultado * 33 % 100;
        }

        return resultado;
    }
}
// Dwarf gimli;