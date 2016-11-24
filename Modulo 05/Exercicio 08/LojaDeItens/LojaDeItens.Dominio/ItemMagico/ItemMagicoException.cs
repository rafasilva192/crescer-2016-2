using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LojaDeItens.Dominio.ItemMagico
{
    public class ItemMagicoException : Exception
    {
        public ItemMagicoException(string mensagem) : base(mensagem)
        {

        }
    }
}
