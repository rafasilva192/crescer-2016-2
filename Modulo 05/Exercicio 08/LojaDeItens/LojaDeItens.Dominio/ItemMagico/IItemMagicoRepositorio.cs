using LojaDeItens.Dominio.Configuracao;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LojaDeItens.Dominio.ItemMagico
{
    public interface IItemMagicoRepositorio
    {
        IList<ItemMagicoEntidade> BuscarPorNome(string nome);
        void Atualizar(ItemMagicoEntidade item);
        void Criar(ItemMagicoEntidade item);
        ItemMagicoEntidade BuscarPorId(int id);
        IList<ItemMagicoEntidade> BuscarTodos(Paginacao paginacao);
        IList<ItemMagicoEntidade> BuscarPorRaridade(bool raro);

        void Excluir(ItemMagicoEntidade item);
    }
}
