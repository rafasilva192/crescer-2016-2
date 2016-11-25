using LojaDeItens.Dominio.Configuracao;
using LojaDeItens.Dominio.ItemMagico;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LojaDeItens.Mock
{
    public class ItemMagicoRepositorioMock : IItemMagicoRepositorio
    {
        private static IList<ItemMagicoEntidade> itens = new List<ItemMagicoEntidade>()
        {
            new ItemMagicoEntidade()
            {
                Id = 1,
                Nome = "Cajado de Bola de Fogo",
                Preco = 5000.99m,
                Estoque = 4,
                DataCriacao = DateTime.Now,
                DataUltimaAtualizacao = DateTime.Now,
                Descricao = "Um cajado fodástico!",
                Raro = true
            },
            new ItemMagicoEntidade()
            {
                Id = 2,
                Nome = "Pena de Ganso",
                Preco = 2m,
                Estoque = 12312312,
                DataCriacao = DateTime.Now,
                DataUltimaAtualizacao = DateTime.Now,
                Descricao = "Gansos feroses!",
                Raro = false
            },
            new ItemMagicoEntidade()
            {
                Id = 3,
                Nome = "Poção de Cura",
                Preco = 100m,
                Estoque = 15,
                DataCriacao = DateTime.Now,
                DataUltimaAtualizacao = DateTime.Now,
                Descricao = "Poção que cura 10 de vida!",
                Raro = false
            },
            new ItemMagicoEntidade()
            {
                Id = 4,
                Nome = "Espada de Prata",
                Preco = 250m,
                Estoque = 3,
                DataCriacao = DateTime.Now,
                DataUltimaAtualizacao = DateTime.Now,
                Descricao = "Espada para matar lobisomens!",
                Raro = true
            },
            new ItemMagicoEntidade()
            {
                Id = 5,
                Nome = "Arco Mágico",
                Preco = 800m,
                Estoque = 2,
                DataCriacao = DateTime.Now,
                DataUltimaAtualizacao = DateTime.Now,
                Descricao = "Arco dos Altos Elfos!",
                Raro = false
            },
            new ItemMagicoEntidade()
            {
                Id = 6,
                Nome = "Espada MotherFucker",
                Preco = 1000m,
                Estoque = 1,
                DataCriacao = DateTime.Now,
                DataUltimaAtualizacao = DateTime.Now,
                Descricao = "Espada mega fodásticas!",
                Raro = true
            }
        };

        public void Atualizar(ItemMagicoEntidade item)
        {
            throw new NotImplementedException();
        }

        public ItemMagicoEntidade BuscarPorId(int id)
        {
            return itens.FirstOrDefault(i => i.Id == id);
        }

        public IList<ItemMagicoEntidade> BuscarPorNome(string nome)
        {
            throw new NotImplementedException();
        }

        public IList<ItemMagicoEntidade> BuscarPorRaridade(bool raro)
        {
            return itens.Where(i => i.Raro == raro).ToList();
        }

        public IList<ItemMagicoEntidade> BuscarTodos(Paginacao paginacao)
        {
            return itens.Skip(paginacao.PaginaDesejada * paginacao.QuantidadeDeItensPorPagina)
                        .Take(paginacao.QuantidadeDeItensPorPagina)
                        .ToList();
        }

        public void Criar(ItemMagicoEntidade item)
        {
            throw new NotImplementedException();
        }

        public void Excluir(ItemMagicoEntidade item)
        {
            ItemMagicoEntidade itemSalvo = itens.First(i => i.Id == item.Id);
            itens.Remove(itemSalvo);
        }
    }
}
