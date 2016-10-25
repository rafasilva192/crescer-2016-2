public class NaoPodeAlistarException extends Exception {
    
    public NaoPodeAlistarException() {
        super("Não foi possível alistar o Elfo, pois apenas Verdes e Noturnos são válidos.");
    }
    
    public NaoPodeAlistarException(String erro) {
        super(erro);
    }
    
}