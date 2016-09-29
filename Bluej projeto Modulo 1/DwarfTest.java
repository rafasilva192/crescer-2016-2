

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class DwarfTest
{
    @Test
    public void dwarfNasceCom110Vida(){
        Dwarf Lifeless = new Dwarf();
        assertEquals(110, Lifeless.getVida());
    }
    @Test
    public void dwarfPerde10DeVidaPorFlecha(){
        Dwarf Lifeless = new Dwarf();
        Lifeless.perderVida();
        assertEquals(100, Lifeless.getVida());
    }
    @Test
    public void dwarfPerdeVida3Vezes(){
        Dwarf Lifeless = new Dwarf();
        Lifeless.perderVida();
        Lifeless.perderVida();
        Lifeless.perderVida();
        assertEquals(80, Lifeless.getVida());
    }
    @Test
    public void dwarfPerdeVida20Vezes(){
        Dwarf Lifeless = new Dwarf();
        Lifeless.perderVida();
        Lifeless.perderVida();
        Lifeless.perderVida();
        Lifeless.perderVida();
        Lifeless.perderVida();
        Lifeless.perderVida();
        Lifeless.perderVida();
        Lifeless.perderVida();
        Lifeless.perderVida();
        Lifeless.perderVida();
        Lifeless.perderVida();
        Lifeless.perderVida();
        Lifeless.perderVida();
        Lifeless.perderVida();
        Lifeless.perderVida();
        Lifeless.perderVida();
        Lifeless.perderVida();
        Lifeless.perderVida();
        Lifeless.perderVida();
        Lifeless.perderVida();
        assertEquals(-90, Lifeless.getVida());
    }
    @Test
    public void dwarfNumeroSorteAnoNaoBissexto(){
        Dwarf Lifeless = new Dwarf();
        assertTrue(Lifeless.getNumeroSorte() == 101);
    }
    @Test
    public void dwarfNumeroSorteAnoÉBissexto(){
        Dwarf Lifeless = new Dwarf("Batima",1,1,400);
        assertTrue(Lifeless.getNumeroSorte() == 101);
    } 
    @Test
    public void dwarfNumeroSorteAnoÉBissextoEPerdeuVida(){
        Dwarf Lifeless = new Dwarf("Batima",1,1,400);
        Lifeless.perderVida();
        Lifeless.perderVida();
        Lifeless.perderVida();
        assertTrue(Lifeless.getNumeroSorte() == -3333);
    }
    @Test
    public void dwarfSeixasGetSorteNaoBissexto(){
        Dwarf Lifeless = new Dwarf("Seixas",1,1,401);
        assertTrue(Lifeless.getNumeroSorte() == 33);
    }
    @Test
    public void dwarfSeixasGetSorteÉBissexto(){
        Dwarf Lifeless = new Dwarf("Seixas",1,1,400);
        assertTrue(Lifeless.getNumeroSorte() == 101);
    }
    @Test
    public void dwarfMeirelesGetSorteNaoBissexto(){
        Dwarf Lifeless = new Dwarf("Meireles",1,1,401);
        assertTrue(Lifeless.getNumeroSorte() == 33);
    }
    @Test
    public void dwarfMeirelesGetSorteÉBissexto(){
        Dwarf Lifeless = new Dwarf("Meireles",1,1,400);
        assertTrue(Lifeless.getNumeroSorte() == 101);
    }
}
