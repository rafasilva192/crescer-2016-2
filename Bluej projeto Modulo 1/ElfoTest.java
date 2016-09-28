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
        assertEquals(1,elfoDoTestFlecha.getExperiencia());
    }
    
    @Test
    public void elfoAtiraVariasFlechas(){
        Elfo elfoDoTestFlecha = new Elfo("Frechina");
        int Test = 0;
        while(Test < 50){
            elfoDoTestFlecha.atirarFlecha();
            Test++;
        }
        assertEquals(0,elfoDoTestFlecha.getFlechas().getQuantidade());
        assertEquals(42,elfoDoTestFlecha.getExperiencia());
    }
    
    @Test
    public void elfoNasceComFlecha(){
        Elfo elfoDoTestFlecha = new Elfo("Frechina");
        assertEquals("Flechas",elfoDoTestFlecha.getFlechas().getDescricao());
        assertEquals(42,elfoDoTestFlecha.getFlechas().getQuantidade());
    }
    
    @Test
    public void elfoCacaDwarfs(){
        Elfo elfoDoTestDwarf = new Elfo("Frechina");
        elfoDoTestDwarf.atirarFlechaNoDwarf();
        assertEquals(100,elfoDoTestDwarf.getVida().getVida());
        assertEquals(41,elfoDoTestDwarf.getFlechas().getQuantidade());
        assertEquals(1,elfoDoTestDwarf.getExperiencia());
    }
   
}
