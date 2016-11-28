package br.com.cwi.crescer.aula1.util;

import static java.time.LocalDate.of;
import static org.junit.Assert.assertEquals;

import java.time.Month;
import java.util.Calendar;
import org.junit.Test;

/**
 * @author Carlos H. Nonnemacher
 */
public class MeuCalendarioUtilTest {
    
    /**
     * Test of diaSemana method, of class MeuCalendarioUtil.
     */
    @Test
    public void testDiaSemana() {
        final Calendar calendar = Calendar.getInstance();
        calendar.set(2016, 10, 25);
        assertEquals("Sexta", new MeuCalendarioUtil().diaSemana(calendar.getTime()));
    }

    /**
     * Test of tempoDecorrido method, of class MeuCalendarioUtil.
     */
    @Test
    public void testTempoDecorrido() {
        final Calendar c = Calendar.getInstance();
        c.set(2016, 0, 1 , 0, 0, 0);
        assertEquals("Ano(s) 0, messes 10, dia(s) 24", new MeuCalendarioUtil().tempoDecorrido(of(2016, Month.JANUARY, 1)));
        assertEquals("Ano(s) 0, messes 10, dia(s) 26", new MeuCalendarioUtil().tempoDecorrido(c.getTime()));
    }
    
}
