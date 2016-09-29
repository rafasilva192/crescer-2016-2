public class CestoDeLembas
{
    private int numeroPaes;
    
    public CestoDeLembas(int numeroPaes) {
        this.numeroPaes = numeroPaes;
    }
    
    public boolean podeDividirEmPares() {
        return numeroPaes > 2 && numeroPaes % 2 == 0 && numeroPaes <= 100;
    }
}