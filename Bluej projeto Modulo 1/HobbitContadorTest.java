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
        contador.adicionarPar(4,5);
        int diferenca = contador.calcularDiferenca();
        assertEquals(20, diferenca);
    }
}
