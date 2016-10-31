using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ExercicioMarioKart
{
    public class Corredor
    {
        // Os níveis de habilidade de um corredor são fixos.
        // Por padrão, não podemos deixar alguém escolher um nível
        // de habilidade que não exista. A melhor forma de fazer
        // isso é utilizando enuns, uma vez que eles bloqueiam
        // as opções que temos.
        public Corredor(string nome, NivelHabilidadeCorredor habilidade)
        {
            this.Nome = nome;
            this.Habilidade = habilidade;
        }

        // como o nome do corredor não muda mais, utilizamos private set.
        public string Nome { get; private set; }

        // não existe nenhuma regra para habilidade mudar, então 
        // vamos preferir por manter o set privado.
        public NivelHabilidadeCorredor Habilidade { get; private set; }
    }
}
