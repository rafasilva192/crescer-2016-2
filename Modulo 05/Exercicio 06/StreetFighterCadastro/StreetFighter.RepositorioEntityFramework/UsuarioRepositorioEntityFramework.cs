using StreetFighter.Dominio;
using StreetFighter.Infra;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace StreetFighter.RepositorioEntityFramework
{
    public class UsuarioRepositorioEntityFramework : IUsuarioRepositorio
    {
        public Usuario BuscarUsuario(Usuario usuario)
        {
            using (var connection = new ContextoBancoDeDados())
            {
                string senhaFinal = ServicoDeCriptografia.ConverterParaMD5($"{usuario.Nome}_$_{usuario.Senha}");

                var usuarioBuscado = connection.Usuario.Where(p => p.Nome.Equals(usuario.Nome) && p.Senha.Equals(senhaFinal)).FirstOrDefault();
                
                if (usuarioBuscado != null)
                {
                    return usuarioBuscado;
                }
                
                return null;
            }
        }

        public List<Usuario> ListarUsuarios(bool buscarSenha)
        {
            throw new NotImplementedException();
        }

        public void SalvarUsuario(Usuario usuario)
        {
            string senhaFinal = ServicoDeCriptografia.ConverterParaMD5($"{usuario.Nome}_$_{usuario.Senha}");
            using (var connection = new ContextoBancoDeDados())
            {
                var usuarioBuscado = connection.Usuario.Where(p => p.Nome.Equals(usuario.Nome)).FirstOrDefault();
                if (usuarioBuscado == null)
                {
                    usuarioBuscado = new Usuario(usuario.Nome, senhaFinal);
                    connection.Usuario.Add(usuarioBuscado);
                    connection.SaveChanges();
                }
            }
        }
    }
}
