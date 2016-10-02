
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
        inventario.adicionarItem(new Item("Arco", 1));
        assertEquals("Arco",inventario.getItens().get(0).getDescricao());        
        assertEquals(1,inventario.getItens().get(0).getQuantidade());
    }

    @Test
    public void inventarioDeletandoUmItem(){
        Inventario inventario = new Inventario();
        Item item = new Item("Arco", 1);
        inventario.adicionarItem(item);
        inventario.removerItem(item);
        assertTrue(inventario.getItens().isEmpty());
    }

    @Test
    public void inventarioRemovendoUmaUnidade(){
        Inventario inventario = new Inventario();
        inventario.adicionarItem(new Item("Arco", 5));
        inventario.removendoUnidades("Arco", 1);
        assertEquals(4,inventario.getItens().get(0).getQuantidade());
    }

    @Test
    public void inventarioRemovendoCincoUnidades(){
        Inventario inventario = new Inventario();
        inventario.adicionarItem(new Item("Arco", 5));
        inventario.removendoUnidades("Arco", 5);
        assertEquals(0,inventario.getItens().get(0).getQuantidade());
    }

    @Test
    public void inventarioRemovendo180Unidades(){
        Inventario inventario = new Inventario();
        inventario.adicionarItem(new Item("Arco", 200));
        inventario.removendoUnidades("Arco", 180);
        assertEquals(20,inventario.getItens().get(0).getQuantidade());
    }

    @Test
    public void inventarioDescricaoDosItensEmLista(){
        Inventario inventario = new Inventario();
        inventario.adicionarItem(new Item("Espada", 1));
        inventario.adicionarItem(new Item("Arco", 2));
        inventario.adicionarItem(new Item("Barco", 1));
        inventario.adicionarItem(new Item("Semente", 1));
        assertEquals("Espada,Arco,Barco,Semente", inventario.getDescricoesItens());   
    }

    @Test
    public void inventarioDescricaoDosItensEmListaEnorme(){
        Inventario inventario = new Inventario();
        inventario.adicionarItem(new Item("Espada", 1));
        inventario.adicionarItem(new Item("Arco", 2));
        inventario.adicionarItem(new Item("Barco", 1));
        inventario.adicionarItem(new Item("Semente", 1));
        inventario.adicionarItem(new Item("Espada", 1));
        inventario.adicionarItem(new Item("Arco", 2));
        inventario.adicionarItem(new Item("Barco", 1));
        inventario.adicionarItem(new Item("Semente", 1));
        inventario.adicionarItem(new Item("Espada", 1));
        inventario.adicionarItem(new Item("Arco", 2));
        inventario.adicionarItem(new Item("Barco", 1));
        inventario.adicionarItem(new Item("Semente", 1));
        inventario.adicionarItem(new Item("Espada", 1));
        inventario.adicionarItem(new Item("Arco", 2));
        inventario.adicionarItem(new Item("Barco", 1));
        inventario.adicionarItem(new Item("Semente", 1));     
        assertEquals("Espada,Arco,Barco,Semente,Espada,Arco,Barco,Semente,Espada,Arco,Barco,Semente,Espada,Arco,Barco,Semente", inventario.getDescricoesItens());   
    }

    @Test
    public void inventarioItemMaisPopular(){
        Inventario inventario = new Inventario();
        inventario.adicionarItem(new Item("Espada", 1));
        assertEquals("Espada", inventario.itemMaisPopular().getDescricao());
        assertEquals(1, inventario.itemMaisPopular().getQuantidade());
    }

    @Test
    public void inventarioItemMaisPopularComInventorioVazio(){
        Inventario inventario = new Inventario();
        assertNull(inventario.itemMaisPopular());
    }

    @Test
    public void inventarioItemMaisPopularEntre5Itens(){
        Inventario inventario = new Inventario();
        inventario.adicionarItem(new Item("Espada", 1));
        inventario.adicionarItem(new Item("Arco", 5));
        inventario.adicionarItem(new Item("Escudo", 13));
        inventario.adicionarItem(new Item("Torre", 20));
        inventario.adicionarItem(new Item("Espada", 1));
        assertEquals("Torre", inventario.itemMaisPopular().getDescricao());
        assertEquals(20, inventario.itemMaisPopular().getQuantidade());
    }

    @Test
    public void inventarioItemMaisPopularEntreItensRepetidos(){
        Inventario inventario = new Inventario();
        inventario.adicionarItem(new Item("Espada", 1));
        inventario.adicionarItem(new Item("Arco", 5));
        inventario.adicionarItem(new Item("Escudo", 12));
        inventario.adicionarItem(new Item("Torre", 5));
        inventario.adicionarItem(new Item("Espada", 13));
        assertEquals("Espada", inventario.itemMaisPopular().getDescricao());
        assertEquals(13, inventario.itemMaisPopular().getQuantidade());
    }

    @Test
    public void inventarioOrganizarModoAscendente(){
        Inventario inventario = new Inventario();
        Item Espada = new Item("Espada", 3);
        Item Escudo = new Item("Escudo", 5);
        Item Arco = new Item("Arco", 8);
        Item Torre = new Item("Torre", 9);
        inventario.adicionarItem(Escudo);
        inventario.adicionarItem(Torre);
        inventario.adicionarItem(Arco);
        inventario.adicionarItem(Espada);
        inventario.ordernarItens();
        assertEquals(Espada,inventario.getItens().get(0));
        assertEquals(Escudo,inventario.getItens().get(1));
        assertEquals(Arco,inventario.getItens().get(2));
        assertEquals(Torre,inventario.getItens().get(3));
    }
    
    @Test
    public void inventarioOrganizarListaVaziaModoAscendente(){
        Inventario inventario = new Inventario();
        inventario.ordernarItens();
        assertTrue(inventario.getItens().isEmpty());
    }
    
    @Test
    public void inventarioTipoOrdenacaoOrganizarModoAscendente(){
        Inventario inventario = new Inventario();
        Item Espada = new Item("Espada", 3);
        Item Escudo = new Item("Escudo", 5);
        Item Arco = new Item("Arco", 8);
        Item Torre = new Item("Torre", 9);
        inventario.adicionarItem(Escudo);
        inventario.adicionarItem(Torre);
        inventario.adicionarItem(Arco);
        inventario.adicionarItem(Espada);
        inventario.tipoOrdenacao("ASCENDENTE");
        assertEquals(Espada,inventario.getItens().get(0));
        assertEquals(Escudo,inventario.getItens().get(1));
        assertEquals(Arco,inventario.getItens().get(2));
        assertEquals(Torre,inventario.getItens().get(3));
    }
    
    @Test
    public void inventarioTipoOrdenacaoOrganizarModoDescendente(){
        Inventario inventario = new Inventario();
        Item Espada = new Item("Espada", 3);
        Item Escudo = new Item("Escudo", 5);
        Item Arco = new Item("Arco", 8);
        Item Torre = new Item("Torre", 9);
        inventario.adicionarItem(Escudo);
        inventario.adicionarItem(Torre);
        inventario.adicionarItem(Arco);
        inventario.adicionarItem(Espada);
        inventario.tipoOrdenacao("DESCENDENTE");
        assertEquals(Torre,inventario.getItens().get(0));
        assertEquals(Arco,inventario.getItens().get(1));
        assertEquals(Escudo,inventario.getItens().get(2));
        assertEquals(Espada,inventario.getItens().get(3));
    }
    
    @Test
    public void inventarioVazioTipoOrdenacaoOrganizarModoDescendente(){
        Inventario inventario = new Inventario();
        inventario.tipoOrdenacao("DESCENDENTE");
        assertTrue(inventario.getItens().isEmpty());
    }
    
    @Test
    public void inventarioVazioTipoOrdenacaoOrganizarModoAscendente(){
        Inventario inventario = new Inventario();
        inventario.tipoOrdenacao("ASCENDENTE");
        assertTrue(inventario.getItens().isEmpty());
    }
}