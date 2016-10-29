using MarioKart.Itens;
using MarioKart.Karts;
using System;
using System.Collections.Generic;
using System.Linq;
using Corredores;
using Corredores.Enums;

namespace MarioKart.Karts
{
    public class SkyFusion : Kart, IEquipamentos
    {
        public SkyFusion(Corredor piloto) : base(piloto)
        {
        }

        public override int Velocidade
        {
            get
            {
                return BonusDeVelocidade;
            }
        }

        public int BonusDeVelocidade
        {
            get
            {
                int bonusVelocidade = (BonusCorredor + velocidadeDoKart + Equipamentos.Count());
                bool bonusDeVelocidadeMaiorQue12 = bonusVelocidade > 12;
                if (bonusDeVelocidadeMaiorQue12) bonusVelocidade += 5;
                return bonusVelocidade;
            }
        }
        private int BonusCorredor {
            get
            {
                switch (Piloto.Habilidade)
                {
                    case NivelDeHabilidade.Mediano:
                        return 2;
                    case NivelDeHabilidade.Profissional:
                        return 3;
                    default:
                        return 1;
                }
            }
        }
    }
}
