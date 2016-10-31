using ExercicioMarioKart;
using ExercicioMarioKart.Equipamentos;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace UnitTestProject1
{
    [TestClass]
    public class FogueteDePlutonioTest
    {
        [TestMethod]
        public void FogueteNivel1Tem1DeBonus()
        {
            var foguete = new FogueteDePlutonio(1);
            Assert.AreEqual(1, foguete.Bonus);
        }

        [TestMethod]
        public void FogueteNivel2Tem2DeBonus()
        {
            var foguete = new FogueteDePlutonio(2);
            Assert.AreEqual(2, foguete.Bonus);
        }

        [TestMethod]
        public void FogueteNivel7Tem2DeBonus()
        {
            var foguete = new FogueteDePlutonio(7);
            Assert.AreEqual(2, foguete.Bonus);
        }

        [TestMethod]
        public void FogueteNivel0Tem2DeBonus()
        {
            var foguete = new FogueteDePlutonio(0);
            Assert.AreEqual(2, foguete.Bonus);
        }
    }
}
