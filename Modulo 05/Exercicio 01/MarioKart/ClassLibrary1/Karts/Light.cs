using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Corredores;
using Corredores.Enums;

namespace MarioKart.Karts
{
    public class Light : Kart
    {
        public Light(Corredor piloto) : base(piloto)
        {
        }
        protected override int velocidade
        {
            get
            {
                switch (Piloto.Habilidade)
                {
                    case NivelDeHabilidade.Noob:
                        return 3;
                    case NivelDeHabilidade.Profissional:
                        return -1;
                    default:
                        return 0;
                }
                
            }
        }
    }
}
