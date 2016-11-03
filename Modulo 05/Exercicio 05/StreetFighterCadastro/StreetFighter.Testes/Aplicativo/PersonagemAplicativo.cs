using Microsoft.VisualStudio.TestTools.UnitTesting;
using StreetFighter.Repositorio;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace StreetFighter.Testes.Aplicativo
{
    [TestClass]
    class PersonagemAplicativo
    {
        [TestMethod]
        public void SalvarPersonagemComId0DeveIncluir()
        {
            var repositoriofake = new PersonagemRepositorioFake();
        }
    }
}
