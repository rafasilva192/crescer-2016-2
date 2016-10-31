using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ExercicioMarioKart.Equipamentos
{
    public class MotorABaseDeLava : IEquipamento
    {
        public int Bonus
        {
            get
            {
                return 3;
            }
        }
    }
}
