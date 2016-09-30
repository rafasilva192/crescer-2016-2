
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DwarfTest
{
    @Test
    public void dwarfNasceCom110Vida(){
        Dwarf dwarf = new Dwarf();
        assertEquals(110, dwarf.getVida());
    }

    @Test
    public void dwarfPerde10DeVidaPorFlecha(){
        Dwarf dwarf = new Dwarf();
        dwarf.perderVida();
        assertEquals(100, dwarf.getVida());
    }

    @Test
    public void dwarfPerdeVida3Vezes(){
        Dwarf dwarf = new Dwarf();
        dwarf.perderVida();
        dwarf.perderVida();
        dwarf.perderVida();
        assertEquals(80, dwarf.getVida(), .0);
    }

    @Test
    public void dwarfPerdeVida20Vezes(){
        Dwarf dwarf = new Dwarf();
        int x=0;
        while(x++ < 20){
            dwarf.perderVida();
        }
        assertEquals(0, dwarf.getVida());
    }

    @Test
    public void dwarfNumeroSorteAnoNaoBissexto(){
        Dwarf dwarf = new Dwarf();
        assertTrue(dwarf.getNumeroSorte() == 101);
    }

    @Test
    public void dwarfNumeroSorteAnoÉBissexto(){
        DataTerceiraEra dataNascimento = new DataTerceiraEra(1,1,400);
        Dwarf dwarf = new Dwarf("Batima", dataNascimento);
        assertTrue(dwarf.getNumeroSorte() == 101);
    } 

    @Test
    public void dwarfNumeroSorteAnoÉBissextoEPerdeuVida(){
        DataTerceiraEra dataNascimento = new DataTerceiraEra(1,1,400);
        Dwarf dwarf = new Dwarf("Batima", dataNascimento);
        dwarf.perderVida();
        dwarf.perderVida();
        dwarf.perderVida();
        assertTrue(dwarf.getNumeroSorte() == -3333);
    }

    @Test
    public void dwarfSeixasGetSorteNaoBissexto(){
        DataTerceiraEra dataNascimento = new DataTerceiraEra(1,1,401);
        Dwarf dwarf = new Dwarf("Seixas", dataNascimento);
        assertTrue(dwarf.getNumeroSorte() == 33);
    }

    @Test
    public void dwarfSeixasGetSorteÉBissexto(){
        DataTerceiraEra dataNascimento = new DataTerceiraEra(1,1,400);
        Dwarf dwarf = new Dwarf("Seixas", dataNascimento);
        assertTrue(dwarf.getNumeroSorte() == 101);
    }

    @Test
    public void dwarfMeirelesGetSorteNaoBissexto(){
        DataTerceiraEra dataNascimento = new DataTerceiraEra(1,1,401);
        Dwarf dwarf = new Dwarf("Meireles", dataNascimento);
        assertTrue(dwarf.getNumeroSorte() == 33);
    }

    @Test
    public void dwarfMeirelesGetSorteÉBissexto(){
        DataTerceiraEra dataNascimento = new DataTerceiraEra(1,1,400);
        Dwarf dwarf = new Dwarf("Meireles", dataNascimento);
        assertTrue(dwarf.getNumeroSorte() == 101);
    }

    @Test
    public void dwarfNasceVivo(){
        Dwarf dwarf = new Dwarf("Meireles",new DataTerceiraEra(1,1,400));
        assertEquals(Status.VIVO,dwarf.getStatus());
    }

    @Test
    public void dwarfMorre(){
        Dwarf dwarf = new Dwarf();
        int x=0;
        while(x++ < 20){
            dwarf.perderVida();
        }
        assertEquals(Status.MORTO,dwarf.getStatus());
    }

    @Test
    public void dwarfNaoDeveVida(){

        Dwarf dwarf = new Dwarf();
        int x=0;
        while(x++ < 20){
            dwarf.perderVida();
        }
        assertEquals(0,dwarf.getVida());
    }

    @Test
    public void dwarfMorreComOverKillDe189(){
        Dwarf dwarf = new Dwarf();
        int x=0;
        while(x++ < 200){
            dwarf.perderVida();
        }
        assertEquals(Status.MORTO,dwarf.getStatus());
        assertEquals(0,dwarf.getVida());
    }

    @Test
    public void dwarfRecebeUmItem(){
        Dwarf dwarf = new Dwarf();
        dwarf.adicionarItem(new Item("Item de teste", 66));
        assertEquals("Item de teste", dwarf.getInventario().getItens().get(0).getDescricao());
        assertEquals(66, dwarf.getInventario().getItens().get(0).getQuantidade());
    }

    @Test
    public void dwarfRecebeDoisItens(){
        Dwarf dwarf = new Dwarf();
        dwarf.adicionarItem(new Item("Item de teste", 66));
        dwarf.adicionarItem(new Item("Item de teste2", 32));
        assertEquals("Item de teste", dwarf.getInventario().getItens().get(0).getDescricao());
        assertEquals("Item de teste2", dwarf.getInventario().getItens().get(1).getDescricao());
        assertEquals(66, dwarf.getInventario().getItens().get(0).getQuantidade());
        assertEquals(32, dwarf.getInventario().getItens().get(1).getQuantidade());
    }

    @Test
    public void dwarfRecebeCincoItens(){
        Dwarf dwarf = new Dwarf();
        dwarf.adicionarItem(new Item("Item de teste", 1));
        dwarf.adicionarItem(new Item("Item de teste2", 2));
        dwarf.adicionarItem(new Item("Item de teste3", 3));
        dwarf.adicionarItem(new Item("Item de teste4", 4));
        dwarf.adicionarItem(new Item("Item de teste5", 5));
        assertEquals("Item de teste", dwarf.getInventario().getItens().get(0).getDescricao());
        assertEquals("Item de teste2", dwarf.getInventario().getItens().get(1).getDescricao());
        assertEquals("Item de teste3", dwarf.getInventario().getItens().get(2).getDescricao());
        assertEquals("Item de teste4", dwarf.getInventario().getItens().get(3).getDescricao());
        assertEquals("Item de teste5", dwarf.getInventario().getItens().get(4).getDescricao());
        assertEquals(1, dwarf.getInventario().getItens().get(0).getQuantidade());
        assertEquals(2, dwarf.getInventario().getItens().get(1).getQuantidade());
        assertEquals(3, dwarf.getInventario().getItens().get(2).getQuantidade());
        assertEquals(4, dwarf.getInventario().getItens().get(3).getQuantidade());
        assertEquals(5, dwarf.getInventario().getItens().get(4).getQuantidade());
    }

    @Test
    public void dwarfPerdeUmItem(){
        Dwarf dwarf = new Dwarf();
        Item item = new Item("Item de teste", 1);
        dwarf.adicionarItem(item);
        dwarf.perderItem(item);        
        assertTrue(dwarf.getInventario().getItens().isEmpty());
    }

    @Test
    public void dwarfLeprechaunGanha1000(){
        DataTerceiraEra dataNascimento = new DataTerceiraEra(1,1,400);
        Dwarf dwarf = new Dwarf("Moira",dataNascimento);
        dwarf.perderVida();
        dwarf.perderVida();
        dwarf.perderVida();
        dwarf.adicionarItem(new Item("Item de teste", 1));
        dwarf.tentarSorte();
        assertEquals(1001, dwarf.getInventario().getItens().get(0).getQuantidade());
    }

    @Test
    public void dwarfLeprechaunGanha1000Em4Itens(){
        DataTerceiraEra dataNascimento = new DataTerceiraEra(1,1,400);
        Dwarf dwarf = new Dwarf("Moira",dataNascimento);
        dwarf.perderVida();
        dwarf.perderVida();
        dwarf.perderVida();
        dwarf.adicionarItem(new Item("Item de teste", 1));
        dwarf.adicionarItem(new Item("Item de teste", 1));
        dwarf.adicionarItem(new Item("Item de teste", 1));
        dwarf.adicionarItem(new Item("Item de teste", 1));
        dwarf.tentarSorte();
        assertEquals(1001, dwarf.getInventario().getItens().get(0).getQuantidade());
        assertEquals(1001, dwarf.getInventario().getItens().get(1).getQuantidade());
        assertEquals(1001, dwarf.getInventario().getItens().get(2).getQuantidade());
        assertEquals(1001, dwarf.getInventario().getItens().get(3).getQuantidade());
    }

    @Test
    public void dwarfLeprechaunNaoGanha1000(){
        Dwarf dwarf = new Dwarf();
        dwarf.adicionarItem(new Item("Item de teste", 66));
        dwarf.tentarSorte();
        assertEquals(66, dwarf.getInventario().getItens().get(0).getQuantidade());
    }

    @Test
    public void dwarfLeprechaunAnoBissextoCom110DeVida(){
        DataTerceiraEra dataNascimento = new DataTerceiraEra(1,1,400);
        Dwarf dwarf = new Dwarf("Moira",dataNascimento);
        dwarf.adicionarItem(new Item("Item de teste",66));
        dwarf.tentarSorte();
        assertEquals(66, dwarf.getInventario().getItens().get(0).getQuantidade());
    }

    @Test
    public void dwarfLeprechaunMeirelesNaoGanha1000(){
        DataTerceiraEra dataNascimento = new DataTerceiraEra(1,1,399);
        Dwarf dwarf = new Dwarf("Meireles",dataNascimento);
        dwarf.perderVida();
        dwarf.perderVida();
        dwarf.perderVida();
        dwarf.adicionarItem(new Item("Item de teste", 66));
        dwarf.tentarSorte();
        assertEquals(66, dwarf.getInventario().getItens().get(0).getQuantidade());
    }
}