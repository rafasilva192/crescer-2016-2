import java.util.*;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class HobbitContadorTest
{
    @Test
    public void calculoDaDiferenca(){
        HobbitContador contador = new HobbitContador();
        contador.adicionarPar(15, 18);
        contador.adicionarPar(4,5);
        contador.adicionarPar(12,60);
        assertEquals(840, contador.calcularDiferenca());
    }

    @Test
    public void multiplicaoDoisNumeros(){
        HobbitContador contador = new HobbitContador();
        contador.adicionarPar(4,5);
        assertEquals(20, contador.produtoDosPares());
    }

    @Test
    public void multiplicaoQuatroNumeros(){
        HobbitContador contador = new HobbitContador();
        contador.adicionarPar(4,5);
        contador.adicionarPar(20,10);
        assertEquals(220, contador.produtoDosPares());
    }

    @Test
    public void calculoDaDiferencaComDoisPares(){
        HobbitContador contador = new HobbitContador();
        contador.adicionarPar(15, 18);
        contador.adicionarPar(4,5);
        assertEquals(180, contador.calcularDiferenca());
    }

    @Test
    public void calculoDaDiferencaComOitoPares(){
        HobbitContador contador = new HobbitContador();
        contador.adicionarPar(15, 18);
        contador.adicionarPar(4,5);
        contador.adicionarPar(12,60);
        contador.adicionarPar(15, 18);
        contador.adicionarPar(4,5);
        contador.adicionarPar(12,60);
        contador.adicionarPar(15, 18);
        contador.adicionarPar(4,5);
        assertEquals(1860, contador.calcularDiferenca());
    }
    
    @Test
    public void calculoDaDiferencaComUmPar(){
        HobbitContador contador = new HobbitContador();
        contador.adicionarPar(4,5);
        assertEquals(0, contador.calcularDiferenca());
    }
}
