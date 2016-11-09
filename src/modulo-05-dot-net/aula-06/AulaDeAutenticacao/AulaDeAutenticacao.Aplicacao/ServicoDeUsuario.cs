using AulaDeAutenticacao.Dominio;
using AulaDeAutenticacao.Infra;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace AulaDeAutenticacao.Aplicacao
{
    public class ServicoDeUsuario
    {
        private static Usuario[] _usuarios =
        {
            new Usuario()
            {
                Nome = "joao",
                Senha = "f6a47bad775bde570f264d85871d9ae8",
                Permissoes = new string[] { "CHINELO" }
            }
        };

        public static Usuario BuscarUsuarioAutenticado(string nome, string senha)
        {
            Usuario usuarioEncontrado = _usuarios.FirstOrDefault(
                usuario => usuario.Nome.Equals(nome));

            string senhaDeComparacao =
                ServicoDeCriptografia.ConverterParaMD5($"{nome}_$_{senha}");

            if (usuarioEncontrado != null && usuarioEncontrado.Senha.Equals(senhaDeComparacao))
            {
                return usuarioEncontrado;
            }

            return null;
        }
    }
}
