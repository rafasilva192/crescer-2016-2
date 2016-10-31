using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using ExercicioMarioKart.Karts;
using ExercicioMarioKart;
using ExercicioMarioKart.Equipamentos;

namespace UnitTestProject1
{
    [TestClass]
    public class LightKartTest
    {
        [TestMethod]
        public void LightComCorredorNoobGanha3DeVelocidade()
        {
            var light = new Light(new Corredor("Mario", NivelHabilidadeCorredor.Noob));
            Assert.AreEqual(9, light.Velocidade);
        }

        [TestMethod]
        public void LightComCorredorMedianoTemVelocidadeNormal()
        {
            var light = new Light(new Corredor("Mario", NivelHabilidadeCorredor.Mediano));
            Assert.AreEqual(8, light.Velocidade);
        }

        [TestMethod]
        public void LightComCorredorProfissionalPerde1DeVelocidade()
        {
            var light = new Light(new Corredor("Mario", NivelHabilidadeCorredor.Profissional));
            Assert.AreEqual(8, light.Velocidade);
        }

        [TestMethod]
        public void LightComCorredorMedianoEEquipamentoNaoEhAlterado()
        {
            var light = new Light(new Corredor("Mario", NivelHabilidadeCorredor.Mediano));
            light.Equipar(new PneuDeCouroDeDragao());
            Assert.AreEqual(10, light.Velocidade);
        }
    }
}
