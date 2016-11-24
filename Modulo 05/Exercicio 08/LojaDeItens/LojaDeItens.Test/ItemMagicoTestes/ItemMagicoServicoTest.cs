using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using LojaDeItens.Dominio.ItemMagico;
using LojaDeItens.Test.Core;

namespace LojaDeItens.Test.ItemMagicoTestes
{
    [TestClass]
    public class ItemMagicoServicoTest
    {
        [TestMethod]
        [ExpectedException(typeof(ItemMagicoException))]
        public void ExcluirItemComIdZeroResultaEmException()
        {
            ItemMagicoServico itemMagicoServico = ServicoDeDependencia.CriarItemMagicoServico();
            itemMagicoServico.Excluir(0);
        }

        [TestMethod]
        public void BuscarItemDeId1ResultaEmCajadoDeBolaDeFogo()
        {
            ItemMagicoServico itemMagicoServico = ServicoDeDependencia.CriarItemMagicoServico();
            ItemMagicoEntidade item = itemMagicoServico.BuscarPorId(1);

            Assert.AreEqual(item.Nome, "Cajado de Bola de Fogo");
        }
        [TestMethod]
        [ExpectedException(typeof(ItemMagicoException))]
        public void SalvarItemComPrecoNegativoResultaEmException()
        {
            ItemMagicoServico itemMagicoServico = ServicoDeDependencia.CriarItemMagicoServico();
            ItemMagicoEntidade item = new ItemMagicoEntidade()
            {
                Nome = "Teste",
                Preco = -1,
                Estoque = 1
            };
            itemMagicoServico.Salvar(item);
        }

        [TestMethod]
        public void SalvarItemResultaEmId7()
        {
            ItemMagicoServico itemMagicoServico = ServicoDeDependencia.CriarItemMagicoServico();
            ItemMagicoEntidade item = new ItemMagicoEntidade()
            {
                Nome = "Cajado",
                Preco = 1,
                Estoque = 1
            };
            itemMagicoServico.Salvar(item);
            ItemMagicoEntidade itemSalvado = itemMagicoServico.BuscarPorId(7);
            Assert.AreEqual(itemSalvado.Nome, "Cajado");

        }

        [TestMethod]
        [ExpectedException(typeof(ItemMagicoException))]
        public void SalvarItemComEstoqueNegativoResultaEmException()
        {
            ItemMagicoServico itemMagicoServico = ServicoDeDependencia.CriarItemMagicoServico();
            ItemMagicoEntidade item = new ItemMagicoEntidade()
            {
                Nome = "Teste",
                Preco = 1,
                Estoque = -1
            };
            itemMagicoServico.Salvar(item);
        }

        [TestMethod]
        [ExpectedException(typeof(ItemMagicoException))]
        public void SalvarItemComNomeRepetidoResultaEmException()
        {
            ItemMagicoServico itemMagicoServico = ServicoDeDependencia.CriarItemMagicoServico();
            ItemMagicoEntidade item = new ItemMagicoEntidade()
            {
                Nome = "Cajado de Bola de Fogo",
                Preco = 1,
                Estoque = 1
            };
            itemMagicoServico.Salvar(item);
        }

        [TestMethod]
        [ExpectedException(typeof(ItemMagicoException))]
        public void EditarItemComNomeRepetidoResultaEmException()
        {
            ItemMagicoServico itemMagicoServico = ServicoDeDependencia.CriarItemMagicoServico();
            ItemMagicoEntidade item = new ItemMagicoEntidade()
            {
                Id = 2,
                Nome = "Cajado de Bola de Fogo",
                Preco = 1,
                Estoque = 1
            };
            itemMagicoServico.Salvar(item);
        }

        [TestMethod]
        [ExpectedException(typeof(ItemMagicoException))]
        public void EditarItemComPrecoNegativoResultaEmException()
        {
            ItemMagicoServico itemMagicoServico = ServicoDeDependencia.CriarItemMagicoServico();
            ItemMagicoEntidade item = new ItemMagicoEntidade()
            {
                Id = 2,
                Nome = "Cajado",
                Preco = -1,
                Estoque = 1
            };
            itemMagicoServico.Salvar(item);
        }

        [TestMethod]
        [ExpectedException(typeof(ItemMagicoException))]
        public void EditarItemComEstoqueNegativoResultaEmException()
        {
            ItemMagicoServico itemMagicoServico = ServicoDeDependencia.CriarItemMagicoServico();
            ItemMagicoEntidade item = new ItemMagicoEntidade()
            {
                Id = 2,
                Nome = "Cajado",
                Preco = 1,
                Estoque = -1
            };
            itemMagicoServico.Salvar(item);
        }

        [TestMethod]
        public void EditarItemDeveManterSeuIdEModificarSeusCampos()
        {
            ItemMagicoServico itemMagicoServico = ServicoDeDependencia.CriarItemMagicoServico();
            ItemMagicoEntidade item = new ItemMagicoEntidade()
            {
                Id = 1,
                Nome = "CajadoTeste",
                Preco = 1,
                Estoque = 1
            };
            itemMagicoServico.Salvar(item);
            ItemMagicoEntidade itemSalvado = itemMagicoServico.BuscarPorId(1);
            Assert.AreEqual(itemSalvado.Nome, "CajadoTeste");
        }
    }
}
