public class CestoDeLembas
{
    // instance variables - replace the example below with your own
    private int numeroLembas;

    /**
     * Constructor for objects of class CestoDeLembas
     */
    public CestoDeLembas(int numeroLembas){
        this.numeroLembas = numeroLembas;
    }

    public void setLembas(int numeroLembas){
        this.numeroLembas = numeroLembas;
    }

    public int getLembas(){
        return numeroLembas;
    }

    public boolean podeDividirEmPares(){
        return numeroLembas> 2 && numeroLembas % 2 == 0 && numeroLembas <= 100;
    }
    
}

