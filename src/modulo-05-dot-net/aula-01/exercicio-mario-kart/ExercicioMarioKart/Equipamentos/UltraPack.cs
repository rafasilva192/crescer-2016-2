using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ExercicioMarioKart.Equipamentos
{
    public class UltraPack : IEquipamento
    {
        private IEquipamento equipamento;

        public UltraPack(IEquipamento equipamento)
        {
            this.equipamento = equipamento;
        }

        public int Bonus
        {
            get
            {
                // Esta é uma forma de fazer o arredondamento.
                // Existe uma história legal entre converter double para int.
                // Explico para vocês em aula uma hora =).
                double bonusModificado = Convert.ToDouble(this.equipamento.Bonus) * 1.2;
                return Convert.ToInt32(Math.Ceiling(bonusModificado));
            }
        }
    }
}
