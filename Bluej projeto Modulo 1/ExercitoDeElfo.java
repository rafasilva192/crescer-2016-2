import java.util.ArrayList;
public class ExercitoDeElfo extends Exercito
{
    private ArrayList<Elfo> exercitoDeElfo = new ArrayList<>();
    
    public void exercitoDeElfo(Elfo elfo){
        if(elfo instanceof ElfoVerde || elfo instanceof ElfoNoturno){
            exercitoDeElfo.add(elfo);
        }
    }

    public ArrayList<Personagem> buscarPorStatus(Status status){
        ArrayList<Personagem> elfosStatus = new ArrayList<Personagem>();
        for(int i = 0; i < exercitoDeElfo.size() ; i++){
            if(exercitoDeElfo.get(i).getStatus().equals(status)){
                elfosStatus.add(exercitoDeElfo.get(i));
            }
        }
        return elfosStatus;
    }

    public Elfo buscarNoExercito(String Nome){
        for(int i = 0; i < exercitoDeElfo.size() ; i++){
            if(exercitoDeElfo.get(i).getNome().equals(Nome))
                return exercitoDeElfo.get(i);
        }
        return null;
    }
}
