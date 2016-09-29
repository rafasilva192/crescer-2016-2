
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
}
