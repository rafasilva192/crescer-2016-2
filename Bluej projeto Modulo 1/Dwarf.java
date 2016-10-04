import java.util.ArrayList;
public class Dwarf extends Personagem
{
    // instance variables - replace the example below with your own  
    protected DataTerceiraEra dataNascimento; 

    public Dwarf(){
        this(null,new DataTerceiraEra(1,1,1));
    }

    public Dwarf(String nome, DataTerceiraEra data){
        super(nome);
        this.vida = 110;
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

    public void tentarSorte(){
        if(this.getNumeroSorte()== -3333.0){
            inventario.ganhandoUnidades(1000);
        }
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
}
