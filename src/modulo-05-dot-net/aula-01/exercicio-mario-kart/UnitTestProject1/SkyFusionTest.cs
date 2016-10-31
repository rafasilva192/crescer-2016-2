using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using ExercicioMarioKart.Hibridos;
using ExercicioMarioKart;
using ExercicioMarioKart.Equipamentos;

namespace UnitTestProject1
{
    [TestClass]
    public class SkyFusionTest
    {
        [TestMethod]
        public void SkyFusionComPneuDeCouroDeDragaoENoobDa2DeBonus()
        {
            var skyFusion = new SkyFusion(
                new Corredor("Mario", NivelHabilidadeCorredor.Noob));

            skyFusion.Equipar(new PneuDeCouroDeDragao());

            var kart = new ClearKart(new Corredor("Luigi", NivelHabilidadeCorredor.Noob));
            kart.Equipar(skyFusion);

            Assert.AreEqual(8, kart.Velocidade);
        }

        [TestMethod]
        public void SkyFusionComUltraPackEMotorDeLavaEProfissionalDa8DeBonus()
        {
            var skyFusion = new SkyFusion(
                new Corredor("Mario", NivelHabilidadeCorredor.Profissional));

            skyFusion.Equipar(new UltraPack(new FogueteDePlutonio(1)));
            skyFusion.Equipar(new MotorABaseDeLava());

            var kart = new ClearKart(new Corredor("Luigi", NivelHabilidadeCorredor.Noob));
            kart.Equipar(skyFusion);

            Assert.AreEqual(16, kart.Velocidade);
        }
    }

    class ClearKart : Kart
    {
        public ClearKart(Corredor corredor) : base(corredor)
        {

        }
    }
}
