using Loja.Dominio;
using Loja.Tests.Mocks;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Loja.Tests
{
    [TestClass]
    public class UsuarioServicoTest
    {
        [TestMethod]
        public void DeveAutenticarComSucesso()
        {
            var usuarioServico = new UsuarioServico(
                new UsuarioRepositorioMock(),
                new ServicoDeCriptografiaMock());

            Usuario usuario = usuarioServico.BuscarPorAutenticacao(
                "goku@bol.com", "abc123");

            Assert.IsNotNull(usuario);
        }
    }
}
