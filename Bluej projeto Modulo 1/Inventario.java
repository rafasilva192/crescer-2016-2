import java.util.ArrayList;

public class Inventario
{
    ArrayList<Item> itens = new ArrayList<>();

    public void adicionarItem(Item descricao, Item quantidade){
       itens.add(new Item(descricao, quantidade));
    }
}
