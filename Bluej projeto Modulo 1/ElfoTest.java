import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class ElfoTest
{
    @Test
    public void elfoNasceComNome(){
        //Arrange
        String nomeEsperado = "Bruce Wayne";
        //Act
        Elfo brucewayne = new Elfo(nomeEsperado);
        //Assert
        assertEquals(nomeEsperado,brucewayne.getNome());
    }
    
    @Test
    public void elfoNasceComArco(){
        //Arrange
        
        //Act
        Elfo elfoDoTest = new Elfo("Elrond");
        //Assert
        assertEquals("Arco",elfoDoTest.getArco().getDescricao());
        assertEquals(1,elfoDoTest.getArco().getQuantidade());
    }
    
    @Test
    public void elfoAtiraUmaFlecha(){
        //Arrange
        
        //Act
        Elfo elfoDoTestFlecha = new Elfo("Frechina");
        //Assert
        elfoDoTestFlecha.atirarFlecha();
        assertEquals(41,elfoDoTestFlecha.getFlechas().getQuantidade());
    }
    
    @Test
    public void elfoAtiraVariasFlechas(){
        Elfo elfoDoTestFlecha = new Elfo("Frechina");
        int Test = 0;
        while(Test < 10){
            elfoDoTestFlecha.atirarFlecha();
            Test++;
        }
        assertEquals(32,elfoDoTestFlecha.getFlechas().getQuantidade());
    }
    
    @Test
    public void elfoNaoAtiraFlecha(){
        Elfo elfoDoTestFlecha = new Elfo("Frechina");
        assertEquals(42,elfoDoTestFlecha.getFlechas().getQuantidade());
    }
}