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
    public class DinamKartTest
    {
        [TestMethod]
        public void DinamComNoobSemEquipamentosTemVelocidade9()
        {
            var dinam = new Dinam(new Corredor("Mario", NivelHabilidadeCorredor.Noob));
            Assert.AreEqual(9, dinam.Velocidade);
        }

        [TestMethod]
        public void DinamComMotorABaseDeLavaECorredorProfissionalTemVelocidade20()
        {
            var dinam = new Dinam(new Corredor("Mario", NivelHabilidadeCorredor.Profissional));
            dinam.Equipar(new MotorABaseDeLava());
            Assert.AreEqual(20, dinam.Velocidade);
        }

        [TestMethod]
        public void DinamComFoguetePlutonio3EPneuCouroDragaoECorredorMedianoTemVelocidade18()
        {
            var dinam = new Dinam(new Corredor("Mario", NivelHabilidadeCorredor.Mediano));
            dinam.Equipar(new FogueteDePlutonio(3));
            dinam.Equipar(new PneuDeCouroDeDragao());

            Assert.AreEqual(18, dinam.Velocidade);
        }
    }
}
