﻿using StreetFighterCadastro.Models;
using StreetFighterCadastro.Services;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace StreetFighterCadastro.Filters
{
    public class SFAutorizador : AuthorizeAttribute
    {
        protected override bool AuthorizeCore(HttpContextBase httpContext)
        {
            UsuarioLogadoModel usuario = ServicoDeAutenticacao.UsuarioLogado;

            if (usuario == null) return false;

            //string[] permissoesRequidas = this.Roles.Split(',')
            //                                        .Where(p => !String.IsNullOrEmpty(p))
            //                                        .ToArray();

            //foreach (string permissao in permissoesRequidas)
            //{
            //    if (!usuario.Permissoes.Any(p => p.Equals(permissao)))
            //    {
            //        return false;
            //    }
            //}

            return true;
        }
    }
}