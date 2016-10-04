
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ElfoVerdeTest
{
    @Test
    public void elfoVerdeAtiraUmaFlechaEGanha2DeEXP(){
        ElfoVerde elfo = new ElfoVerde("Test", 42);
        elfo.atirarFlecha();
        assertEquals(41, elfo.getFlechas().getQuantidade());
        assertEquals(2, elfo.getExperiencia());
    }

    @Test
    public void elfoVerdeAtira50FlechasEGanhaEXP(){
        ElfoVerde elfo = new ElfoVerde("Test", 42);
        for(int i = 0; i < 50; i++){
            elfo.atirarFlecha();
        }
        assertEquals(0, elfo.getFlechas().getQuantidade());
        assertEquals(84, elfo.getExperiencia());
    }
    
    @Test
    public void elfoVerdeNasceComVida(){
        ElfoVerde elfo = new ElfoVerde("Test", 42);
        assertEquals(100, elfo.getVida(),.0);
        assertEquals(Status.VIVO, elfo.getStatus());
    }
}
