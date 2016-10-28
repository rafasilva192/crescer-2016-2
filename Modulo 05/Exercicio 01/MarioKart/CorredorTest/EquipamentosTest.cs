using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using Corredores;
using Corredores.Enums;
using MarioKart.Itens;

namespace CorredorTest
{
    [TestClass]
    public class EquipamentosTest
    {
        [TestMethod]
        public void MotorABaseDeLavaTemBonusVelocidade3()
        {
            var motor = new Motor_a_base_de_Lava();
            Assert.AreEqual(3, motor.BonusDeVelocidade);
        }
        [TestMethod]
        public void PneusDeCouroDeDragaoTemBonusVelocidade2()
        {
            var pneus = new Pneus_de_Couro_de_Dragão();
            Assert.AreEqual(2, pneus.BonusDeVelocidade);
        }
    }
}
