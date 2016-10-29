using Corredores;
using Corredores.Enums;
using MarioKart.Itens;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MarioKart.Karts
{
    public class Kart
    {

             public Kart(Corredor piloto)
        {
            this.Piloto = piloto;
            this.Equipamentos = new List<IEquipamentos>();
        }

        public List<IEquipamentos> Equipamentos { get; private set; }
        public Corredor Piloto { get; private set; }
        public virtual int Velocidade
        {
            get
            {
                return velocidadeDoKart + velocidade;
            }
        }


        public void Equipar(IEquipamentos equipamento)
        {
            this.Equipamentos.Add(equipamento);
        }

        protected virtual int velocidade
        {
            get
            {
                return 3;
            }
        }

        protected int velocidadeDoKart
        {
            get
            {
                int velocidadePiloto = (int)Piloto.Habilidade;
                bool pilotoEhProfissional = velocidadePiloto == 6;
                int bonusVelocidade = velocidadePiloto;

                foreach (IEquipamentos item in this.Equipamentos)
                {
                    if (pilotoEhProfissional) bonusVelocidade++;
                    bonusVelocidade += item.BonusDeVelocidade;

                }
                return bonusVelocidade;
            }
        }
    }
}
