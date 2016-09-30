import java.util.ArrayList;
public class IrishDwarf
{
    // instance variables - replace the example below with your own
    private String nome;
    private int vida = 110;
    private int experiencia;
    private DataTerceiraEra dataNascimento;
    private Status status;
    private Inventario inventarioDwarf;

    public IrishDwarf(){
        this(null,new DataTerceiraEra(1,1,1));
    }

    public IrishDwarf(String nome, DataTerceiraEra data){
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
    
    public Inventario getInventario(){
        return inventarioDwarf;
    }

    public Status getStatus(){
        return status;
    }
    
    public void tentarMuitaSorte(){
        if(this.getNumeroSorte()== -3333.0){
            inventarioDwarf.dwarfMuitaSorte();
        }
    }
    
    public void adicionarItem(Item item){
        inventarioDwarf.adicionarItem(item);
    }
    
    public void perderItem(Item item){
        inventarioDwarf.removerItem(item);
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
