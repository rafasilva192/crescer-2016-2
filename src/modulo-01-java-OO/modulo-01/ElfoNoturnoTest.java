import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ElfoNoturnoTest {

    @After
    // executa após cada cenário de testes.
    public void tearDown() {
        System.gc();
    }
    
    @Test
    public void quandoatirarFlechaGanha3DeExperiencia() {
        ElfoNoturno elfoNoturno = new ElfoNoturno("Night Legolas");
        elfoNoturno.atirarFlecha(new Dwarf("Joe Doein", new DataTerceiraEra(1,1,1)));
        assertEquals(3, elfoNoturno.getExperiencia());
    }

    @Test
    public void quandoatirarDuasFlechasGanha6DeExperiencia() {
        ElfoNoturno elfoNoturno = new ElfoNoturno("Night Legolas");
        elfoNoturno.atirarFlecha(new Dwarf("Joe Doein", new DataTerceiraEra(1,1,1)));
        elfoNoturno.atirarFlecha(new Dwarf("Joe Doein", new DataTerceiraEra(1,1,1)));
        assertEquals(6, elfoNoturno.getExperiencia());
    }

    @Test
    public void quandoatirarTresFlechasGanha9DeExperiencia() {
        ElfoNoturno elfoNoturno = new ElfoNoturno("Night Legolas");
        elfoNoturno.atirarFlecha(new Dwarf("Joe Doein", new DataTerceiraEra(1,1,1)));
        elfoNoturno.atirarFlecha(new Dwarf("Joe Doein", new DataTerceiraEra(1,1,1)));
        elfoNoturno.atirarFlecha(new Dwarf("Joe Doein", new DataTerceiraEra(1,1,1)));
        assertEquals(9, elfoNoturno.getExperiencia());
    }

    @Test
    public void quandoatirarFlechaPerde5DeVida() {
        ElfoNoturno elfoNoturno = new ElfoNoturno("Night Legolas");
        elfoNoturno.atirarFlecha(new Dwarf("Joe Doein", new DataTerceiraEra(1,1,1)));
        assertEquals(95, elfoNoturno.getVida(), 0.); 
    }

    @Test
    public void quandoAtirarDuasFlechasPerde9ponto75DeVida() {
        ElfoNoturno elfoNoturno = new ElfoNoturno("Night Legolas");
        elfoNoturno.atirarFlecha(new Dwarf("Joe Doein", new DataTerceiraEra(1,1,1)));
        elfoNoturno.atirarFlecha(new Dwarf("Joe Doein", new DataTerceiraEra(1,1,1)));
        assertEquals(90.25, elfoNoturno.getVida(), 0.); 
    }

    @Test
    public void quandoAtirarTresFlechasPerde14pontos() {
        ElfoNoturno elfoNoturno = new ElfoNoturno("Night Legolas");
        elfoNoturno.atirarFlecha(new Dwarf("Joe Doein", new DataTerceiraEra(1,1,1)));
        elfoNoturno.atirarFlecha(new Dwarf("Joe Doein", new DataTerceiraEra(1,1,1)));
        elfoNoturno.atirarFlecha(new Dwarf("Joe Doein", new DataTerceiraEra(1,1,1)));
        assertEquals(85.7375, elfoNoturno.getVida(), 0.); 
    }

    @Test
    public void quandoAtirarMuitasFlechasStatusMorto() {
        ElfoNoturno elfoSuiçida = new ElfoNoturno("Night Legolas", 90);

        for (int i = 0; i < 90; i++)
            elfoSuiçida.atirarFlecha(new Dwarf("Joe Doein", new DataTerceiraEra(1,1,1)));

        assertEquals(Status.MORTO, elfoSuiçida.getStatus());
    }

    @Test
    public void elfoNoturnoNaoAtiraSeEstaMorto() {
        ElfoNoturno elfoSuiçida = new ElfoNoturno("Harakiri", 91);
        for (int i = 0; i < 91; i++)
            elfoSuiçida.atirarFlecha(new Dwarf("Joe Doein", new DataTerceiraEra(1,1,1)));

        assertEquals(270, elfoSuiçida.getExperiencia());
    }

    @Test
    public void elfoNoturnoSemFlechasNaoPerdeVida() {
        ElfoNoturno elfoSuiçida = new ElfoNoturno("Harakiri", 1);
        elfoSuiçida.atirarFlecha(new Dwarf("Joe Doein", new DataTerceiraEra(1,1,1)));
        elfoSuiçida.atirarFlecha(new Dwarf("Joe Doein", new DataTerceiraEra(1,1,1)));
        assertEquals(95, elfoSuiçida.getVida(), 0.);
    }
}

