

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
}
