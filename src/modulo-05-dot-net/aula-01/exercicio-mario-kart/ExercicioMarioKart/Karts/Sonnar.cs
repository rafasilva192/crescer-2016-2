using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ExercicioMarioKart.Karts
{
    public class Sonnar : Kart
    {
        public Sonnar(Corredor corredor) : base(corredor)
        {

        }

        public override int Velocidade
        {
            get
            {
                return base.Velocidade + this.BonusPorContagemDeEquipamentos;
            }
        }

        private int BonusPorContagemDeEquipamentos
        {
            get
            {
                return this.Equipamentos.Count > 0 ? 2 : 0;
            }
        }
    }
}
