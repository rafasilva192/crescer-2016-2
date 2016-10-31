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
    public class MotorABaseDeLavaTest
    {
        [TestMethod]
        public void MotorABaseDeLavaTemBonus3()
        {
            var motor = new MotorABaseDeLava();
            Assert.AreEqual(3, motor.Bonus);
        }
    }
}
