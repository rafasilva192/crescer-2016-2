using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace AulaDeAutenticacao.Dominio
{
    public class Usuario
    {
        public string Nome { get; set; }
        public string Senha { get; set; }

        public string[] Permissoes { get; set; }
    }
}
