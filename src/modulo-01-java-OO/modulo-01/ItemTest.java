import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ItemTest {
    
    @Test
    public void aumentar1000UnidadesItem() {
        Item elderScroll = new Item("Elder Scroll", 7);
        elderScroll.aumentarUnidades(1000);
        assertEquals(1007, elderScroll.getQuantidade());
    }
    
    @Test
    public void aumentar0UnidadesItem() {
        Item elderScroll = new Item("Elder Scroll", 7);
        elderScroll.aumentarUnidades(0);
        assertEquals(7, elderScroll.getQuantidade());
    }
    
    @Test
    public void aumentarUnidadeNegativaItem() {
        Item elderScroll = new Item("Elder Scroll", 7);
        elderScroll.aumentarUnidades(-1);
        assertEquals(6, elderScroll.getQuantidade());
    }
    
    @Test
    public void aumentarProporcionalQuantidade3() {
        Item item = new Item("Chapéu", 3);
        item.aumentarProporcionalQuantidade();
        assertEquals(6003, item.getQuantidade());
    }
    
    @Test
    public void aumentarProporcionalQuantidade1() {
        Item item = new Item("Elder Scroll", 1);
        item.aumentarProporcionalQuantidade();
        assertEquals(1001, item.getQuantidade());
    }
    
    @Test
    public void aumentarProporcionalQuantidade0() {
        Item item = new Item("Elder Scroll", 0);
        item.aumentarProporcionalQuantidade();
        assertEquals(0, item.getQuantidade());
    }
    
    @Test
    public void aumentarProporcionalQuantidade20() {
        Item item = new Item("Semente dos Deuses", 20);
        item.aumentarProporcionalQuantidade();
        assertEquals(210020, item.getQuantidade());
    }
    
    @Test
    public void igualdadeDeItens() {
        assertEquals(new Item("Espada Z", 1), new Item("Espada Z", 1));
    }
}
