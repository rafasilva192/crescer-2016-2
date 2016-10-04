
public class ElfoNoturno extends Elfo
{
    public ElfoNoturno(String Nome, int quantidade){
        super(Nome, quantidade);
    }

    public void atirarFlecha(){
        if(status.equals(Status.VIVO)){
            int quantidade = getFlechas().getQuantidade();
            if(quantidade > 0){     
                getFlechas().setQuantidade(quantidade - 1);
                //O Elfo Não ira morrer pois ele perde 5% do total atual e não do máximo!!
                //vida = getVida() - (getVida())*5/100;
                this.vida = getVida() - 5;
                experiencia += 3;
            }
            if(getVida() <= 0){
                this.status = Status.MORTO;
            }
        }
    }

    public void atirarFlechaNoDwarf(Dwarf dwarf){
        if(getFlechas().getQuantidade() > 0){
            atirarFlecha();
            dwarf.perderVida();
        }
    }
}
