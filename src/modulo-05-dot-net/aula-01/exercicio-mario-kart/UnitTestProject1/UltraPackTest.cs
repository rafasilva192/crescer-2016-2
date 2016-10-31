using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using ExercicioMarioKart.Equipamentos;
using ExercicioMarioKart;

namespace UnitTestProject1
{
    [TestClass]
    public class UltraPackTest
    {
        [TestMethod]
        public void UltraPackComPneuDeCouroDeDragaoTemBonus3()
        {
            var ultraPack = new UltraPack(new PneuDeCouroDeDragao());
            Assert.AreEqual(3, ultraPack.Bonus);
        }

        [TestMethod]
        public void UltraPackComMotorDeLavaTemBonus4()
        {
            var ultraPack = new UltraPack(new MotorABaseDeLava());
            Assert.AreEqual(4, ultraPack.Bonus);
        }

        [TestMethod]
        public void UltraPackComFogueteDePlutonioNivel5Bonus6()
        {
            var ultraPack = new UltraPack(new FogueteDePlutonio(5));
            Assert.AreEqual(6, ultraPack.Bonus);
        }

        [TestMethod]
        public void UltraPackDuploComFogueteDePlutonioNivel5Bonus7()
        {
            var ultraPack = new UltraPack(
                    new UltraPack(
                            new FogueteDePlutonio(5)
                    )
                );
            Assert.AreEqual(8, ultraPack.Bonus);
        }
    }
}
