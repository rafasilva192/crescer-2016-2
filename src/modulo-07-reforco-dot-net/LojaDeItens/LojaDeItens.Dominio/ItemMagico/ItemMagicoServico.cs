using LojaDeItens.Dominio.Configuracao;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LojaDeItens.Dominio.ItemMagico
{
    public class ItemMagicoServico
    {
        private IItemMagicoRepositorio itemMagicoRepositorio;
        private IServicoDeConfiguracao servicoDeConfiguracao;

        public ItemMagicoServico(IItemMagicoRepositorio itemMagicoRepositorio, IServicoDeConfiguracao servicoDeConfiguracao)
        {
            this.itemMagicoRepositorio = itemMagicoRepositorio;
            this.servicoDeConfiguracao = servicoDeConfiguracao;
        }

        public IList<ItemMagicoEntidade> BuscarTodos(int pagina)
        {
            int quantidadeDeItensPorPagina = this.servicoDeConfiguracao.QuantidadeDeItensPorPagina;

            var paginacao = new Paginacao()
            {
                PaginaDesejada = pagina,
                QuantidadeDeItensPorPagina = quantidadeDeItensPorPagina
            };

            return this.itemMagicoRepositorio.BuscarTodos(paginacao);
        }

        public IList<ItemMagicoEntidade> BuscarPorRaridade(bool raro)
        {
            return this.itemMagicoRepositorio.BuscarPorRaridade(raro);
        }

        public ItemMagicoEntidade BuscarPorId(int id)
        {
            if(id > 0)
            {
                return this.itemMagicoRepositorio.BuscarPorId(id);
            }

            return null;
        }

        public void Excluir(int id)
        {
            ItemMagicoEntidade item = this.BuscarPorId(id);

            if(item == null)
            {
                throw new ItemMagicoException("Item não encontrado.");
            }

            this.itemMagicoRepositorio.Excluir(item);
        }

        public void Salvar(ItemMagicoEntidade item)
        {
            ValidarItemMagico(item);

            if (item.Id > 0)
            {
                ItemMagicoEntidade itemSalvo = this.itemMagicoRepositorio.BuscarPorId(item.Id);

                if(itemSalvo == null)
                {
                    throw new ItemMagicoException("O item a ser atualizado não existe.");
                }

                itemSalvo.DataUltimaAtualizacao = DateTime.Now;
                itemSalvo.Nome = item.Nome;
                itemSalvo.Raro = item.Raro;
                //...
                this.itemMagicoRepositorio.Atualizar(itemSalvo);
            }
            else
            {
                item.DataCriacao = item.DataUltimaAtualizacao = DateTime.Now;
                this.itemMagicoRepositorio.Criar(item);
            }
        }

        private void ValidarItemMagico(ItemMagicoEntidade item)
        {
            ValidarEstoque(item);
            ValidarNomeDuplicado(item);
        }

        private void ValidarNomeDuplicado(ItemMagicoEntidade item)
        {
            IList<ItemMagicoEntidade> itensSalvos = this.itemMagicoRepositorio
                                                       .BuscarPorNome(item.Nome);

            if(itensSalvos != null)
            {
                bool existeItemComMesmoNome = itensSalvos.Any(
                    i => i.Nome.Equals(item.Nome) && i.Id != item.Id);

                if (existeItemComMesmoNome)
                {
                    throw new ItemMagicoException("Já existe um item com este nome.");
                }
            }

        }

        private void ValidarEstoque(ItemMagicoEntidade item)
        {
            if (item.Estoque < 0)
            {
                throw new ItemMagicoException("O estoque do item não pode ser menor que 0.");
            }
        }
    }
}
