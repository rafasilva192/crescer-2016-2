import java.util.ArrayList;
import java.util.HashMap;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class ExercitoEspecialDeElfoTest
{
    @After
    public void tearDown(){
        System.gc();
    }

    @Test
    public void elfoNoturnoEntraNoExercito(){
        ExercitoEspecialDeElfo test = new ExercitoEspecialDeElfo();
        Elfo recruta1 = new ElfoNoturno("Malfurion", 1);
        test.exercitoDeElfo(recruta1);
        assertEquals(recruta1, test.getContigente()[0]);
    }

    @Test
    public void elfoNoturnoEElfoVerdeEntramNoExercito(){
        ExercitoEspecialDeElfo test = new ExercitoEspecialDeElfo();
        Elfo recruta1 = new ElfoNoturno("Malfurion", 1);
        Elfo recruta2 = new ElfoVerde("Valeera", 1);
        test.exercitoDeElfo(recruta1);
        test.exercitoDeElfo(recruta2);
        Elfo[] elfos = test.getContigente();
        assertTrue(contem(elfos, recruta1));
        assertTrue(contem(elfos, recruta2));
    }
    
    private boolean contem(Elfo[] elfos, Elfo elfo){
        for(int i = 0; i < elfos.length ; i++){
            if(elfos[i].equals(elfo)){
                return true;
            }
        }
        return false;
    }
}
