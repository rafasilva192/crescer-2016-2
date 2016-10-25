import java.util.ArrayList;

public class Inventario {
    private ArrayList<Item> itens;

    public Inventario() {
        itens = new ArrayList<>();
    }

    public ArrayList<Item> getItens() {
        return itens;
    }

    public void adicionarItem(Item item) {
        itens.add(item);
    }

    public void removerItem(Item item) {
        itens.remove(item);
    }

    public String getDescricoesItens() {
        //"Adaga,Escudo,Bracelete"
        StringBuilder resultado = new StringBuilder("");

        /*for (int i = 0; i < itens.size(); i++) {
        Item itemAtual = itens.get(i);
        resultado += String.format("%s,", itemAtual.getDescricao());
        }*/

        /*int i = 0;
        while (i < itens.size()) {
        Item itemAtual = itens.get(i);
        resultado += String.format("%s,", itemAtual.getDescricao());
        i++;
        }*/

        /*int i = 0;
        do {
        Item itemAtual = itens.get(i);
        resultado += String.format("%s,", itemAtual.getDescricao());
        i++;
        } while (i < itens.size());*/

        for (Item itemAtual : itens) {
            resultado.append(String.format("%s,", itemAtual.getDescricao()));
        }

        return resultado.length() == 0 ? resultado.toString() : resultado.substring(0, resultado.length() - 1);
    }

    public void aumentarUnidadesDosItens(int unidades) {
        for (Item item : itens) {
            item.aumentarUnidades(unidades);
        }
    }

    public void aumentarUnidadesProporcionalQuantidadePorItem() {
        for (Item item : this.itens) {
            item.aumentarProporcionalQuantidade();
        }
    }

    public Item getItemComMaiorQuantidade() {
        // maiorAteAgora = 0
        // percorro todos os itens verificando se existe alguém maior que o até agora
        // caso existir, atualiza a variável
        // retorna no final
        int indice = 0, maiorQtdAteAgora = 0;

        for (int i = 0; i < itens.size(); i++) {
            int qtdAtual = itens.get(i).getQuantidade();
            if (qtdAtual > maiorQtdAteAgora) {
                maiorQtdAteAgora = qtdAtual;
                indice = i;
            }
        }

        boolean temItens = !itens.isEmpty();
        return temItens ? itens.get(indice) : null;
    }

    public void ordenarItens() {
        ordenarItens(TipoOrdenacao.ASCENDENTE);
    }

    public void ordenarItens(TipoOrdenacao tipoOrdenacao) {
        // Versão mais estável do Bubblesort - Melhor caso O(n), Pior caso O(n^2)
        // homenagem ao do-while: para forçar entrada na lógica
        boolean posicoesSendoTrocadas;
        boolean ascendente = tipoOrdenacao == TipoOrdenacao.ASCENDENTE;
        do {
            posicoesSendoTrocadas = false;
            for (int j = 0; j < this.itens.size() - 1; j++) {
                Item itemAtual = this.itens.get(j);
                Item proximo = this.itens.get(j + 1);

                boolean precisaTrocar = 
                    ascendente ? itemAtual.getQuantidade() > proximo.getQuantidade() : itemAtual.getQuantidade() < proximo.getQuantidade();

                if (precisaTrocar) {
                    this.itens.set(j, proximo);
                    this.itens.set(j + 1, itemAtual);
                    posicoesSendoTrocadas = true;
                }
            }
        } while (posicoesSendoTrocadas);

    }
}




