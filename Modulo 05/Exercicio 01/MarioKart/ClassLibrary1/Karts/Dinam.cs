using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Corredores;
using Corredores.Enums;

namespace MarioKart.Karts
{
    public class Dinam : Kart
    {
        public Dinam(Corredor piloto) : base(piloto)
        {
        }
        protected override int velocidade
        {
            get
            {
                switch (Piloto.Habilidade)
                {
                    case NivelDeHabilidade.Mediano:
                        return 5;
                    case NivelDeHabilidade.Profissional:
                        return 6 + Equipamentos.Count;
                    default:
                        return 3;
                }

            }
        }
    }
}
