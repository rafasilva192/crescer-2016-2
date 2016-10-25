import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.*;

public class HobbitContadorTest {

    @Test
    public void calcularDiferencaTresParesNormais() {
        ArrayList<ArrayList<Integer>> arrayDePares = new ArrayList<>();
        arrayDePares.add(new ArrayList<>(Arrays.asList(15, 18)));
        arrayDePares.add(new ArrayList<>(Arrays.asList(4, 5)));
        arrayDePares.add(new ArrayList<>(Arrays.asList(12, 60)));

        HobbitContador contador = new HobbitContador();
        assertEquals(840, contador.calcularDiferenca(arrayDePares));
    }

    @Test
    public void calcularDiferencaComZeroEUm() {
        ArrayList<ArrayList<Integer>> arrayDePares = new ArrayList<>();
        arrayDePares.add(new ArrayList<>(Arrays.asList(13, 91)));
        arrayDePares.add(new ArrayList<>(Arrays.asList(0, 0)));
        arrayDePares.add(new ArrayList<>(Arrays.asList(1, 1)));

        HobbitContador contador = new HobbitContador();
        assertEquals(1092, contador.calcularDiferenca(arrayDePares));
    }

    @Test
    public void calcularDiferencaSemDiferenca() {
        ArrayList<ArrayList<Integer>> arrayDePares = new ArrayList<>();
        arrayDePares.add(new ArrayList<>(Arrays.asList(19, 60)));
        arrayDePares.add(new ArrayList<>(Arrays.asList(15, 7)));
        arrayDePares.add(new ArrayList<>(Arrays.asList(4, 5)));

        HobbitContador contador = new HobbitContador();
        assertEquals(0, contador.calcularDiferenca(arrayDePares));
    }

    @Test
    public void calcularDiferencaComParesVazio() {
        ArrayList<ArrayList<Integer>> arrayDePares = new ArrayList<>();
        HobbitContador contador = new HobbitContador();
        assertEquals(0, contador.calcularDiferenca(arrayDePares));
    }

}
