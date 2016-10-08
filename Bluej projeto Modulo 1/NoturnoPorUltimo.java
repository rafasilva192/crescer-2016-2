import java.util.*;
public class NoturnoPorUltimo implements Estrategia
{
    public List<Elfo> getOrdemDeAtaque(List<Elfo> atacantes){
        List<Elfo> listaDeElfos = new ArrayList<Elfo>();
        listaDeElfos.addAll(buscarPorStatus(atacantes));
        ordernarElfos(listaDeElfos);
        return listaDeElfos;
    }

    private List<Elfo> buscarPorStatus(List<Elfo> atacantes){
        List<Elfo> elfosStatus = new ArrayList<Elfo>();
        for(Elfo elfo : atacantes){
            if(elfo.getStatus().equals(Status.VIVO)){
                elfosStatus.add(elfo);
            }
        }
        return elfosStatus;
    }

    private void ordernarElfos(List<Elfo> atacantes){
        for(Elfo elfo : atacantes){
            for(int i = 0; i < atacantes.size()-1; i++){
                boolean ehUmElfoVerde = atacantes.get(i+1) instanceof ElfoVerde;
                boolean ehUmElfoNoturno = atacantes.get(i) instanceof ElfoNoturno;
                if(ehUmElfoVerde && ehUmElfoNoturno){
                    Elfo trocaDeLugar = atacantes.get(i+1);
                    atacantes.set(i+1,atacantes.get(i));
                    atacantes.set(i,trocaDeLugar);
                }
            }
        }
    }

}

