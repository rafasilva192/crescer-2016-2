using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ExercicioMarioKart.Hibridos
{
    public class SkyFusion : Kart, IEquipamento
    {
        public SkyFusion(Corredor corredor) : base(corredor)
        {

        }

        public int Bonus
        {
            get
            {
                int bonus = BonusComoEquipamentoPeloCorredor + BonusComoEquipamentoPorEquipamento;

                if(this.Velocidade > 12)
                {
                    bonus += 5;
                }

                return bonus;
            }
        }

        private int BonusComoEquipamentoPorEquipamento
        {
            get
            {
                return this.Equipamentos.Count;
            }
        }

        private int BonusComoEquipamentoPeloCorredor
        {
            get
            {
                switch (this.Corredor.Habilidade)
                {
                    case NivelHabilidadeCorredor.Noob:
                        return 1;
                    case NivelHabilidadeCorredor.Mediano:
                        return 2;
                    case NivelHabilidadeCorredor.Profissional:
                        return 3;
                    default:
                        return 1;
                }
            }
        }
    }
}
