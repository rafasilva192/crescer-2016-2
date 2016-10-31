using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using ExercicioMarioKart;
using ExercicioMarioKart.Equipamentos;

namespace UnitTestProject1
{
    [TestClass]
    public class PneuDeCouroDeDragaoTest
    {
        [TestMethod]
        public void PneuDeCouroDeDragaoTem2DeBonus()
        {
            var pneu = new PneuDeCouroDeDragao();
            Assert.AreEqual(2, pneu.Bonus);
        }
    }
}
