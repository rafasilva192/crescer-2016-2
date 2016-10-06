import java.util.*;

public class ExercitoEspecialDeElfo implements Exercito{
    private HashMap<String,ArrayList<Elfo>> exercitoDeElfo = new HashMap<>();
    private HashMap<Status,ArrayList<Elfo>> statusDosElfos = new HashMap<>();
    public void exercitoDeElfo(Elfo elfo){ 
        if(elfo instanceof ElfoVerde || elfo instanceof ElfoNoturno){
            ArrayList<Elfo> elfosComEsteNome = exercitoDeElfo.get(elfo.getNome());
            boolean aindaNaoTemElfoComEsteNome = elfosComEsteNome == null;
            if(aindaNaoTemElfoComEsteNome){
                elfosComEsteNome = new ArrayList<>();
                exercitoDeElfo.put(elfo.getNome(), elfosComEsteNome);
            }
            elfosComEsteNome.add(elfo);
        }
    }

    public Elfo buscarNoExercito(String Nome){
        return exercitoDeElfo.containsKey(Nome)?exercitoDeElfo.get(Nome).get(0):null;
    }

    public void agruparPorStatus(){
        statusDosElfos.clear();
        for(Map.Entry<String, ArrayList<Elfo>> par : exercitoDeElfo.entrySet()){
            ArrayList<Elfo> elfos = par.getValue();
            for(Elfo elfo : elfos){
                Status status = elfo.getStatus();
                ArrayList<Elfo> elfosDoStatus = statusDosElfos.get(status);
                boolean aindaNaoAgrupeiPorEsteStatus = elfosDoStatus == null;
                if(aindaNaoAgrupeiPorEsteStatus){
                    elfosDoStatus = new ArrayList<>();
                    statusDosElfos.put(status, elfosDoStatus);
                }
                elfosDoStatus.add(elfo);
            }
        }
    }

    public ArrayList<Elfo> buscarPorStatus(Status status){
        agruparPorStatus();
        return statusDosElfos.get(status);
    }

    public Elfo[] getContigente(){
        ArrayList<Elfo> resultado = new ArrayList<>();
        for(ArrayList<Elfo> listas : exercitoDeElfo.values()){
            resultado.addAll(listas);
        }
        return resultado.toArray(new Elfo[resultado.size()]);
    }
}
