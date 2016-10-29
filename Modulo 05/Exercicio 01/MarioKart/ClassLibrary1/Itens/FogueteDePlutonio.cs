using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MarioKart.Itens
{
    public class FogueteDePlutonio : IEquipamentos
    {
        public FogueteDePlutonio(int nivel = 0)
        {
            bool nivelValido = (1 <= nivel)&&(nivel <= 5); 
            if(nivelValido) this.Nivel = nivel;
            else this.Nivel = 2;
        }
        public int BonusDeVelocidade
        {
            get
            {
                return this.Nivel;
            }
        }
        private int Nivel { get; set; }
    }
}
