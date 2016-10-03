import java.util.ArrayList;
public class IrishDwarf extends Dwarf
{
    // instance variables - replace the example below with your own
    public IrishDwarf(){
        this(null,new DataTerceiraEra(1,1,1));
    }

    public IrishDwarf(String nome, DataTerceiraEra data){
        dataNascimento = new DataTerceiraEra(data.getDia(), data.getMes(), data.getAno());
    }

    public void tentarMuitaSorte(){
        if(this.getNumeroSorte()== -3333.0){
            inventario.dwarfMuitaSorte();
        }
    }
}
