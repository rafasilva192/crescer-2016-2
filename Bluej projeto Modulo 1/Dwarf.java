import java.util.ArrayList;
public class Dwarf
{
    // instance variables - replace the example below with your own
    private String nome;
    private int vida = 110;
    private int experiencia;
    private DataTerceiraEra dataNascimento;
    private Status status;
    private Inventario inventarioDwarf;

    public Dwarf(){
        this(null,new DataTerceiraEra(1,1,1));
    }

    public Dwarf(String nome, DataTerceiraEra data){
        inventarioDwarf = new Inventario();
        this.nome = nome;
        dataNascimento = new DataTerceiraEra(data.getDia(), data.getMes(), data.getAno());
        status = Status.VIVO;
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

    public Status getStatus(){
        return status;
    }
    
    public void adicionarItem(String descricao, int quantidade){
        inventarioDwarf.adicionarItem(descricao,quantidade);
    }
    
    public void perderItem(String descricao){
        inventarioDwarf.removerItem(descricao);
    }

    public void perderVida(){
        if(Status.VIVO.equals(status)){
            double numeroSorte = this.getNumeroSorte();
            if(numeroSorte < 0){
                experiencia += 2;
            }
            if(numeroSorte > 100){
                this.vida -= 10;
                if (this.vida <= 0){
                    this.vida = 0;
                    status = Status.MORTO;
                }
            }         
        }

    }

    public int getVida(){
        return vida;
    }
}
