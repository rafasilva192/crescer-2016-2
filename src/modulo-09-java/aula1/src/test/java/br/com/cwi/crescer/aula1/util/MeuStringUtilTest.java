package br.com.cwi.crescer.aula1.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * @author Carlos H. Nonnemacher
 */
public class MeuStringUtilTest {

    /**
     * Test of contaVogais method, of class MeuStringUtil.
     */
    @Test
    public void testContaVogais() {
        assertEquals(2, new MeuStringUtil().contaVogais("crescer"));
    }

    /**
     * Test of inverteString method, of class MeuStringUtil.
     */
    @Test
    public void testInverteString() {
        assertEquals("recserc", new MeuStringUtil().inverteString("crescer"));
    }

    /**
     * Test of isEmpty method, of class MeuStringUtil.
     */
    @Test
    public void testIsEmpty() {
        final MeuStringUtil stringUtils = new MeuStringUtil();
        assertTrue(stringUtils.isEmpty(null));
        assertTrue(stringUtils.isEmpty(""));
        assertFalse(stringUtils.isEmpty("abc"));
    }

    /**
     * Test of isPalindromo method, of class MeuStringUtil.
     */
    @Test
    public void testIsPalindromo() {
        final MeuStringUtil stringUtils = new MeuStringUtil();
        assertFalse(stringUtils.isPalindromo(null));
        assertFalse(stringUtils.isPalindromo(""));
        assertTrue(stringUtils.isPalindromo("ovo"));
        assertTrue(stringUtils.isPalindromo("Ovo"));
        assertTrue(stringUtils.isPalindromo("Ame a ema"));
        assertTrue(stringUtils.isPalindromo("A sogra má e amargosa"));
    }

}
