
public class NaoPodeAlistarException extends Exception
{
    public NaoPodeAlistarException(){
        super("Não foi possível alistar o Elfo.");
    }
                                
    public NaoPodeAlistarException(String erro){
        super(erro);
    }
}
