
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DataTerceiraEraTest
{

    @Test
    public void criacaoDeUmaData(){
        DataTerceiraEra test = new DataTerceiraEra(10,10,3000);
        assertEquals(10, test.getDia());
        assertEquals(10, test.getMes());
        assertEquals(3000, test.getAno());

    }
    @Test
    public void dataEhBissextoTrue(){
        DataTerceiraEra test = new DataTerceiraEra(10,10,16);
        assertTrue(test.ehBissexto());
    }
    @Test
    public void dataEhBissextoTrueMediano(){
        DataTerceiraEra test = new DataTerceiraEra(10,10,400);
        assertTrue(test.ehBissexto());
    }
    @Test
    public void dataEhBissextoTrueExtremo(){
        DataTerceiraEra test = new DataTerceiraEra(10,10,40000);
        assertTrue(test.ehBissexto());
    }
    @Test
    public void dataEhBissextoFalse(){
        DataTerceiraEra test = new DataTerceiraEra(10,10,13);
        assertFalse(test.ehBissexto());
    }
    @Test
    public void dataEhBissextoFalseExtremo(){
        DataTerceiraEra test = new DataTerceiraEra(10,10,4001);
        assertFalse(test.ehBissexto());
    }
}
