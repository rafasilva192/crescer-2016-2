import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DwarfTest
{
    @Test
    public void dwarfNasceCom110Vida() {
        Dwarf gimli = new Dwarf();
        assertEquals(110, gimli.getVida());
    }

    @Test
    public void dwarfNasceVivo() {
        assertEquals(Status.VIVO, new Dwarf().getStatus());
    }

    @Test
    public void dwarfPerdeVidaUmaVez() {
        Dwarf gimli = new Dwarf();
        gimli.perderVida();
        assertEquals(100, gimli.getVida());
    }

    @Test
    public void dwarfPerdeVidaDuasVezes() {
        Dwarf gimli = new Dwarf();
        gimli.perderVida();
        gimli.perderVida();
        assertEquals(90, gimli.getVida());
        assertEquals(Status.VIVO, gimli.getStatus());
    }

    @Test
    public void dwarfPerdeVidaVinteVezes() {
        Dwarf gimli = new Dwarf();
        gimli.perderVida();
        gimli.perderVida();
        gimli.perderVida();
        gimli.perderVida();
        gimli.perderVida();
        gimli.perderVida();
        gimli.perderVida();
        gimli.perderVida();
        gimli.perderVida();
        gimli.perderVida();
        gimli.perderVida();
        gimli.perderVida();
        gimli.perderVida();
        gimli.perderVida();
        gimli.perderVida();
        gimli.perderVida();
        gimli.perderVida();
        gimli.perderVida();
        gimli.perderVida();
        gimli.perderVida();
        assertEquals(0, gimli.getVida());
        assertEquals(Status.MORTO, gimli.getStatus());
    }

    @Test
    public void dwarfPerdeVidaOnzeVezesZeraVidaEMorre() {
        Dwarf gimli = new Dwarf();
        gimli.perderVida();
        gimli.perderVida();
        gimli.perderVida();
        gimli.perderVida();
        gimli.perderVida();
        gimli.perderVida();
        gimli.perderVida();
        gimli.perderVida();
        gimli.perderVida();
        gimli.perderVida();
        gimli.perderVida();
        assertEquals(0, gimli.getVida());
        assertEquals(Status.MORTO, gimli.getStatus());
    }

    @Test
    public void dwarfCriadoInformandoNomeENascimento() {
        Dwarf gimli = new Dwarf("Gimli", new DataTerceiraEra(12, 11, 1900));
        assertEquals("Gimli", gimli.getNome());
        assertEquals(12, gimli.getDataNascimento().getDia());
        assertEquals(11, gimli.getDataNascimento().getMes());
        assertEquals(1900, gimli.getDataNascimento().getAno());
    }

    @Test
    public void dwarfCriadoSemInformarNomeENascimento() {
        Dwarf gimli = new Dwarf();
        assertNull(gimli.getNome());
        assertEquals(1, gimli.getDataNascimento().getDia());
        assertEquals(1, gimli.getDataNascimento().getMes());
        assertEquals(1, gimli.getDataNascimento().getAno());
    }

    @Test
    public void gerarNumeroAnoBissextoVidaEntre80e90() {
        // Arrange
        Dwarf bernardin = new Dwarf("Bernardin", new DataTerceiraEra(01, 01, 2016));
        bernardin.perderVida();
        bernardin.perderVida();
        bernardin.perderVida();
        // Act
        double resultado = bernardin.getNumeroSorte();
        // Assert
        assertEquals(-3333.0, resultado, .0);
    }

    @Test
    public void gerarNumeroAnoNaoBissextoNomeSeixas() {
        // Arrange
        Dwarf seixas = new Dwarf("Seixas", new DataTerceiraEra(01, 01, 2015));
        // Act
        double resultado = seixas.getNumeroSorte();
        // Assert
        assertEquals(33.0, resultado, .0);
    }

    @Test
    public void gerarNumeroAnoNaoBissextoNomeMeireles() {
        // Arrange
        Dwarf seixas = new Dwarf("Meireles", new DataTerceiraEra(01, 01, 2015));
        // Act
        double resultado = seixas.getNumeroSorte();
        // Assert
        assertEquals(33.0, resultado, .0);
    }

    @Test
    public void gerarNumeroSemEntrarNasCondicoes() {
        // Arrange
        Dwarf balin = new Dwarf("Balin", new DataTerceiraEra(1, 1, 2015));
        // Act
        double resultado = balin.getNumeroSorte();
        // Assert
        assertEquals(101.0, resultado, .0);
    }

    @Test
    public void dwarfPerderVidaComNumeroSorteNegativo() {
        // Arrange
        Dwarf dwarf = new Dwarf("Gimli", new DataTerceiraEra(1,1,2000));
        dwarf.perderVida();
        dwarf.perderVida();
        // Act
        dwarf.perderVida();
        // Assert
        assertEquals(2, dwarf.getExperiencia());
        assertEquals(90, dwarf.getVida(), .0);   
    }

    @Test
    public void dwarfPerderVidaComAnoNaoBissextoMeirelesNaoPerde() {
        Dwarf meireles = new Dwarf("Meireles", new DataTerceiraEra(2, 3, 2015));
        meireles.perderVida();
        assertEquals(0, meireles.getExperiencia());
        assertEquals(110, meireles.getVida(), .0);
    }

    @Test
    public void dwarfPerderVidaNormal(){
        Dwarf dwarf = new Dwarf("André Nunin", new DataTerceiraEra(2, 3, 2015));
        dwarf.perderVida();
        assertEquals(100, dwarf.getVida(), .0);
        assertEquals(0, dwarf.getExperiencia());
    }
}

