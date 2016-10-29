using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MarioKart.Itens
{
    public class PneusDeCouroDeDragao : IEquipamentos
    {
        public int BonusDeVelocidade
        {
            get
            {
                return 2;
            }
        }
    }
}
