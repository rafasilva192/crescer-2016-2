package br.com.cwi.crescer.aula1.util;

import static java.math.BigDecimal.TEN;
import static org.junit.Assert.assertEquals;

import java.util.Calendar;
import java.util.Date;
import java.util.Map;
import org.junit.Test;

/**
 * @author Carlos H. Nonnemacher
 */
public class ParcelatorTest {

    /**
     * Test of calcular method, of class Parcelator.
     */
    @Test
    public void testCalcular() {
        final Calendar calendar = Calendar.getInstance();
        calendar.set(2016, 10, 1);
        final Date vencimento = calendar.getTime();
        final Parcelator parcelator = Parcelator.novoParcelamento(TEN, 2, 10, vencimento);
        final Map<String, String> parcelas = parcelator.calcular();
        assertEquals(2, parcelas.size());
    }

}
