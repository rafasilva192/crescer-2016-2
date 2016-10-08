import java.util.*;
public class EstrategiaLittleMumu implements Estrategia
{
    public List<Elfo> getOrdemDeAtaque(List<Elfo> atacantes){
        List<Elfo> listaDeElfos = new ArrayList<Elfo>();
        listaDeElfos.addAll(buscarPorElfosAptos(atacantes));
        ordernarElfosPorFlechas(listaDeElfos);
        return listaDeElfos;
    }

    public List<Elfo> buscarPorElfosAptos(List<Elfo> atacantes){
        double elfosNaListaVerde = 0;
        int elfosNaListaNoturno = 0;
        List<Elfo> elfosAptos = new ArrayList<Elfo>();
        for(Elfo elfo : atacantes){
            boolean elfoEstaVivo = elfo.getStatus().equals(Status.VIVO);
            boolean temFlecha = elfo.getFlechas().getQuantidade() > 0;
            if(elfoEstaVivo && temFlecha){
                elfosAptos.add(elfo);
                if(elfo instanceof ElfoVerde){
                    elfosNaListaVerde++;
                }
                if(elfo instanceof ElfoNoturno){
                    elfosNaListaNoturno++;
                }
            }
        }
        ordernarPelotao(elfosAptos, elfosNaListaVerde, elfosNaListaNoturno);
        return elfosAptos;
    }

    public void ordernarElfosPorFlechas(List<Elfo> elfosAptos){
        for(Elfo elfo : elfosAptos){
            for(int i = 0; i < elfosAptos.size()-1; i++){
                Elfo elfoTrocaDeLugar = null;
                Elfo elfoAtual = elfosAptos.get(i);
                Elfo proximoElfo = elfosAptos.get(i+1);
                if(elfoAtual.getFlechas().getQuantidade() < proximoElfo.getFlechas().getQuantidade()){
                    elfoTrocaDeLugar = elfoAtual;
                    elfosAptos.set(i, proximoElfo);
                    elfosAptos.set(i+1, elfoTrocaDeLugar);
                }
            }
        }
    }

    public void ordernarPelotao(List<Elfo> elfosAptos, double elfosNaListaVerde, int elfosNaListaNoturno){
        double calculoDoTotalDeNoturno = elfosNaListaVerde*0.3;
        int elfosNoturnosQueFicaram = (int)calculoDoTotalDeNoturno;
        int totalASeremRemovidos = elfosNaListaNoturno - elfosNoturnosQueFicaram;
        for(int i = 0; i < elfosAptos.size(); i++){
            if(totalASeremRemovidos <= 0) break;
            if(elfosAptos.get(i) instanceof ElfoNoturno){
                elfosAptos.remove(elfosAptos.get(i));
                i--;
                totalASeremRemovidos--;
            }
        }
    }

    /*public void verificarComposicao(double elfosNaListaVerde, double elfosNaListaNoturno)throws ContingenteDesproporcionalException{
    double composicaoDeNoturnos = elfosNaListaNoturno / elfosNaListaVerde + elfosNaListaNoturno;
    if(!(composicaoDeNoturnos == 0.3)){
    throw new ContingenteDesproporcionalException();
    }
    }*/
}
