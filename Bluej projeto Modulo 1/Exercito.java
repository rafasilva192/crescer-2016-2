import java.util.ArrayList;
public abstract class Exercito
{  
    protected ArrayList<Personagem> exercito;
    abstract void exercitoDeElfo(Elfo elfo);
    
    abstract Personagem buscarNoExercito(String Nome);
    
    abstract ArrayList<Personagem> buscarPorStatus(Status status);
}
