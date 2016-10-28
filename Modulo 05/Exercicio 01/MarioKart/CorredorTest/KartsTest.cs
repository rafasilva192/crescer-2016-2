using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using Corredores;
using Corredores.Enums;
using MarioKart.Karts;
using MarioKart.Itens;

namespace CorredorTest
{
    [TestClass]
    public class KartsTest
    {
        [TestMethod]
        public void KartComPilotoNoobTem6DeVelocidade()
        {
            var piloto = new Corredor("Mario", NivelDeHabilidade.Noob);
            var kart = new Kart(piloto);
            Assert.AreEqual(6, kart.Velocidade);
            Assert.AreEqual(piloto, kart.Piloto);
        }
        [TestMethod]
        public void KartComPilotoMedianoEMotorTem11DeVelocidade()
        {
            var piloto = new Corredor("Mario", NivelDeHabilidade.Mediano);
            var kart = new Kart(piloto);
            kart.Equipar(new Motor_a_base_de_Lava());
            Assert.AreEqual(11, kart.Velocidade);
            Assert.AreEqual(piloto, kart.Piloto);
        }
        [TestMethod]
        public void KartComPilotoProfissionalERodasDeDragaoTem12DeVelocidade()
        {
            var piloto = new Corredor("Mario", NivelDeHabilidade.Profissional);
            var kart = new Kart(piloto);
            kart.Equipar(new Pneus_de_Couro_de_Dragão());
            Assert.AreEqual(12, kart.Velocidade);
            Assert.AreEqual(piloto, kart.Piloto);
        }
        [TestMethod]
        public void KartComPilotoProfissionalComRodasDeDragaoEMotorTem16DeVelocidade()
        {
            var piloto = new Corredor("Mario", NivelDeHabilidade.Profissional);
            var kart = new Kart(piloto);
            kart.Equipar(new Pneus_de_Couro_de_Dragão());
            kart.Equipar(new Motor_a_base_de_Lava());
            Assert.AreEqual(16, kart.Velocidade);
            Assert.AreEqual(piloto, kart.Piloto);
        }
    }
}
