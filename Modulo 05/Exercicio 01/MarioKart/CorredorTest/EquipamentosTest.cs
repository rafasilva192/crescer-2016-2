using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using Corredores;
using Corredores.Enums;
using MarioKart.Itens;
using MarioKart.Karts;

namespace CorredorTest
{
    [TestClass]
    public class EquipamentosTest
    {
        [TestMethod]
        public void MotorABaseDeLavaTemBonusVelocidade3()
        {
            var motor = new MotorABaseDeLava();
            Assert.AreEqual(3, motor.BonusDeVelocidade);
        }
        [TestMethod]
        public void PneusDeCouroDeDragaoTemBonusVelocidade2()
        {
            var pneus = new PneusDeCouroDeDragao();
            Assert.AreEqual(2, pneus.BonusDeVelocidade);
        }
        [TestMethod]
        public void FoguetePlutonioNivel1TemBonusVelocidade1()
        {
            var foguete = new FogueteDePlutonio(1);
            Assert.AreEqual(1, foguete.BonusDeVelocidade);
        }
        [TestMethod]
        public void FoguetePlutonioNivel5TemBonusVelocidade5()
        {
            var foguete = new FogueteDePlutonio(5);
            Assert.AreEqual(5, foguete.BonusDeVelocidade);
        }
        [TestMethod]
        public void FoguetePlutonioSemNivelInformadoTemBonusVelocidade2()
        {
            var foguete = new FogueteDePlutonio();
            Assert.AreEqual(2, foguete.BonusDeVelocidade);
        }
        [TestMethod]
        public void FoguetePlutonioComNivelInvalidoInformadoTemBonusVelocidade2()
        {
            var foguete = new FogueteDePlutonio(69);
            Assert.AreEqual(2, foguete.BonusDeVelocidade);
        }
        [TestMethod]
        public void UltraPackComFoguetePlutonioNivel5TemBonusVelocidade6()
        {
            var pack = new UltraPack(new FogueteDePlutonio(5));
            Assert.AreEqual(6, pack.BonusDeVelocidade);
        }
        [TestMethod]
        public void UltraPackComUltraPackComFoguetePlutonioNivel5TemBonusVelocidade8()
        {
            var pack = new UltraPack(new UltraPack(new FogueteDePlutonio(5)));
            Assert.AreEqual(8, pack.BonusDeVelocidade);
        }
        [TestMethod]
        public void CorredorSoRecebeBonusDaUltraPack()
        {
            var piloto = new Corredor("Mario", NivelDeHabilidade.Profissional);
            var kart = new Kart(piloto);
            var pack = new UltraPack(new UltraPack(new FogueteDePlutonio(5)));
            kart.Equipar(pack);
            Assert.AreEqual(18, kart.Velocidade);
        }
    }
}
