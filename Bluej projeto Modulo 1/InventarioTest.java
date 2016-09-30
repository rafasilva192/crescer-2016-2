
import java.util.ArrayList;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class InventarioTest
{
    @Test
    public void inventarioCriandoUmItem(){
        Inventario inventario = new Inventario();
        inventario.adicionarItem("Arco", 1);
        assertEquals("Arco",inventario.getItens().get(0).getDescricao());        
        assertEquals(1,inventario.getItens().get(0).getQuantidade());
    }

    @Test
    public void inventarioDeletandoUmItem(){
        Inventario inventario = new Inventario();
        inventario.adicionarItem("Arco", 1);
        inventario.removerItem("Arco");
        assertTrue(inventario.getItens().isEmpty());
    }
    
}
