using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Loja.Web.Models
{
    public class UsuarioLogadoModel
    {
        public UsuarioLogadoModel(string email)
        {
            this.Email = email;
        }

        public string Email { get; private set; }
    }
}