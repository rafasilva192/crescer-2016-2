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
        Elfo brucewayne = new Elfo(nomeEsperado, 0);
        //Assert
        assertEquals(nomeEsperado,brucewayne.getNome());
    }

    @Test
    public void elfoNasceComArco(){

        //Act
        Elfo elfoDoTest = new Elfo("Elrond", 42);
        Inventario inventarioElfo = new Inventario();
        //Assert
        assertEquals("Arco",inventarioElfo.getItens().get(0).getDescricao());
        assertEquals(1,inventarioElfo.getItens().get(1).getQuantidade());
    }

    @Test
    public void elfoAtiraUmaFlecha(){
        //Arrange

        //Act
        Elfo elfoDoTest = new Elfo("Elrond", 42);
        Inventario inventarioElfo = new Inventario();
        //Assert
        elfoDoTest.atirarFlecha();
        assertEquals(41,inventarioElfo.getItens().get(1).getQuantidade());
        assertEquals(1,elfoDoTest.getExperiencia());
    }

    @Test
    public void elfoAtiraVariasFlechas(){
        Elfo elfoDoTest = new Elfo("Elrond", 42);
        Inventario inventarioElfo = new Inventario();
        int Test = 0;
        while(Test < 50){
            elfoDoTest.atirarFlecha();
            Test++;
        }
        assertEquals(0,inventarioElfo.getItens().get(1).getQuantidade());
        assertEquals(42,elfoDoTest.getExperiencia());
    }

    @Test
    public void elfoNasceComFlecha(){
        Elfo elfoDoTest = new Elfo("Elrond", 42);
        Inventario inventarioElfo = new Inventario();
        assertEquals("Flechas",inventarioElfo.getItens().get(1).getDescricao());
        assertEquals(42,inventarioElfo.getItens().get(1).getQuantidade());
    }

    @Test
    public void elfoCacaDwarfs(){
        Elfo elfoDoTest = new Elfo("Elrond", 42);
        Dwarf dwarf = new Dwarf();
        elfoDoTest.atirarFlechaNoDwarf(dwarf);
        assertEquals(100,dwarf.getVida());
        assertEquals(1,elfoDoTest.getExperiencia());
    }

    @Test
    public void elfoCaca2Dwarfs(){
        Elfo elfoDoTest = new Elfo("Elrond", 42);
        Dwarf dwarf = new Dwarf();
        Dwarf muradin = new Dwarf();
        elfoDoTest.atirarFlechaNoDwarf(dwarf);
        elfoDoTest.atirarFlechaNoDwarf(muradin);
        assertEquals(100,dwarf.getVida());
        assertEquals(100,muradin.getVida());
        assertEquals(2,elfoDoTest.getExperiencia());
    }

    @Test
    public void elfoInformaçõesSobreArcoFlechaEExperiencia(){
        Elfo elfo1 = new Elfo("Frechina", 42);
        assertEquals("Frechina possui 42 flechas e 0 níveis de experiência.", elfo1.toString());
    }

    @Test
    public void elfoInformaçõesSobreArcoFlechaEExperienciaAtirando1Flecha(){
        Elfo elfo1 = new Elfo("Frechina", 42);
        elfo1.atirarFlecha();
        assertEquals("Frechina possui 41 flechas e 1 nível de experiência.", elfo1.toString());
    }

    @Test
    public void elfoInformaçõesSobreArcoFlechaEExperienciaAtirando41Flechas(){
        Elfo elfo1 = new Elfo("Frechina", 42);
        int x=0;
        while(x++ < 41){
        elfo1.atirarFlecha();
    }
        assertEquals("Frechina possui 1 flecha e 41 níveis de experiência.", elfo1.toString());
    }

    @Test
    public void elfoQueNasceCom100Flechas(){
        Elfo elfo1 = new Elfo("Frechina", 100);
        assertEquals("Frechina possui 100 flechas e 0 níveis de experiência.", elfo1.toString());
    }

    @Test
    public void elfoQueNasceCom1000FlechasEDepoisAtira5(){
        Elfo elfo1 = new Elfo("Frechina", 1000);
        assertEquals("Frechina possui 1000 flechas e 0 níveis de experiência.", elfo1.toString());
        elfo1.atirarFlecha();
        elfo1.atirarFlecha();
        elfo1.atirarFlecha();
        elfo1.atirarFlecha();
        elfo1.atirarFlecha();
        assertEquals("Frechina possui 995 flechas e 5 níveis de experiência.", elfo1.toString());
    }

    @Test
    public void criarElfoInformandoFlechaNegativa(){
        Elfo elfo1 = new Elfo("Frechina", -56);
        Inventario inventarioElfo = new Inventario();
        assertEquals(42,inventarioElfo.getItens().get(1).getQuantidade());
    }

    @Test
    public void criarElfoInformando0Flechas(){
        Elfo elfo1 = new Elfo("Frechina", 0);
        Inventario inventarioElfo = new Inventario();
        assertEquals(0,inventarioElfo.getItens().get(1).getQuantidade());
    }

    @Test
    public void elfoAtiraEmDwarfGetSorte33(){
        Elfo elfoDoTest = new Elfo("Elrond", 42);
        DataTerceiraEra dataNascimento = new DataTerceiraEra(1,1,399);
        Dwarf dwarf = new Dwarf("Meireles", dataNascimento);
        elfoDoTest.atirarFlechaNoDwarf(dwarf);
        assertEquals(110,dwarf.getVida());
        assertEquals(1,elfoDoTest.getExperiencia());
        assertEquals(0,dwarf.getExperiencia());
    }

    @Test
    public void elfoAtiraEmDwarfGetSorteMenos3333(){
        Elfo elfoDoTest = new Elfo("Elrond", 42);
        DataTerceiraEra dataNascimento = new DataTerceiraEra(1,1,400);
        Dwarf dwarf = new Dwarf("Meireles", dataNascimento);
        elfoDoTest.atirarFlechaNoDwarf(dwarf);
        assertEquals(100,dwarf.getVida());
        assertEquals(1,elfoDoTest.getExperiencia());
        assertEquals(0,dwarf.getExperiencia());
    }

    @Test
    public void elfoAtiraEmDwarfGetSorteMenos101(){
        Elfo elfoDoTest = new Elfo("Elrond", 42);
        Dwarf dwarf = new Dwarf();
        elfoDoTest.atirarFlechaNoDwarf(dwarf);
        assertEquals(100,dwarf.getVida());
        assertEquals(1,elfoDoTest.getExperiencia());
        assertEquals(0,dwarf.getExperiencia());
    }
    
    @Test
    public void elfoNasceVivo(){
        Elfo elfoDoTest = new Elfo("Elrond", 42);
        assertEquals(Status.VIVO,elfoDoTest.getStatus());
    }
}
