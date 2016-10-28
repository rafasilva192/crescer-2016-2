using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using Corredores;
using Corredores.Enums;

namespace CorredorTest
{
    [TestClass]
    public class CorredorTest
    {
        [TestMethod]
        public void CorredorNasceComNomeEHabilidadeNoob()
        {
            var corredor = new Corredor("Yoshi", NivelDeHabilidade.Noob);
            Assert.AreEqual("Yoshi", corredor.Nome);
            Assert.AreEqual(NivelDeHabilidade.Noob, corredor.Habilidade);
        }
        [TestMethod]
        public void CorredorNasceComNomeEHabilidadeMediano()
        {
            var corredor = new Corredor("Peach", NivelDeHabilidade.Mediano);
            Assert.AreEqual("Peach", corredor.Nome);
            Assert.AreEqual(NivelDeHabilidade.Mediano, corredor.Habilidade);
        }
        [TestMethod]
        public void CorredorNasceComNomeEHabilidadeProfissional()
        {
            var corredor = new Corredor("Mario", NivelDeHabilidade.Profissional);
            Assert.AreEqual("Mario", corredor.Nome);
            Assert.AreEqual(NivelDeHabilidade.Profissional, corredor.Habilidade);
        }
    }
}
