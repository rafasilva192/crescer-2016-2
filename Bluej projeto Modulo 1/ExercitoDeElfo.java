import java.util.ArrayList;
public class ExercitoDeElfo implements Exercito{
    private ArrayList<Elfo> exercitoDeElfo = new ArrayList<>();
    public void exercitoDeElfo(Elfo elfo)throws NaoPodeAlistarException{
        if(!(elfo instanceof ElfoVerde || elfo instanceof ElfoNoturno)){
            throw new NaoPodeAlistarException();
        }
        if(elfo instanceof ElfoVerde || elfo instanceof ElfoNoturno){
            exercitoDeElfo.add(elfo);
        }
    }

    public ArrayList<Elfo> buscarPorStatus(Status status){
        ArrayList<Elfo> elfosStatus = new ArrayList<Elfo>();
        for(Elfo elfo : exercitoDeElfo){
            if(elfo.getStatus().equals(status)){
                elfosStatus.add(elfo);
            }
        }
        return elfosStatus;
    }

    public Elfo buscarNoExercito(String Nome){
        for(Elfo elfo : exercitoDeElfo){
            if(Nome.equals(elfo.getNome())){
                return elfo;
            }

        }
        return null;
    }
    
    
    public Elfo[] getContigente(){
        return exercitoDeElfo.toArray(new Elfo[exercitoDeElfo.size()]);
    }
}
