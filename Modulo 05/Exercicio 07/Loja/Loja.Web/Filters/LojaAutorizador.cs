using Loja.Web.Models;
using Loja.Web.Servicos;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace Loja.Web.Filters
{
    public class LojaAutorizador : AuthorizeAttribute
    {
        protected override bool AuthorizeCore(HttpContextBase httpContext)
        {
            UsuarioLogadoModel usuario = ServicoDeAutenticacao.UsuarioLogado;

            if (usuario == null) return false;
            return true;
        }
    }
}