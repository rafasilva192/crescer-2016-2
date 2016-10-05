
import java.util.ArrayList;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ExercitoDeElfoTest
{
    @After
    public void tearDown(){
        System.gc();
    }

    @Test
    public void elfoNoturnoEntraNoExercito(){
        ExercitoDeElfo test = new ExercitoDeElfo();
        test.exercitoDeElfo(new ElfoNoturno("Malfurion", 1));
        assertEquals("Malfurion", test.buscarNoExercito("Malfurion").getNome());
    }

    @Test
    public void elfoNoturnoEElfoVerdeEntramNoExercito(){
        ExercitoDeElfo test = new ExercitoDeElfo();
        test.exercitoDeElfo(new ElfoNoturno("Malfurion", 1));
        test.exercitoDeElfo(new ElfoVerde("Valeera", 1));
        assertEquals("Malfurion", test.buscarNoExercito("Malfurion").getNome());
        assertEquals("Valeera", test.buscarNoExercito("Valeera").getNome());
    }

    @Test
    public void tresElfosNoturnosEntramNoExercito(){
        ExercitoDeElfo test = new ExercitoDeElfo();
        test.exercitoDeElfo(new ElfoNoturno("Malfurion", 1));
        test.exercitoDeElfo(new ElfoNoturno("Illidan", 1));
        test.exercitoDeElfo(new ElfoNoturno("Tyrande", 1));
        assertEquals("Malfurion", test.buscarNoExercito("Malfurion").getNome());
        assertEquals("Illidan", test.buscarNoExercito("Illidan").getNome());
        assertEquals("Tyrande", test.buscarNoExercito("Tyrande").getNome());
    }

    @Test
    public void elfoNormalNaoEntraNoExercito(){
        ExercitoDeElfo test = new ExercitoDeElfo();
        test.exercitoDeElfo(new Elfo("Legolas", 1));
        assertNull(test.buscarNoExercito("Legolas"));
    }

    @Test
    public void buscarPorStatusVivo(){
        ExercitoDeElfo test = new ExercitoDeElfo();
        Elfo recruta1 = new ElfoNoturno("Malfurion", 1);
        Elfo recruta2 = new ElfoNoturno("Illidan", 1);
        Elfo recruta3 = new ElfoNoturno("Tyrande", 1);
        test.exercitoDeElfo(recruta1);
        test.exercitoDeElfo(recruta2);
        test.exercitoDeElfo(recruta3);
        ArrayList<Elfo> resultado = test.buscarPorStatus(Status.VIVO);
        assertEquals(recruta1 , resultado.get(0));
        assertEquals(recruta2 , resultado.get(1));
        assertEquals(recruta3 , resultado.get(2));
    }

    @Test
    public void buscarPorStatusVivoNenhumVivo(){
        ExercitoDeElfo test = new ExercitoDeElfo();
        Elfo recruta1 = new ElfoNoturno("Malfurion", 200);
        test.exercitoDeElfo(recruta1);
        for(int x = 0; x < 200; x++){
            recruta1.atirarFlecha(new Dwarf());
        }
        ArrayList<Elfo> resultado = test.buscarPorStatus(Status.VIVO);
        assertTrue(resultado.isEmpty());
    }

    @Test
    public void buscarPorStatusMorto(){
        ExercitoDeElfo test = new ExercitoDeElfo();
        Elfo recruta1 = new ElfoNoturno("Malfurion", 200);
        test.exercitoDeElfo(recruta1);
        for(int x = 0; x < 200; x++){
            recruta1.atirarFlecha(new Dwarf());
        }
        ArrayList<Elfo> resultado = test.buscarPorStatus(Status.MORTO);
        assertEquals(recruta1 , resultado.get(0));
    }

    @Test
    public void buscarPorStatusMortoNenhumMorto(){
        ExercitoDeElfo test = new ExercitoDeElfo();
        Elfo recruta1 = new ElfoNoturno("Malfurion", 200);
        test.exercitoDeElfo(recruta1);
        ArrayList<Elfo> resultado = test.buscarPorStatus(Status.MORTO);
        assertTrue(resultado.isEmpty());
    }

    @Test
    public void buscarPorStatusVivoNumaListaVazia(){
        ExercitoDeElfo test = new ExercitoDeElfo();
        ArrayList<Elfo> resultado = test.buscarPorStatus(Status.VIVO);
        assertTrue(resultado.isEmpty());
    }
}
