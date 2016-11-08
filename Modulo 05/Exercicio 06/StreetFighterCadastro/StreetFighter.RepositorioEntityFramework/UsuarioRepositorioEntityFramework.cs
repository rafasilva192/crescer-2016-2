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
                var personagens = connection.Usuario.Where(p => p.Nome.Contains(usuario.Nome)).FirstOrDefault();
                string senhaFinal = ServicoDeCriptografia.ConverterParaMD5($"{usuario.Nome}_$_{usuario.Senha}");
                if (personagens !=null && senhaFinal == personagens.Senha)
                {
                    return personagens;
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
                var usuarioCadastrar = new Usuario(usuario.Nome, senhaFinal);
                connection.Usuario.Add(usuarioCadastrar);
                connection.SaveChanges();
            }
        }
    }
}
