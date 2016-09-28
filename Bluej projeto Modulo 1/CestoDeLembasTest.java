

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CestoDeLembasTest
{
    @Test
    public void lembasSoSeDivideEmPares(){
        CestoDeLembas OitoComGluten = new CestoDeLembas(8);
        assertEquals(true, OitoComGluten.podeDividirEmPares());
    }
    @Test
    public void lembasNaoSeDivideEmImpares(){
        CestoDeLembas TresComGluten = new CestoDeLembas(3);
        assertEquals(false, TresComGluten.podeDividirEmPares());
    }
}
