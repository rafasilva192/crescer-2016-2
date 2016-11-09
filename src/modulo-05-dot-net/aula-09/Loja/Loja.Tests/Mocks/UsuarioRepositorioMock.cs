using Loja.Dominio;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Loja.Tests.Mocks
{
    public class UsuarioRepositorioMock : IUsuarioRepositorio
    {
        private IList<Usuario> usuarios;

        public UsuarioRepositorioMock()
        {
            this.usuarios = new List<Usuario>();
            this.usuarios.Add(new Usuario()
            {
                Id = 1,
                Email = "goku@bol.com",
                Senha = "abc123"
            });
        }

        public Usuario BuscarPorEmail(string email)
        {
            return this.usuarios.FirstOrDefault(u => u.Email.Equals(email));
        }
    }
}
