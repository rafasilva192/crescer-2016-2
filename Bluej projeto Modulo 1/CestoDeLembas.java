public class CestoDeLembas
{
    // instance variables - replace the example below with your own
    private int lembas;

    /**
     * Constructor for objects of class CestoDeLembas
     */
    public CestoDeLembas(int qtd){
       lembas = qtd;
    }
    public void setLembas(int qtd){
        lembas = qtd;
    }
    public int getLembas(){
        return lembas;
    }
    public boolean podeDividirEmPares(){
        int divisao = lembas/2;
        divisao = divisao % 2;
        if(divisao == 0){
            return true;
        }
        else{
            return false;
        }
    }
}
