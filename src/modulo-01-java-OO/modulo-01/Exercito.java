import java.util.List;

public interface Exercito {
    Elfo[] getContingente();
    void alistar(Elfo elfo) throws NaoPodeAlistarException;
    Elfo buscar(String nome);
    List<Elfo> buscar(Status status);
    void atacar();
}
