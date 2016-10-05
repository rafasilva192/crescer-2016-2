
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ElfoNoturnoTest
{
    @Test
    public void elfoNoturnoPerdeVida(){
        ElfoNoturno elfo = new ElfoNoturno("Malfurion", 20);
        elfo.atirarFlecha();
        assertEquals(95,elfo.getVida(),.0);
        assertEquals(19, elfo.getFlechas().getQuantidade());
        assertTrue(elfo.getStatus().equals(Status.VIVO));
        assertEquals(3,elfo.getExperiencia());
    }

    @Test
    public void elfoNoturnoAtira10Flechas(){
        ElfoNoturno elfo = new ElfoNoturno("Malfurion", 40);
        for(int i = 0; i < 10; i++){
            elfo.atirarFlecha();
        }
        assertEquals(30, elfo.getFlechas().getQuantidade());
        assertTrue(elfo.getStatus().equals(Status.VIVO));
        assertEquals(30,elfo.getExperiencia());
    }

    @Test
    public void elfoNoturnoMorreAtirandoFlechas(){
        ElfoNoturno elfo = new ElfoNoturno("Malfurion", 100);
        for(int i = 0; i < 100; i++){
            elfo.atirarFlecha();
        }
        assertEquals(10, elfo.getFlechas().getQuantidade());
        assertTrue(elfo.getStatus().equals(Status.MORTO));
        assertEquals(270,elfo.getExperiencia());
    }

    @Test
    public void elfoNoturnoAtiraEmDwarf(){
        ElfoNoturno elfo = new ElfoNoturno("Malfurion", 40);
        Dwarf dwarf = new Dwarf();
        elfo.atirarFlecha(dwarf);
        assertEquals(39, elfo.getFlechas().getQuantidade());
        assertTrue(elfo.getStatus().equals(Status.VIVO));
        assertEquals(3,elfo.getExperiencia());
    }

    @Test
    public void elfoNoturnoEntraNoExercito(){
        ElfoNoturno elfo = new ElfoNoturno("Malfurion", 40);
        elfo.exercitoDeElfo(elfo);
        assertEquals("Malfurion", elfo.buscarNoExercito("Malfurion").getNome());
    }

    @Test
    public void tresElfosNoturnosEntramNoExercito(){
        ElfoNoturno elfo = new ElfoNoturno("Malfurion", 40);
        ElfoNoturno elfo1 = new ElfoNoturno("Illidan", 40);
        ElfoNoturno elfo2 = new ElfoNoturno("Tyrande", 40);
        elfo.exercitoDeElfo(elfo);
        elfo1.exercitoDeElfo(elfo1);
        elfo2.exercitoDeElfo(elfo2);
        assertEquals("Malfurion", elfo.buscarNoExercito("Malfurion").getNome());
        assertEquals("Illidan", elfo1.buscarNoExercito("Illidan").getNome());
        assertEquals("Tyrande", elfo2.buscarNoExercito("Tyrande").getNome());
    }

    @Test
    public void buscarNoExercitoPorStatus(){
        ElfoNoturno elfo = new ElfoNoturno("Malfurion", 40);
        ElfoNoturno elfo1 = new ElfoNoturno("Illidan", 40);
        ElfoNoturno elfo2 = new ElfoNoturno("Tyrande", 40);
        elfo.exercitoDeElfo(elfo);
        elfo1.exercitoDeElfo(elfo1);
        elfo2.exercitoDeElfo(elfo2);
        
        for(int i = 0; i < elfo.buscarPorStatus(Status.VIVO).size(); i++){
            assertEquals(Status.VIVO, elfo.buscarPorStatus(Status.VIVO).get(i).getStatus());
        }
    }      

}
