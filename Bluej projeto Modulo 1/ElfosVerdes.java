
public class ElfosVerdes extends Elfo
{
    public ElfosVerdes(String Nome,int quantidade){
        super(Nome);
        inventario.getItens().set(0,new Item("Espada de aço valiriano",1));
        inventario.getItens().set(1,new Item("Arco e Flecha de Vidro", quantidade));

    }

    public void atirarFlecha(){
        if(getFlechas().getQuantidade() > 0){     
            inventario.removendoUnidades("Arco e Flecha de Vidro", 1);
            experiencia += 2;
        }
    }

}
