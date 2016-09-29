public class Dwarf
{
    // instance variables - replace the example below with your own
    private String nome;
    private int vida = 110;
    private int experiencia;
    private DataTerceiraEra dataNascimento;

    public Dwarf(){
        this(null,new DataTerceiraEra(1,1,1));
    }

    public Dwarf(String nome, DataTerceiraEra data){
        this.nome = nome;
        dataNascimento = new DataTerceiraEra(data.getDia(), data.getMes(), data.getAno());
    }

    public double getNumeroSorte(){
        double numeroSorte = 101.;
        if(dataNascimento.ehBissexto()){
            if(80 <= vida && vida <= 90){
                numeroSorte *= -33.;
            }
        }
        else{
            if("Seixas".equals(this.nome) || "Meireles".equals(this.nome)){
                numeroSorte = numeroSorte * 33 % 100;
            } 
        }
        return numeroSorte;
    }

    public String getNome(){
        return nome;
    }

    public int getExperiencia(){
        return experiencia;
    }

    public void perderVida(){
        double numeroSorte = getNumeroSorte();
        if(numeroSorte < 0){
            experiencia += 2;
        }
        else if(numeroSorte > 100){  
            vida -= 10;
        }

    }
    public int getVida(){
        return vida;
    }
}
