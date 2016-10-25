public class IrishDwarf extends Dwarf {

    public IrishDwarf() {
        this(null, new DataTerceiraEra(1,1,1));
    }

    public IrishDwarf(String nome, DataTerceiraEra dataNascimento) {
        super(nome, dataNascimento);
    }
    
    public void tentarSorte() {
        boolean temSorte = getNumeroSorte() == -3333;
        if (temSorte) {
            inventario.aumentarUnidadesProporcionalQuantidadePorItem();
        }
    }
}
