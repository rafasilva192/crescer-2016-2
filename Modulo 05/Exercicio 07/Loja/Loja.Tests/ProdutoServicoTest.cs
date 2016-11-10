using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using Loja.Dominio;
using Loja.Tests.Mocks;

namespace Loja.Tests
{
    [TestClass]
    public class ProdutoServicoTest
    {
        [TestMethod]
        public void SalvandoUmProdutoListaDeveTerDoisProdutos()
        {
            var produto = new Produto(2, "Cha", 5);
            var produtoServico = new ProdutoServico(
                new ProdutoRepositorioMock());
            produtoServico.SalvarProduto(produto);
            var lista = produtoServico.ListarOsProdutos();
            Assert.AreEqual(2, lista.Count);
        }

        [TestMethod]
        public void AlterandoUmProdutoListaDeveTerUmProdutoChamadoCha()
        {
            var produto = new Produto(1, "Cha", 5);
            var produtoServico = new ProdutoServico(
                new ProdutoRepositorioMock());
            produtoServico.AlterarProduto(produto);
            var lista = produtoServico.ListarOsProdutos();           
            Assert.AreEqual("Cha", lista[0].Nome);
            Assert.AreEqual(1, lista.Count);
        }

        [TestMethod]
        public void RemovendoUmProdutoListaDeveTarVazia()
        {
            var produto = new Produto(1, "Leite", 3);
            var produtoServico = new ProdutoServico(
                new ProdutoRepositorioMock());
            produtoServico.RemoverProduto(produto);
            var lista = produtoServico.ListarOsProdutos();
            Assert.AreEqual(0, lista.Count);
        }
    }
}
