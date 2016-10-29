using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MarioKart.Itens
{
    public class UltraPack : IEquipamentos
    {
        public UltraPack(IEquipamentos equipamento)
        {
            this.Equipamento = equipamento;
        }

        public int BonusDeVelocidade
        {
            get
            {
                double bonusVelocidade = Equipamento.BonusDeVelocidade + Math.Ceiling(Equipamento.BonusDeVelocidade*0.2);
                return (int)bonusVelocidade;
            }
        }
        private IEquipamentos Equipamento { get; set; }
    }
}
