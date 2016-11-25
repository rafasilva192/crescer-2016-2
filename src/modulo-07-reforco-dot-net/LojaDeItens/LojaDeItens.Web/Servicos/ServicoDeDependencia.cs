using LojaDeItens.Dominio.Configuracao;
using LojaDeItens.Dominio.ItemMagico;
using LojaDeItens.Mock;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace LojaDeItens.Web.Servicos
{
    public static class ServicoDeDependencia
    {
        public static ItemMagicoServico CriarItemMagicoServico()
        {
            return new ItemMagicoServico(
                    new ItemMagicoRepositorioMock(),
                    CriarServicoDeConfiguracao()
                );
        }

        public static IServicoDeConfiguracao CriarServicoDeConfiguracao()
        {
            return new ServicoDeConfiguracao();
        }
    }
}