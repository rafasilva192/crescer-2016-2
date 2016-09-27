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
        Item arco = new Item("Arco", 1);
        //Act
        Elfo elfoDoTest = new Elfo("Elrond");
        //Assert
        assertEquals(arco.getDescricao(),elfoDoTest.getArco().getDescricao());
        assertEquals(arco.getQuantidade(),elfoDoTest.getArco().getQuantidade());
    }
}
