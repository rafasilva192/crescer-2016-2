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
    }
}
