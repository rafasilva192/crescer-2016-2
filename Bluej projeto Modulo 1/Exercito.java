import java.util.*;
public interface Exercito
{
    void exercitoDeElfo(Elfo elfo) throws NaoPodeAlistarException;

    Elfo buscarNoExercito(String Nome);

    ArrayList<Elfo> buscarPorStatus(Status status);

    public Elfo[] getContigente();

}
