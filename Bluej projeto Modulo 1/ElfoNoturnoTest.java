
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

}
