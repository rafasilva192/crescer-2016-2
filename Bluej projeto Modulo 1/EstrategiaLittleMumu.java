import java.util.*;
public class EstrategiaLittleMumu implements Estrategia
{
    public List<Elfo> getOrdemDeAtaque(List<Elfo> atacantes){
        List<Elfo> listaDeElfos = new ArrayList<Elfo>();
        listaDeElfos.addAll(buscarPorElfosAptos(atacantes));
        ordernarElfosPorFlechas(listaDeElfos);
        return listaDeElfos;
    }

    private List<Elfo> buscarPorElfosAptos(List<Elfo> atacantes){
        double elfosNaLista = 0;
        int elfosNoturnosNaLista = 0;
        List<Elfo> elfosAptos = new ArrayList<Elfo>();
        for(Elfo elfo : atacantes){
            boolean elfoEstaVivo = elfo.getStatus().equals(Status.VIVO);
            boolean temFlecha = elfo.getFlechas().getQuantidade() > 0;
            if(elfoEstaVivo && temFlecha){
                elfosAptos.add(elfo);
                if(elfo instanceof ElfoVerde){
                    elfosNaLista++;
                } else elfosNoturnosNaLista++;
            }
        }
        ordernarPelotao(elfosAptos, elfosNaLista, elfosNoturnosNaLista);
        return elfosAptos;
    }

    private void ordernarElfosPorFlechas(List<Elfo> elfosAptos){
        Collections.sort(elfosAptos, new Elfo.ComparadorDeFlechas());
    }

    private void ordernarPelotao(List<Elfo> elfosAptos, double elfosNaLista, int elfosNoturnosNaLista){
        double calculoDoTotalDeNoturno = elfosNaLista*0.3;
        int elfosNoturnosQueFicaram = (int)calculoDoTotalDeNoturno;
        int totalASeremRemovidos = elfosNoturnosNaLista - elfosNoturnosQueFicaram;
        for(int i = 0; i < elfosAptos.size(); i++){
            if(totalASeremRemovidos <= 0) break;
            if(elfosAptos.get(i) instanceof ElfoNoturno){
                elfosAptos.remove(elfosAptos.get(i));
                i--;
                totalASeremRemovidos--;
            }
        }
    }
}
