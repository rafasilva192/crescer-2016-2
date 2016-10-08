
import java.util.*;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class EstrategiaLittleMumuTest
{
    @Test
    public void organizandoTesteEstrategiaLittleMumuTestCom10VerdesENoturnos(){        
        EstrategiaLittleMumu estrategia = new EstrategiaLittleMumu();
        List<Elfo> lista = new ArrayList<Elfo>();
        List<Elfo> ordemDeAtaque = new ArrayList<Elfo>();
        lista.addAll(listaParaTestes(5)); //adiciona 10 elfos verdes e depois 10 noturnos
        ordemDeAtaque.addAll(estrategia.getOrdemDeAtaque(lista));
        for(int i = 0; i < 10; i++){
            assertTrue(ordemDeAtaque.get(i) instanceof ElfoVerde);
        }
        for(int i = 0; i < 3; i++){
            assertTrue(ordemDeAtaque.get(i+10) instanceof ElfoNoturno);
        }
    }
    
    @Test
    public void organizandoTesteEstrategiaLittleMumuTestComElfosSemFlechas(){        
        EstrategiaLittleMumu estrategia = new EstrategiaLittleMumu();
        List<Elfo> lista = new ArrayList<Elfo>();
        List<Elfo> ordemDeAtaque = new ArrayList<Elfo>();
        lista.addAll(listaParaTestes(0));//adiciona 4 elfos verdes sem flechas e depois 12 verdes e noturnos com flechas
        ordemDeAtaque.addAll(estrategia.getOrdemDeAtaque(lista));
        for(int i = 0; i < 12; i++){
            assertTrue(ordemDeAtaque.get(i) instanceof ElfoVerde);
        }
        for(int i = 0; i < 3; i++){
            assertTrue(ordemDeAtaque.get(i+12) instanceof ElfoNoturno);
        }
    }
    
    @Test
    public void organizandoTesteEstrategiaLittleMumuTestComListaVazia(){        
        EstrategiaLittleMumu estrategia = new EstrategiaLittleMumu();
        List<Elfo> lista = new ArrayList<Elfo>();
        List<Elfo> ordemDeAtaque = new ArrayList<Elfo>();
        lista.addAll(listaParaTestes(10)); //nao existe, chama uma lista vazia
        ordemDeAtaque.addAll(estrategia.getOrdemDeAtaque(lista));
        assertTrue(ordemDeAtaque.isEmpty());
    }
    
    @Test
    public void organizandoTesteEstrategiaLittleMumuTestSóAdicionandoNoturno(){        
        EstrategiaLittleMumu estrategia = new EstrategiaLittleMumu();
        List<Elfo> lista = new ArrayList<Elfo>();
        List<Elfo> ordemDeAtaque = new ArrayList<Elfo>();
        lista.addAll(listaParaTestes(2));// adiciona 20 noturnos
        ordemDeAtaque.addAll(estrategia.getOrdemDeAtaque(lista));
        assertTrue(ordemDeAtaque.isEmpty());
    }
    
    @Test
    public void organizandoTesteEstrategiaLittleMumuTestOrganizandoPorFlechas(){        
        EstrategiaLittleMumu estrategia = new EstrategiaLittleMumu();
        List<Elfo> lista = new ArrayList<Elfo>();
        List<Elfo> ordemDeAtaque = new ArrayList<Elfo>();
        lista.addAll(listaParaTestes(8));//adiciona 10 noturnos e depois 10 verdes com quantidades de flechas variadas
        ordemDeAtaque.addAll(estrategia.getOrdemDeAtaque(lista));
        for(int i = 0; i < ordemDeAtaque.size()-1; i++){
            assertTrue(ordemDeAtaque.get(i).getFlechas().getQuantidade() > ordemDeAtaque.get(i+1).getFlechas().getQuantidade());
        }
    }
    
    @Test
    public void organizandoTesteEstrategiaLittleMumuTestSóAdicionandoVerde(){        
        EstrategiaLittleMumu estrategia = new EstrategiaLittleMumu();
        List<Elfo> lista = new ArrayList<Elfo>();
        List<Elfo> ordemDeAtaque = new ArrayList<Elfo>();
        lista.addAll(listaParaTestes(3));//adiciona 20 elfos verdes
        ordemDeAtaque.addAll(estrategia.getOrdemDeAtaque(lista));
        assertEquals(20, ordemDeAtaque.size());
    }
    
     private List<Elfo> listaParaTestes(int lista){
        List<Elfo> listaDeTeste = new ArrayList<Elfo>();
        switch(lista){
            case 0:
            for(int i = 0; i < 4; i++){
                listaDeTeste.add(new ElfoVerde("Recruta"+i,0));

            }
            for(int i = 0; i < 12; i++){
                listaDeTeste.add(new ElfoVerde("Recruta"+i,100));

            }
            for(int i = 0; i < 12; i++){
                listaDeTeste.add(new ElfoNoturno("Recruta"+i,100));

            }
            break;
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
            break;
            case 8:
            for(int i = 0; i < 10; i++){
                listaDeTeste.add(new ElfoNoturno("Recruta"+i,i));
            }
            for(int i = 0; i < 10; i++){
                listaDeTeste.add(new ElfoVerde("Recruta"+i,i+10));
            }
        }
        return listaDeTeste;
    }
}
