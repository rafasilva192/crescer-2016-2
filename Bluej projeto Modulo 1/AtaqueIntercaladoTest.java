
import java.util.*;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AtaqueIntercaladoTest
{
    @Test
    public void organizandoTesteIntercalandoElfoVerdePrimeiro()throws ContingenteDesproporcionalException{        
        AtaqueIntercalado estrategia = new AtaqueIntercalado();
        List<Elfo> lista = new ArrayList<Elfo>();
        List<Elfo> ordemDeAtaque = new ArrayList<Elfo>();
        lista.addAll(listaParaTestes(5));//adiciona 10 elfos verdes e depois 10 noturnos
        ordemDeAtaque.addAll(estrategia.getOrdemDeAtaque(lista));
        for(int i = 0; i < 20; i++){
            assertTrue(ordemDeAtaque.get(i) instanceof ElfoVerde);
            i++;
            assertTrue(ordemDeAtaque.get(i) instanceof ElfoNoturno);
        }
    }
    
    

    @Test
    public void organizandoTesteIntercalandoElfoNoturnoPrimeiro()throws ContingenteDesproporcionalException{
        AtaqueIntercalado estrategia = new AtaqueIntercalado();
        List<Elfo> lista = new ArrayList<Elfo>();List<Elfo> ordemDeAtaque = new ArrayList<Elfo>();
        List<Elfo> ordemDeAtaque2 = new ArrayList<Elfo>();
        lista.addAll(listaParaTestes(6));//adiciona 10 elfos noturnos e depois 10 verdes
        ordemDeAtaque.addAll(estrategia.getOrdemDeAtaque(lista));
        for(int i = 0; i < 20; i++){
            assertTrue(ordemDeAtaque.get(i) instanceof ElfoNoturno);
            i++;
            assertTrue(ordemDeAtaque.get(i) instanceof ElfoVerde);
        }
    }
    
    @Test
    public void organizandoTesteIntercalandoComOrdemAleatoriaEListaGrande()throws ContingenteDesproporcionalException{
        AtaqueIntercalado estrategia = new AtaqueIntercalado();
        List<Elfo> lista = new ArrayList<Elfo>();List<Elfo> ordemDeAtaque = new ArrayList<Elfo>();
        List<Elfo> ordemDeAtaque2 = new ArrayList<Elfo>();
        lista.addAll(listaParaTestes(7));//adiciona de forma 'aleatoria' 50 noturnos e 50 verdes
        ordemDeAtaque.addAll(estrategia.getOrdemDeAtaque(lista));
        for(int i = 0; i < ordemDeAtaque.size(); i++){
            assertTrue(ordemDeAtaque.get(i) instanceof ElfoNoturno);
            i++;
            assertTrue(ordemDeAtaque.get(i) instanceof ElfoVerde);
        }
    }
    
    @Test (expected=ContingenteDesproporcionalException.class)
    public void organizandoTesteIntercalandoContigenteDesproporcional()throws ContingenteDesproporcionalException{
        AtaqueIntercalado estrategia = new AtaqueIntercalado();
        List<Elfo> lista = new ArrayList<Elfo>();List<Elfo> ordemDeAtaque = new ArrayList<Elfo>();
        List<Elfo> ordemDeAtaque2 = new ArrayList<Elfo>();
        lista.addAll(listaParaTestes(4)); //adiciona 1 noturno e 19 verdes
        ordemDeAtaque.addAll(estrategia.getOrdemDeAtaque(lista));
    }

    private List<Elfo> listaParaTestes(int lista){
        List<Elfo> listaDeTeste = new ArrayList<Elfo>();
        switch(lista){
            case 1:
            for(int i = 0; i < 20; i++){
                listaDeTeste.add(new ElfoVerde("Recruta"+i,100));
                i++;
                listaDeTeste.add(new ElfoNoturno("Recruta"+i,100));

            }
            break;
            case 2: 
            for(int i = 0; i < 20; i++){
                listaDeTeste.add(new ElfoNoturno("Recruta"+i,100));

            }
            break;
            case 3:
            for(int i = 0; i < 20; i++){
                listaDeTeste.add(new ElfoVerde("Recruta"+i,100));

            }
            break;
            case 4:
            listaDeTeste.add(new ElfoNoturno("Recruta",100));
            for(int i = 0; i < 19; i++){
                listaDeTeste.add(new ElfoVerde("Recruta"+i,100));

            }
            break;
            case 5:
            for(int i = 0; i < 10; i++){
                listaDeTeste.add(new ElfoVerde("Recruta"+i,100));
            }
            for(int i = 0; i < 10; i++){
                listaDeTeste.add(new ElfoNoturno("Recruta"+i,100));
            }
            break;
            case 6:
            for(int i = 0; i < 10; i++){
                listaDeTeste.add(new ElfoNoturno("Recruta"+i,100));
            }
            for(int i = 0; i < 10; i++){
                listaDeTeste.add(new ElfoVerde("Recruta"+i,100));
            }
            break;
            case 7:
            for(int i = 0; i < 10; i++){
                listaDeTeste.add(new ElfoNoturno("Recruta"+i,100));
            }
            for(int i = 0; i < 10; i++){
                listaDeTeste.add(new ElfoNoturno("Recruta"+i,100));
            }
            for(int i = 0; i < 10; i++){
                listaDeTeste.add(new ElfoVerde("Recruta"+i,100));
            }
            for(int i = 0; i < 10; i++){
                listaDeTeste.add(new ElfoNoturno("Recruta"+i,100));
            }
            for(int i = 0; i < 10; i++){
                listaDeTeste.add(new ElfoNoturno("Recruta"+i,100));
            }
            for(int i = 0; i < 10; i++){
                listaDeTeste.add(new ElfoVerde("Recruta"+i,100));
            }
            for(int i = 0; i < 10; i++){
                listaDeTeste.add(new ElfoVerde("Recruta"+i,100));
            }
            for(int i = 0; i < 10; i++){
                listaDeTeste.add(new ElfoVerde("Recruta"+i,100));
            }
            for(int i = 0; i < 10; i++){
                listaDeTeste.add(new ElfoNoturno("Recruta"+i,100));
            }
            for(int i = 0; i < 10; i++){
                listaDeTeste.add(new ElfoVerde("Recruta"+i,100));
            }
        }
        return listaDeTeste;
    }
}
