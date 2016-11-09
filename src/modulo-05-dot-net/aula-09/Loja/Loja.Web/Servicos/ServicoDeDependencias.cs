using Loja.Dominio;
using Loja.Infraestrutura;
using Loja.Repositorio;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Loja.Web.Servicos
{
    public class ServicoDeDependencias
    {
        public static UsuarioServico MontarUsuarioServico()
        {
            UsuarioServico usuarioServico =
                new UsuarioServico(
                    new UsuarioRepositorio(), 
                    new ServicoDeCriptografia());

            return usuarioServico;
        }
    }
}