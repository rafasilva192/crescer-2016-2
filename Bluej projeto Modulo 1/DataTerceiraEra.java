
public class DataTerceiraEra
{
    private int dia;
    private int mes;
    private int ano;

    public DataTerceiraEra(int dia, int mes, int ano)
    {
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
    }

    public int getDia(){
        return dia;
    }

    public int getMes(){
        return mes;
    }

    public int getAno(){
        return ano;
    }

    public boolean ehBissexto(){
        double testBissext = ano;
        return testBissext%400 == 0 || testBissext % 4 == 0 && ano % 100!=0;
    }

}
