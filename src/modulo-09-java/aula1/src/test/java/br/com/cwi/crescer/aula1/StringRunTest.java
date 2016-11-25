package br.com.cwi.crescer.aula1;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * @author Carlos H. Nonnemacher
 */
public class StringRunTest {

    /**
     * Test of contaVogais method, of class StringRun.
     */
    @Test
    public void testContaVogais() {
        assertEquals(2, new StringRun().contaVogais("crescer"));        
    }

    /**
     * Test of inverteString method, of class StringRun.
     */
    @Test
    public void testInverteString() {
        assertEquals("recserc", new StringRun().inverteString("crescer"));        
    }
    
}
