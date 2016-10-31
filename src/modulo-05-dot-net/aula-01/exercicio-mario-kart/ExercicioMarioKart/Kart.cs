using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ExercicioMarioKart
{
    // Temos vários tipos de kart,
    // por isso, esta classe será apenas o modelo (abstract).
    public abstract class Kart
    {
        // criamos esta constante para abstrairmos o que chamamos
        // de "números mágicos".
        // Ver um "3" perdido no código é ruim. Com a constante,
        // estamos dando um nome para nosso número, que agora está
        // muito melhor explicado =)
        private const int VELOCIDADE_BASE = 3;

        // O kart tem um corredor e uma lista de equipamentos.
        public Kart(Corredor corredor)
        {
            this.Corredor = corredor;
            this.Equipamentos = new List<IEquipamento>();
        }

        // Este é um exemplo de construtor que chama outro construtor.
        // Aqui passamos o Corredor e uma Lista de Equipamentos.
        // Perceba o :this(corredor) -> Significa que este construtor
        // vai chamar outro construtor, mas que receba somente o corredor
        // como parâmetro.
        public Kart(Corredor corredor, List<IEquipamento> equipamentos)
            : this(corredor)
        {
            this.Equipamentos = equipamentos;
        }

        // A velocidade deve ser uma propriedade somente get
        // por que ela não possui valor real a ser armazenado
        // apenas computa várias valores diversos.
        public virtual int Velocidade
        {
            get
            {
                return VELOCIDADE_BASE +
                    this.BonusDoCorredor +
                    this.BonusPorEquipamentos;
            }
        }
        
        public Corredor Corredor { get; private set; }

        protected IList<IEquipamento> Equipamentos { get; private set; }

        public void Equipar(IEquipamento equipamento)
        {
            this.Equipamentos.Add(equipamento);
        }

        // O bônus por equipamentos também é algo computado,
        // então pode ser uma propriedade somente get.
        private int BonusPorEquipamentos
        {
            get
            {
                int bonus = 0;

                foreach (IEquipamento equipamento in this.Equipamentos)
                {
                    bonus += equipamento.Bonus;
                }

                return bonus;
            }
        }

        // O bônus por corredor também é algo computado, mas
        // alguns carts calculam ele de forma diferente, como
        // o caso do Dinam. Então deixamos que ele sobrescreva
        // utilizando protected virtual.
        protected virtual int BonusDoCorredor
        {
            get
            {
                switch (this.Corredor.Habilidade)
                {
                    // usamos números fixos aqui ao invés de atribuir valores
                    // ao enum diretamente para evitar que, se o enum mudar os valores,
                    // este código passe a funcionar de forma errônea.
                    case NivelHabilidadeCorredor.Noob:
                        return 3;
                    case NivelHabilidadeCorredor.Mediano:
                        return 5;
                    case NivelHabilidadeCorredor.Profissional:
                        return 6 + this.Equipamentos.Count;
                    default:
                        return 3;
                }
            }
        }
    }
}
