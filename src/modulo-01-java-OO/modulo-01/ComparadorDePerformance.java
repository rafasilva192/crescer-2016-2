import java.util.*;

public class ComparadorDePerformance {
    public void compararPesquisaArrayListHashMap() {

        ArrayList<Elfo> arrayListElfos = new ArrayList<>();
        HashMap<String, Elfo> hashElfos = new HashMap<>();
        // Populo as duas estruturas com 1 milhão de elfos
        for (int i = 0; i < 800000; i++) {
            String nome = "Elfo " + i;
            Elfo elfo = new Elfo(nome);
            arrayListElfos.add(elfo);
            hashElfos.put(nome, elfo);
        }

        long m1Inicio = System.currentTimeMillis();
        Elfo elfoArr = pesquisarElfoArr(arrayListElfos, "Elfo 566000");
        long m1Fim = System.currentTimeMillis();

        long m2Inicio = System.currentTimeMillis();
        Elfo elfoHash = pesquisarElfoHash(hashElfos, "Elfo 566000");
        long m2Fim = System.currentTimeMillis();

        // String.format("%.8f", (m1Fim - m1Inicio) / 1000.0));
        
        System.out.println("ArrayList: " + String.format("%.10f", (m1Fim - m1Inicio) / 1000.0));
        System.out.println("HashMap: " + String.format("%.10f", (m2Fim - m2Inicio) / 1000.0));

    }

    private Elfo pesquisarElfoHash(HashMap<String, Elfo> elfos, String nome) {
        return elfos.get(nome);
    }

    private Elfo pesquisarElfoArr(ArrayList<Elfo> elfos, String nome) {
        for (Elfo elfo : elfos) {
            if (elfo.getNome().equals(nome)) {
                return elfo;
            }
        }
        return null;
    }

}

