using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MarioKart.Itens
{
    public class Motor_a_base_de_Lava : IEquipamentos
    {
        public int BonusDeVelocidade
        {
            get
            {
                return 3;
            }
        }
    }
}