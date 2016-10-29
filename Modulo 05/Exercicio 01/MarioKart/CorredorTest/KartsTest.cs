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
            kart.Equipar(new MotorABaseDeLava());
            Assert.AreEqual(11, kart.Velocidade);
            Assert.AreEqual(piloto, kart.Piloto);
        }
        [TestMethod]
        public void KartComPilotoProfissionalERodasDeDragaoTem12DeVelocidade()
        {
            var piloto = new Corredor("Mario", NivelDeHabilidade.Profissional);
            var kart = new Kart(piloto);
            kart.Equipar(new PneusDeCouroDeDragao());
            Assert.AreEqual(12, kart.Velocidade);
            Assert.AreEqual(piloto, kart.Piloto);
        }
        [TestMethod]
        public void KartComPilotoProfissionalComRodasDeDragaoEMotorTem16DeVelocidade()
        {
            var piloto = new Corredor("Mario", NivelDeHabilidade.Profissional);
            var kart = new Kart(piloto);
            kart.Equipar(new PneusDeCouroDeDragao());
            kart.Equipar(new MotorABaseDeLava());
            Assert.AreEqual(16, kart.Velocidade);
            Assert.AreEqual(piloto, kart.Piloto);
        }
        [TestMethod]
        public void SonnarComPilotoNoobTem3DeVelocidade()
        {
            var piloto = new Corredor("Mario");
            var kart = new Sonnar(piloto);
            Assert.AreEqual(3, kart.Velocidade);
        }
        [TestMethod]
        public void SonnarComPilotoNoobComRodasDeDragaoTem7DeVelocidade()
        {
            var piloto = new Corredor("Mario");
            var kart = new Sonnar(piloto);
            kart.Equipar(new PneusDeCouroDeDragao());
            Assert.AreEqual(7, kart.Velocidade);
        }
        [TestMethod]
        public void SonnarComPilotoProfissionalComRodasDeDragaoEMotorDeLavaTem15DeVelocidade()
        {
            var piloto = new Corredor("Mario", NivelDeHabilidade.Profissional);
            var kart = new Sonnar(piloto);
            kart.Equipar(new PneusDeCouroDeDragao());
            kart.Equipar(new MotorABaseDeLava());
            Assert.AreEqual(15, kart.Velocidade);
        }
        [TestMethod]
        public void LightComPilotoNoobTem6DeVelocidade()
        {
            var piloto = new Corredor("Mario");
            var kart = new Light(piloto);
            Assert.AreEqual(6, kart.Velocidade);
        }
        [TestMethod]
        public void LightComPilotoProfissionalEMotorDeLavaTem6DeVelocidade()
        {
            var piloto = new Corredor("Mario", NivelDeHabilidade.Profissional);
            var kart = new Light(piloto);
            kart.Equipar(new MotorABaseDeLava());
            Assert.AreEqual(9, kart.Velocidade);
        }
        [TestMethod]
        public void LightComPilotoMedianoTem5DeVelocidade()
        {
            var piloto = new Corredor("Mario", NivelDeHabilidade.Mediano);
            var kart = new Light(piloto);
            Assert.AreEqual(5, kart.Velocidade);
        }
        [TestMethod]
        public void DinamComPilotoNoobTem6DeVelocidade()
        {
            var piloto = new Corredor("Mario");
            var kart = new Dinam(piloto);
            Assert.AreEqual(6, kart.Velocidade);
        }
        [TestMethod]
        public void DinamComPilotoProfissionalComRodasDeDragaoEMotorDeLavaTem23DeVelocidade()
        {
            var piloto = new Corredor("Mario", NivelDeHabilidade.Profissional);
            var kart = new Dinam(piloto);
            kart.Equipar(new PneusDeCouroDeDragao());
            kart.Equipar(new MotorABaseDeLava());
            Assert.AreEqual(21, kart.Velocidade);
        }
        [TestMethod]
        public void DinamComPilotoMedianoTem10DeVelocidade()
        {
            var piloto = new Corredor("Mario", NivelDeHabilidade.Mediano);
            var kart = new Dinam(piloto);
            Assert.AreEqual(10, kart.Velocidade);
        }
        [TestMethod]
        public void SkyFusionComPilotoProfissionalTem9DeVelocidade()
        {
            var piloto = new Corredor("Mario", NivelDeHabilidade.Profissional);
            var kart = new SkyFusion(piloto);
            Assert.AreEqual(9, kart.Velocidade);
        }
        [TestMethod]
        public void SkyFusionComPilotoProfissionalEFogueteNivel5Tem21DeVelocidade()
        {
            var piloto = new Corredor("Mario", NivelDeHabilidade.Profissional);
            var kart = new SkyFusion(piloto);
            var foguete = new FogueteDePlutonio(5);
            kart.Equipar(foguete);
            Assert.AreEqual(21, kart.Velocidade);
        }
        [TestMethod]
        public void KartComPilotoProfissioanlComSkyFusionComPilotoProfissionalEFogueteNivel5Tem21DeVelocidade()
        {
            var piloto = new Corredor("Mario", NivelDeHabilidade.Profissional);
            var kart = new SkyFusion(piloto);
            var foguete = new FogueteDePlutonio(5);
            kart.Equipar(foguete);
            var kartComFusion = new Kart(piloto);
            kartComFusion.Equipar(kart);
            Assert.AreEqual(31, kartComFusion.Velocidade);
        }
        [TestMethod]
        public void DinamCom4FusionsECadaFusionComVariosItensDistintosECorredoresDeHabilidadesDiferentes()
        {
            var pilotopro = new Corredor("Mario", NivelDeHabilidade.Profissional);
            var pilotomedi = new Corredor("Mama Luigi", NivelDeHabilidade.Mediano);
            var pilotonoob = new Corredor("Weege");

            var fusion1 = new SkyFusion(pilotopro);
            fusion1.Equipar(new FogueteDePlutonio(5));
            fusion1.Equipar(new PneusDeCouroDeDragao());
            Assert.AreEqual(25, fusion1.Velocidade);

            var fusion2 = new SkyFusion(pilotomedi);
            fusion2.Equipar(new UltraPack(new UltraPack(new FogueteDePlutonio(5))));
            Assert.AreEqual(21, fusion2.Velocidade);

            var fusion3 = new SkyFusion(pilotonoob);
            fusion3.Equipar(new PneusDeCouroDeDragao());
            fusion3.Equipar(new MotorABaseDeLava());
            Assert.AreEqual(11, fusion3.Velocidade);

            var fusion4 = new SkyFusion(pilotopro);
            fusion4.Equipar(new PneusDeCouroDeDragao());
            fusion4.Equipar(new PneusDeCouroDeDragao());
            fusion4.Equipar(new PneusDeCouroDeDragao());
            fusion4.Equipar(new PneusDeCouroDeDragao());
            Assert.AreEqual(30, fusion4.Velocidade);

            var dinam = new Dinam(pilotopro);
            dinam.Equipar(fusion1);
            dinam.Equipar(fusion2);
            dinam.Equipar(fusion3);
            dinam.Equipar(fusion4);
            Assert.AreEqual(107, dinam.Velocidade);
        }
    }
}
