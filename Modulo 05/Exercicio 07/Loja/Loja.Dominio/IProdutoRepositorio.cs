using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Loja.Dominio
{
    public interface IProdutoRepositorio
    {
        void CadastrarProduto(Produto produto);

        void ExcluirProduto(Produto produto);

        void EditarProduto(Produto produto);

        List<Produto> ListarProduto(string filtro);
    }
}
