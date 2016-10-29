using MarioKart.Karts;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Corredores;
using MarioKart.Itens;

namespace MarioKart.Karts
{
    public class Sonnar : Kart
    {
        public Sonnar(Corredor piloto) : base(piloto)
        {
        }

        protected override int velocidade
        {
            get
            {
                bool sonnarComItem = this.Equipamentos.Any();

                if (sonnarComItem)
                {
                    return 2;
                }
                return 0;
            }
        }
    }
}
