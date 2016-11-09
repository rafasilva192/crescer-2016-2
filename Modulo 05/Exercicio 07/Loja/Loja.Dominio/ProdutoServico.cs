using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Loja.Dominio
{
    public class ProdutoServico
    {
        private IProdutoRepositorio produtoRepositorio;

        public ProdutoServico(IProdutoRepositorio produtoRepositorio)
        {
            this.produtoRepositorio = produtoRepositorio;
        }
        public IList<Produto> ListarOsProdutos(string filtro = "")
        {
            if (filtro == null) filtro = "";
            return produtoRepositorio.ListarProduto(filtro);
        }
        public void SalvarProduto(Produto produto)
        {
            produtoRepositorio.CadastrarProduto(produto);
        }
        public void RemoverProduto(Produto produto)
        {
            produtoRepositorio.ExcluirProduto(produto);
        }
        public void AlterarProduto(Produto produto)
        {
            produtoRepositorio.EditarProduto(produto);
        }
    }
}
