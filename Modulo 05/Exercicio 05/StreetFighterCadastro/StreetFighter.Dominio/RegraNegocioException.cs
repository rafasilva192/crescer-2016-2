using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace StreetFighter.Dominio
{
    class RegraNegocioException : Exception
    {
        public RegraNegocioException(string mensagem) : base(mensagem)
        {

        }
    }
}
