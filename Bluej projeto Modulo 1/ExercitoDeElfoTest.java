

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class ExercitoDeElfoTest
{
    
    @Test
    public void elfoNoturnoEntraNoExercito(){
        ExercitoDeElfo test = new ExercitoDeElfo();
        test.exercitoDeElfo(new ElfoNoturno("Malfurion", 1));
        assertEquals("Malfurion", test.buscarNoExercito("Malfurion").getNome());
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
}
