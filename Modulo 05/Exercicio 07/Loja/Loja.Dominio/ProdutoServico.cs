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
            VerificarNomeEValor(produto);
            produtoRepositorio.CadastrarProduto(produto);
        }
        public void RemoverProduto(Produto produto)
        {
            produtoRepositorio.ExcluirProduto(produto);
        }
        public void AlterarProduto(Produto produto)
        {
            VerificarNomeEValor(produto);
            produtoRepositorio.EditarProduto(produto);
        }
        public void VerificarNomeEValor(Produto produto)
        {
            bool nomeMenorQueTresCharacteres = produto.Nome.Length <= 2;
            if (produtoRepositorio.ProdutoComMesmoNome(produto))
            {
                throw new RegraDeNegocioException("Já tem um produto cadastrado com esse nome");
            }
            else if (nomeMenorQueTresCharacteres)
            {
                throw new RegraDeNegocioException("O nome do produto precisa ter 3 ou mais caracteres");
            }
            else if (produto.Valor == 0)
            {
                throw new RegraDeNegocioException("O valor do produto não pode ser zero");
            }
        }
    }
}
