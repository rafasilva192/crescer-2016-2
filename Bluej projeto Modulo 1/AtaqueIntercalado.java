import java.util.*;
public class AtaqueIntercalado
{
    public List<Elfo> getOrdemDeAtaque(List<Elfo> atacantes){
        List<Elfo> listaDeElfos = new ArrayList<Elfo>();
        listaDeElfos.addAll(buscarPorStatus(atacantes));
        ordernarElfos(listaDeElfos);
        return listaDeElfos;
    }
    
    public List<Elfo> buscarPorStatus(List<Elfo> atacantes){
        List<Elfo> elfosStatus = new ArrayList<Elfo>();
        for(Elfo elfo : atacantes){
            if(elfo.getStatus().equals(Status.VIVO)){
                elfosStatus.add(elfo);
            }
        }
        return elfosStatus;
    }

    public void ordernarElfos(List<Elfo> atacantes){
        for(Elfo elfo : atacantes){
            for(int i = 0; i < atacantes.size()-1; i++){
                boolean ehOMesmoTipo = atacantes.get(i).getClass().equals(atacantes.get(i+1).getClass());
                if(ehOMesmoTipo){
                    for(int j = i+1; j < atacantes.size(); j++){
                        boolean ehOMesmoTipoAinda = atacantes.get(i).getClass().equals(atacantes.get(j).getClass());
                        if(!ehOMesmoTipoAinda){
                            Elfo trocaDeLugar = atacantes.get(j);
                            atacantes.set(j,atacantes.get(i+1));
                            atacantes.set(i+1,trocaDeLugar);
                        }
                    }
                }
            }
        }

        /*
         * boolean ehUmElfoVerde = atacantes.get(i+1) instanceof ElfoVerde;
        boolean ehUmElfoNoturno = atacantes.get(i) instanceof ElfoNoturno;
        if(ehUmElfoVerde && ehUmElfoNoturno){
        Elfo trocaDeLugar = atacantes.get(i+1);
        atacantes.set(i+1,atacantes.get(i));
        atacantes.set(i,trocaDeLugar);
        }
         * 
         */
    }
}
