

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CestoDeLembasTest
{
    @Test
    public void lembasSoSeDivideEmEntre4(){
        CestoDeLembas OitoComGluten = new CestoDeLembas(4);
        assertTrue(OitoComGluten.podeDividirEmPares());
    }
    @Test
    public void lembasNaoSeDivideEmCom3(){
        CestoDeLembas TresComGluten = new CestoDeLembas(3);
        assertFalse(TresComGluten.podeDividirEmPares());
    }
    @Test
    public void lembasNaoSeDivideEmCom1(){
        CestoDeLembas TresComGluten = new CestoDeLembas(1);
        assertFalse(TresComGluten.podeDividirEmPares());
    }
    @Test
    public void lembasNaoSeDivideSeTemMaisDe100(){
        CestoDeLembas TresComGluten = new CestoDeLembas(101);
        assertFalse(TresComGluten.podeDividirEmPares());
    }
}
