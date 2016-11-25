using LojaDeItens.Dominio.Configuracao;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LojaDeItens.Mock
{
    public class ServicoDeConfiguracaoMock : IServicoDeConfiguracao
    {
        public int QuantidadeDeItensPorPagina
        {
            get
            {
                return 2;
            }
        }
    }
}
