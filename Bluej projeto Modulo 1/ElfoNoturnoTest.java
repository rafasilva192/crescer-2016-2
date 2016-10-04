
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
        assertEquals(50,elfo.getVida(),.0);
        assertEquals(30, elfo.getFlechas().getQuantidade());
        assertTrue(elfo.getStatus().equals(Status.VIVO));
        assertEquals(30,elfo.getExperiencia());
    }

    @Test
    public void elfoNoturnoMorreAtirandoFlechas(){
        ElfoNoturno elfo = new ElfoNoturno("Malfurion", 40);
        for(int i = 0; i < 20; i++){
            elfo.atirarFlecha();
        }
        assertEquals(0,elfo.getVida(),.0);
        assertEquals(20, elfo.getFlechas().getQuantidade());
        assertTrue(elfo.getStatus().equals(Status.MORTO));
        assertEquals(60,elfo.getExperiencia());
    }

    @Test
    public void elfoNoturnoAtiraEmDwarf(){
        ElfoNoturno elfo = new ElfoNoturno("Malfurion", 40);
        Dwarf dwarf = new Dwarf();
        elfo.atirarFlechaNoDwarf(dwarf);
        assertEquals(95,elfo.getVida(),.0);
        assertEquals(100,dwarf.getVida(),.0);
        assertEquals(39, elfo.getFlechas().getQuantidade());
        assertTrue(elfo.getStatus().equals(Status.VIVO));
        assertEquals(3,elfo.getExperiencia());
    }
}
