using Corredores.Enums;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Corredores
{


    public class Corredor
    {
        public string Nome { get; }
        public NivelDeHabilidade Habilidade;

        public Corredor(string nome, NivelDeHabilidade habilidade = NivelDeHabilidade.Noob)
        {
            this.Nome = nome;
            this.Habilidade = habilidade;
        }

    }
      
     
    
}
    


