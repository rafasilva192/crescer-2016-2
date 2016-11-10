using Loja.Dominio;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Loja.Repositorio
{
    public class ProdutoRepositorio : IProdutoRepositorio
    {
        public void CadastrarProduto(Produto produto)
        {
            using (var contexto = new ContextoDeDados())
            {
                contexto.Produto.Add(produto);
                contexto.SaveChanges();
            }
        }

        public void EditarProduto(Produto produto)
        {
            using (var contexto = new ContextoDeDados())
            {
                var produtoAchado = AcharPorId(produto, contexto);
                if (produtoAchado != null)
                {
                    contexto.Entry(produtoAchado).CurrentValues.SetValues(produto);
                    contexto.SaveChanges();
                }
            }
        }

        public void ExcluirProduto(Produto produto)
        {
            using (var contexto = new ContextoDeDados())
            {
                var produtoAchado = AcharPorId(produto, contexto);
                if (produtoAchado != null)
                {
                    contexto.Produto.Remove(produtoAchado);
                    contexto.SaveChanges();
                }
            }
        }

        public List<Produto> ListarProduto(string filtro)
        {
            using (var contexto = new ContextoDeDados())
            {
                return contexto.Produto.Where(p => p.Nome.Contains(filtro)).OrderBy(p => p.Nome).ToList();
            }
        }

        public bool ProdutoComMesmoNome(Produto produto)
        {
            using (var contexto = new ContextoDeDados())
            {
                return Convert.ToBoolean(contexto.Produto.Where(p => p.Nome.Equals(produto.Nome)).First());
            }
        }

        private Produto AcharPorId(Produto produto, ContextoDeDados contexto)
        {
            return contexto.Produto.Where(p => p.Id == produto.Id).FirstOrDefault();
        }
    }
}
