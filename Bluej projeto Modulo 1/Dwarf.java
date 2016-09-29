public class Dwarf
{
    // instance variables - replace the example below with your own
    private String nome;
    private int vida = 110;
    private int experiencia;
    private DataTerceiraEra dataNascimento;

    public Dwarf(){
        this.dataNascimento = new DataTerceiraEra(1,1,1);
    }

    public Dwarf(String nome, int dataNascimentoDia, int dataNascimentoMes, int dataNascimentoAno){
        this.nome = nome;
        this.dataNascimento = new DataTerceiraEra(dataNascimentoDia,dataNascimentoMes,dataNascimentoAno);
    }

    public double getNumeroSorte(){
        double numeroSorte = 101;
        if(dataNascimento.ehBissexto()){
            if(80 <= vida && vida <= 90){

                numeroSorte *= -33;

            }
        }
        else{
            if(nome == "Seixas" || nome == "Meireles"){
                numeroSorte = numeroSorte * 33 % 100;

            } 
        }
        return numeroSorte;
    }

    public String getNome(){
        return nome;
    }

    public void ganhaExperiencia(){
        experiencia += 2;
    }

    public int getExperiencia(){
        return experiencia;
    }

    public void perderVida(){
        vida -= 10;
    }

    public int getVida(){
        return vida;
    }
}
