using StreetFighter.Dominio;
using StreetFighter.Repositorio;
using StreetFighter.Infra;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using StreetFighter.RepositorioEntityFramework;

namespace StreetFighter.Aplicativo
{
    public class ServicoDeUsuario
    {
        private readonly IUsuarioRepositorio repositorio;

        public ServicoDeUsuario()
        {
            this.repositorio = new UsuarioRepositorioEntityFramework();
        }

        public ServicoDeUsuario(IUsuarioRepositorio repositorio)
        {
            this.repositorio = repositorio;
        }
        
        public Usuario BuscarUsuarioAutenticado(Usuario usuario)
        {
            Usuario usuarioEncontrado = repositorio.BuscarUsuario(usuario);
            return usuarioEncontrado;
        }

        public void CadastrarUsuario(Usuario usuario)
        {
           repositorio.SalvarUsuario(usuario);
        }
    }
}

