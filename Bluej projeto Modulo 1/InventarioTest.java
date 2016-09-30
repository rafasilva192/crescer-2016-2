
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

    @Test
    public void inventarioRemovendoUmaUnidade(){
        Inventario inventario = new Inventario();
        inventario.adicionarItem("Arco", 5);
        inventario.removendoUnidades("Arco", 1);
        assertEquals(4,inventario.getItens().get(0).getQuantidade());
    }

    @Test
    public void inventarioRemovendoCincoUnidades(){
        Inventario inventario = new Inventario();
        inventario.adicionarItem("Arco", 5);
        inventario.removendoUnidades("Arco", 5);
        assertEquals(0,inventario.getItens().get(0).getQuantidade());
    }

    @Test
    public void inventarioRemovendo180Unidades(){
        Inventario inventario = new Inventario();
        inventario.adicionarItem("Arco", 200);
        inventario.removendoUnidades("Arco", 180);
        assertEquals(20,inventario.getItens().get(0).getQuantidade());
    }

    @Test
    public void inventarioDescricaoDosItensEmLista(){
        Inventario inventario = new Inventario();
        inventario.adicionarItem("Espada", 1);
        inventario.adicionarItem("Arco", 2);
        inventario.adicionarItem("Barco", 1);
        inventario.adicionarItem("Semente", 65);
        assertEquals("Espada, Arco, Barco, Semente", inventario.getDescricoesItens());   
    }

    @Test
    public void inventarioDescricaoDosItensEmListaEnorme(){
        Inventario inventario = new Inventario();
        inventario.adicionarItem("Espada", 1);
        inventario.adicionarItem("Arco", 2);
        inventario.adicionarItem("Barco", 1);
        inventario.adicionarItem("Semente", 65);
        inventario.adicionarItem("Espada", 1);
        inventario.adicionarItem("Arco", 2);
        inventario.adicionarItem("Barco", 1);
        inventario.adicionarItem("Semente", 65);
        inventario.adicionarItem("Espada", 1);
        inventario.adicionarItem("Arco", 2);
        inventario.adicionarItem("Barco", 1);
        inventario.adicionarItem("Semente", 65);
        inventario.adicionarItem("Espada", 1);
        inventario.adicionarItem("Arco", 2);
        inventario.adicionarItem("Barco", 1);
        inventario.adicionarItem("Semente", 65);             
        assertEquals("Espada, Arco, Barco, Semente, Espada, Arco, Barco, Semente, Espada, Arco, Barco, Semente, Espada, Arco, Barco, Semente", inventario.getDescricoesItens());   
    }
    
    @Test
    public void inventarioItemMaisPopular(){
        Inventario inventario = new Inventario();
        inventario.adicionarItem("Espada", 1);
        assertEquals("Espada", inventario.itemMaisPopular().getDescricao());
        assertEquals(1, inventario.itemMaisPopular().getQuantidade());
    }
    
    @Test
    public void inventarioItemMaisPopularEntre5Itens(){
        Inventario inventario = new Inventario();
        inventario.adicionarItem("Espada", 1);
        inventario.adicionarItem("Arco", 5);
        inventario.adicionarItem("Escudo", 13);
        inventario.adicionarItem("Torre", 20);
        inventario.adicionarItem("404 Item de Test", 1);
        assertEquals("Torre", inventario.itemMaisPopular().getDescricao());
        assertEquals(20, inventario.itemMaisPopular().getQuantidade());
    }
    
    @Test
    public void inventarioItemMaisPopularEntreItensRepetidos(){
        Inventario inventario = new Inventario();
        inventario.adicionarItem("Espada", 1);
        inventario.adicionarItem("Arco", 5);
        inventario.adicionarItem("Espada", 13);
        inventario.adicionarItem("Arco", 2);
        inventario.adicionarItem("404 Item de Test", 1);
        assertEquals("Espada", inventario.itemMaisPopular().getDescricao());
        assertEquals(13, inventario.itemMaisPopular().getQuantidade());
    }
}