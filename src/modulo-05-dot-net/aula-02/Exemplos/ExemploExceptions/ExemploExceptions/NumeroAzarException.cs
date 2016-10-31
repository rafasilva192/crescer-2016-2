using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ExemploExceptions
{
    public class NumeroAzarException : Exception
    {
        public NumeroAzarException(string message) : base(message) { }
    }
}
