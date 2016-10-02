import java.util.*;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class HobbitContadorTest
{
    @Test
    public void multiplicaoDoisNumeros(){
        HobbitContador contador = new HobbitContador();
        contador.adicionarPar(15, 18);
        contador.adicionarPar(4,5);
        contador.adicionarPar(12,60);
        assertEquals(840, contador.calcularDiferenca());
    }
}
