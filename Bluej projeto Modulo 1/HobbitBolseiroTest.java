
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class HobbitBolseiroTest
{
    @Test
    public void hobbitBolseiroMultiploDeTresAte10(){
        HobbitBolseiro hobbit = new HobbitBolseiro();
        assertEquals(9,hobbit.obterMaiorMultiploDeTresAte(10));
    }

    @Test
    public void hobbitBolseiroMultiploDeTresAte500(){
        HobbitBolseiro hobbit = new HobbitBolseiro();
        assertEquals(498,hobbit.obterMaiorMultiploDeTresAte(500));
    }

    @Test
    public void hobbitBolseiroMultiploDeTresAte964594534(){
        HobbitBolseiro hobbit = new HobbitBolseiro();
        assertEquals(964594533,hobbit.obterMaiorMultiploDeTresAte(964594534));
    }

    @Test
    public void hobbitBolseiroListaDeMultiplosDeTresAte100(){
        HobbitBolseiro hobbit = new HobbitBolseiro();
        for(int i = 0; i < hobbit.obterListaMultiploDeTresAte(100).size(); i ++)
        {
            int numeroParaTeste = (i+1)*3;
            assertTrue(numeroParaTeste == hobbit.obterListaMultiploDeTresAte(100).get(i));
        }
    }

    @Test
    public void hobbitBolseiroListaDeMultiplosDeTresAte10(){
        HobbitBolseiro hobbit = new HobbitBolseiro();
        assertEquals(3,hobbit.obterListaMultiploDeTresAte(10).size());
    }
    
    @Test
    public void hobbitBolseiroListaDeMultiplosDeTresAte645(){
        HobbitBolseiro hobbit = new HobbitBolseiro();
        for(int i = 0; i < hobbit.obterListaMultiploDeTresAte(645).size(); i ++)
        {
            int numeroParaTeste = (i+1)*3;
            assertTrue(numeroParaTeste == hobbit.obterListaMultiploDeTresAte(645).get(i));
        }
    }
}
