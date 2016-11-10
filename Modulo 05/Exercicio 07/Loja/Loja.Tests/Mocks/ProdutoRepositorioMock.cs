using Loja.Dominio;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Loja.Tests.Mocks
{
    class ProdutoRepositorioMock : IProdutoRepositorio
    {
        private IList<Produto> produtos;

        public ProdutoRepositorioMock()
        {
            this.produtos = new List<Produto>();
            this.produtos.Add(new Produto()
            {
                Id = 1,
                Nome = "Leite",
                Valor = 3
            });
        }

        public void CadastrarProduto(Produto produto)
        {
            this.produtos.Add(produto);
        }

        public void EditarProduto(Produto produto)
        {
            foreach (var item in produtos)
            {
                if(item.Id == produto.Id)
                {
                    produtos.Remove(item);
                    produtos.Add(produto);
                    break;
                }
            }
        }

        public void ExcluirProduto(Produto produto)
        {
            foreach (var item in produtos)
            {
                if (item.Id == produto.Id && item.Nome.Equals(produto.Nome))
                {
                    produtos.Remove(item);
                    break;
                }
            }
        }

        public List<Produto> ListarProduto(string filtro)
        {
            return produtos.ToList();
        }

        public bool ProdutoComMesmoNome(Produto produto)
        {
            return false;
        }
        
    }
}
