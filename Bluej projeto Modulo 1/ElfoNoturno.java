
public class ElfoNoturno extends Elfo
{
    public ElfoNoturno(String Nome, int quantidade){
        super(Nome, quantidade);
    }

    public void atirarFlecha(){
        if(status.equals(Status.VIVO)){
            int quantidade = getFlechas().getQuantidade();
            if(quantidade > 0){     
                super.atirarFlecha();
                //O Elfo Não ira morrer pois ele perde 5% do total atual
                //vida = getVida() - (getVida())*5/100;
                this.vida -= getVida()*5/100;
                experiencia += 2;
            }
            if((int)this.vida == 0){
                this.status = Status.MORTO;
            }
        }
    }
    

    public void atirarFlecha(Dwarf dwarf){
        if(getFlechas().getQuantidade() > 0){
            atirarFlecha();
            dwarf.perderVida();
        }
    }
}
