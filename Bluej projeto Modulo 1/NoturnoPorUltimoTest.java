
import java.util.*;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class NoturnoPorUltimoTest
{
    @Test
    public void buscarElfosPorStatus(){
        NoturnoPorUltimo estrategia = new NoturnoPorUltimo();
        List<Elfo> lista = new ArrayList<Elfo>();
        List<Elfo> ordemDeAtaque = new ArrayList<Elfo>();
        lista.addAll(listaParaTestes(1));//adiciona 10 verdes e 10 noturnos intercalando
        Elfo recruta21 = new ElfoNoturno("Suiçida", 100);
        for(int i = 0; i < 100; i++){
            recruta21.atirarFlecha();
        }
        lista.add(recruta21);
        ordemDeAtaque.addAll(estrategia.getOrdemDeAtaque(lista));
        assertEquals(20, ordemDeAtaque.size());
    }

    @Test
    public void ordenacaoElfosNoturnoPorUltimo(){
        NoturnoPorUltimo estrategia = new NoturnoPorUltimo();
        List<Elfo> lista = new ArrayList<Elfo>();
        List<Elfo> ordemDeAtaque = new ArrayList<Elfo>();
        lista.addAll(listaParaTestes(1));//adiciona 10 verdes e 10 noturnos intercalando
        ordemDeAtaque.addAll(estrategia.getOrdemDeAtaque(lista));
        for(int i = 0; i < 10; i++){
            assertTrue(ordemDeAtaque.get(i) instanceof ElfoVerde);

            assertTrue(ordemDeAtaque.get(i+10) instanceof ElfoNoturno);
        }
    }

    @Test
    public void ordenacaoElfosNoturnoPorUltimoSoElfoNoturno(){
        NoturnoPorUltimo estrategia = new NoturnoPorUltimo();
        List<Elfo> lista = new ArrayList<Elfo>();
        List<Elfo> ordemDeAtaque = new ArrayList<Elfo>();
        lista.addAll(listaParaTestes(2));//adiciona 20 noturnos
        ordemDeAtaque.addAll(estrategia.getOrdemDeAtaque(lista));
        for(int i = 0; i < 20; i++){
            assertTrue(ordemDeAtaque.get(i) instanceof ElfoNoturno);
        }
    }

    @Test
    public void ordenacaoElfosNoturnoPorUltimoSoElfoVerde(){
        NoturnoPorUltimo estrategia = new NoturnoPorUltimo();
        List<Elfo> lista = new ArrayList<Elfo>();
        List<Elfo> ordemDeAtaque = new ArrayList<Elfo>();
        lista.addAll(listaParaTestes(3));//adiciona 20 verdes
        ordemDeAtaque.addAll(estrategia.getOrdemDeAtaque(lista));
        for(int i = 0; i < 20; i++){
            assertTrue(ordemDeAtaque.get(i) instanceof ElfoVerde);
        }
    }

    @Test
    public void ordenacaoElfosNoturnoPorUltimoPirmeiroElfoehNoturno(){
        NoturnoPorUltimo estrategia = new NoturnoPorUltimo();
        List<Elfo> lista = new ArrayList<Elfo>();
        List<Elfo> ordemDeAtaque = new ArrayList<Elfo>();
        lista.addAll(listaParaTestes(4));//adiciona 1 noturno e 19 verdes
        ordemDeAtaque.addAll(estrategia.getOrdemDeAtaque(lista));
        assertTrue(ordemDeAtaque.get(19) instanceof ElfoNoturno);
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
        }
        return listaDeTeste;
    }
}
