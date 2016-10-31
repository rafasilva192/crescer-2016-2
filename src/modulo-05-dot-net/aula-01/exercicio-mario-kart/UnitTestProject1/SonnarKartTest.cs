using ExercicioMarioKart;
using ExercicioMarioKart.Equipamentos;
using ExercicioMarioKart.Karts;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace UnitTestProject1
{
    [TestClass]
    public class SonnarKartTest
    {
        [TestMethod]
        public void SonnarSemEquipamentosTemVelocidadeNormal()
        {
            var sonnar = new Sonnar(new Corredor("Mario", NivelHabilidadeCorredor.Noob));
            Assert.AreEqual(6, sonnar.Velocidade);
        }

        [TestMethod]
        public void SonnarComPneuDeCouroDeDragaoGanha2DeVelocidade()
        {
            var sonnar = new Sonnar(new Corredor("Mario", NivelHabilidadeCorredor.Noob));
            sonnar.Equipar(new PneuDeCouroDeDragao());
            Assert.AreEqual(10, sonnar.Velocidade);
        }
    }
}
