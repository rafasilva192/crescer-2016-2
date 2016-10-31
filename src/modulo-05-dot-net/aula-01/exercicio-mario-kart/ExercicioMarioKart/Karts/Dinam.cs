using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ExercicioMarioKart.Karts
{
    public class Dinam : Kart
    {
        public Dinam(Corredor corredor) : base(corredor)
        {

        }

        protected override int BonusDoCorredor
        {
            get
            {
                return base.BonusDoCorredor * 2;
            }
        }
    }
}
