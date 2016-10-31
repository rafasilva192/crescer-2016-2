using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ExercicioMarioKart.Karts
{
    public class Light : Kart
    {
        public Light(Corredor corredor) : base(corredor)
        {

        }

        public override int Velocidade
        {
            get
            {
                return base.Velocidade + this.BonusPeloCorredor;
            }
        }

        private int BonusPeloCorredor
        {
            get
            {
                switch (this.Corredor.Habilidade)
                {
                    case NivelHabilidadeCorredor.Noob:
                        return 3;
                    case NivelHabilidadeCorredor.Mediano:
                        return 0;
                    case NivelHabilidadeCorredor.Profissional:
                        return -1;
                    default:
                        return 0;
                }
            }
        }
    }
}
