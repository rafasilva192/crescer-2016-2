import java.util.*;
public class AtaqueIntercalado implements Estrategia
{
    public List<Elfo> getOrdemDeAtaque(List<Elfo> atacantes)throws ContingenteDesproporcionalException{
        List<Elfo> listaDeElfos = new ArrayList<Elfo>();
        listaDeElfos.addAll(buscarPorStatus(atacantes));        
        ordernarElfos(listaDeElfos);
        return listaDeElfos;
    }

    public List<Elfo> buscarPorStatus(List<Elfo> atacantes)throws ContingenteDesproporcionalException{
        List<Elfo> elfosStatus = new ArrayList<Elfo>();
        int elfosNaLista = 0;
        for(Elfo elfo : atacantes){
            if(elfo.getStatus().equals(Status.VIVO)){
                elfosStatus.add(elfo);
                if(elfo instanceof ElfoVerde){
                    elfosNaLista++;
                }
                else if(elfo instanceof ElfoNoturno){
                    elfosNaLista--;
                }
            }
        }
        if (elfosNaLista != 0){
            throw new ContingenteDesproporcionalException();
        }
        return elfosStatus;
    }

    public void ordernarElfos(List<Elfo> atacantes){
        for(Elfo elfo : atacantes){
            for(int i = 0; i < atacantes.size()-2; i++){
                boolean ehOMesmoTipo = atacantes.get(i).getClass().equals(atacantes.get(i+1).getClass());
                if(ehOMesmoTipo){
                    for(int j = i+2; j < atacantes.size(); j++){
                        boolean ehOMesmoTipoAinda = atacantes.get(i+1).getClass().equals(atacantes.get(j).getClass());
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
