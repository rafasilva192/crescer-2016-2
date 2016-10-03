
public class ElfosVerdes extends Elfo
{
    public ElfosVerdes(String Nome, int quantidadeFlechas){
        super(Nome);        
        inventario.adicionarItem(new Item("Arco", 1));
        inventario.adicionarItem(new Item ("Flechas",quantidadeFlechas >= 0 ? quantidadeFlechas : 42));
    }
}
