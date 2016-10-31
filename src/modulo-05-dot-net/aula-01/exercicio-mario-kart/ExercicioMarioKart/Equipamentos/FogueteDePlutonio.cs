using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ExercicioMarioKart.Equipamentos
{
    public class FogueteDePlutonio : IEquipamento
    {
        // Neste exemplo utilizamos uma variável privada para
        // armazenar o nível do foguete. Não precisa ser uma propriedade
        // como as outras mencionadas porque não há a necessidade
        // de expor ela.
        private int nivel;

        // Não utilizamos enuns no nível porque realmente esperamos um
        // número.
        // O mais correto dentro deste método é quando recebemos um
        // valor inválido, lançar uma Exception, mas ainda não tínhamos visto em aula =).
        public FogueteDePlutonio(int nivel = 2)
        {
            if (nivel < 1 || nivel > 5)
            {
                nivel = 2;
            }

            this.nivel = nivel;
        }

        public int Bonus
        {
            get
            {
                return nivel;
            }
        }
    }
}
