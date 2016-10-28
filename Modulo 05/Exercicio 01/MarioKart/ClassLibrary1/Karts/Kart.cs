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
        private int velocidade;

        public Kart(Corredor piloto)
        {
            this.Piloto = piloto;
            this.Equipamentos = new List<IEquipamentos>();
            this.velocidade = 3;
        }

        public List<IEquipamentos> Equipamentos { get;  set; }
        public Corredor Piloto { get; private set; }
        public int Velocidade
        {
            get
            {
                int velocidadePiloto = (int)Piloto.Habilidade;
                bool pilotoEhProfissional = velocidadePiloto == 6;
                velocidade += velocidadeDosEquipamentos(pilotoEhProfissional);
                return velocidade + velocidadePiloto;
            }
            private set
            {
                this.velocidade = value;
            }
        }

        public void Equipar(IEquipamentos equipamento)
        {
            this.Equipamentos.Add(equipamento);
        }
  

        private int velocidadeDosEquipamentos(bool pilotoEhProfissional)
        {
            int bonusVelocidade = 0;
            foreach (IEquipamentos item in this.Equipamentos)
            {
                if (pilotoEhProfissional) bonusVelocidade++;
                 bonusVelocidade += item.BonusDeVelocidade;
            }
            return bonusVelocidade;
        }
    }
}
