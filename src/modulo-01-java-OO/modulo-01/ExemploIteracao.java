import java.util.ArrayList;

public class ExemploIteracao
{
    public void rodar() {
        ArrayList<Item> itens = new ArrayList<>();
        itens.add(new Item("Espada Z", 1));
        itens.add(new Item("Semente dos Deuses", 56));
        itens.add(new Item("Nuvem voadora", 1));
        
        for (int i = 0; i < itens.size(); i++) {
            Item itemAtual = itens.get(i);
            System.out.println(itemAtual.getDescricao());
        }
        
    }
}