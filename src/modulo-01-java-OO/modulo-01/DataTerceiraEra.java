public class DataTerceiraEra {
    private int dia, mes, ano;
    
    public DataTerceiraEra(int dia, int mes, int ano) {
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
    }
    
    public int getDia() {
        return this.dia;
    }
    
    public int getMes() {
        return this.mes;
    }
    
    public int getAno() {
        return this.ano;
    }
    
    public boolean ehBissexto() {
        // Regra: https://pt.wikipedia.org/wiki/Ano_bissexto
        // São bissextos todos os anos múltiplos de 400, p.ex: 1600, 2000, 2400, 2800...
        // São bissextos todos os múltiplos de 4, exceto se for múltiplo de 100 mas não de 400, p.ex: 1996, 2004, 2008, 2012, 2016…
        // Não são bissextos todos os demais anos.
        return this.ano % 400 == 0 || this.ano % 4 == 0 && this.ano % 100 != 0;
    }
}