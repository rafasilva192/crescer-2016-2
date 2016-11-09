using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace AulaDeAutenticacao.Models
{
    public class UsuarioLogadoModel
    {
        public UsuarioLogadoModel(string nome, string[] permissoes = null)
        {
            this.Nome = nome;
            this.Permissoes = permissoes;
        }

        public string Nome { get; private set; }
        public string[] Permissoes { get; private set; }
    }
}