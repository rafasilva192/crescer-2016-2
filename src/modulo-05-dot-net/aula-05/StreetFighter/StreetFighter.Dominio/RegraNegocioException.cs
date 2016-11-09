using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace StreetFighter.Dominio
{
    public class RegraNegocioException : Exception
    {
        public RegraNegocioException(string mensgagem) : base(mensgagem)
        { }
    }
}
