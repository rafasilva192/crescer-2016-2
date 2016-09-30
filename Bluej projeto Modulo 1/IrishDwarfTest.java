
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class IrishDwarfTest
{

    @Test
    public void irishDwarfMuitaSorte(){
        DataTerceiraEra dataNascimento = new DataTerceiraEra(1,1,400);
        IrishDwarf dwarf = new IrishDwarf("Moira",dataNascimento);
        dwarf.perderVida();
        dwarf.perderVida();
        dwarf.perderVida();
        dwarf.adicionarItem(new Item("Item de teste", 1));
        dwarf.tentarMuitaSorte();
        assertEquals(1001, dwarf.getInventario().getItens().get(0).getQuantidade());
    }
    
    @Test
    public void irishDwarfMuitaSorteComQuantidadeTres(){
        DataTerceiraEra dataNascimento = new DataTerceiraEra(1,1,400);
        IrishDwarf dwarf = new IrishDwarf("Moira",dataNascimento);
        dwarf.perderVida();
        dwarf.perderVida();
        dwarf.perderVida();
        dwarf.adicionarItem(new Item("Item de teste", 3));
        dwarf.tentarMuitaSorte();
        assertEquals(6003, dwarf.getInventario().getItens().get(0).getQuantidade());
    }
    
    @Test
    public void irishDwarfMuitaSorteComInventorioVazio(){
        DataTerceiraEra dataNascimento = new DataTerceiraEra(1,1,400);
        IrishDwarf dwarf = new IrishDwarf("Moira",dataNascimento);
        dwarf.perderVida();
        dwarf.perderVida();
        dwarf.perderVida();
        dwarf.tentarMuitaSorte();
        assertTrue(dwarf.getInventario().getItens().isEmpty());
    }
    
    @Test
    public void irishDwarfMuitaSorteNaoBissexto(){
        DataTerceiraEra dataNascimento = new DataTerceiraEra(1,1,399);
        IrishDwarf dwarf = new IrishDwarf("Moira",dataNascimento);
        dwarf.perderVida();
        dwarf.perderVida();
        dwarf.perderVida();
        dwarf.adicionarItem(new Item("Item de teste", 3));
        dwarf.tentarMuitaSorte();
        assertEquals(3, dwarf.getInventario().getItens().get(0).getQuantidade());
    }
    
    @Test
    public void irishDwarfMuitaSorteNaoBissextoMeireles(){
        DataTerceiraEra dataNascimento = new DataTerceiraEra(1,1,400);
        IrishDwarf dwarf = new IrishDwarf("Meireles",dataNascimento);
        dwarf.adicionarItem(new Item("Item de teste", 3));
        dwarf.tentarMuitaSorte();
        assertEquals(3, dwarf.getInventario().getItens().get(0).getQuantidade());
    }
}
