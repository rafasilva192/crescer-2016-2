
public class ElfoVerde extends Elfo
{
    public ElfoVerde(String Nome,int quantidade){
        super(Nome);
        inventario.getItens().set(0,new Item("Espada de aço valiriano",1));
        inventario.getItens().set(1,new Item("Arco e Flecha de Vidro", quantidade));

    }

    public void atirarFlecha(){
        int quantidade = getFlechas().getQuantidade();
        if(quantidade > 0){     
            getFlechas().setQuantidade(quantidade - 1);
            experiencia += 2;
        }
    }

    public void atirarFlechaNoDwarf(Dwarf dwarf){
        if(getFlechas().getQuantidade() > 0){
            atirarFlecha();
            dwarf.perderVida();
        }
    }
}
