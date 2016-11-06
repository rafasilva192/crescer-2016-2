using StreetFighter.Dominio;
using StreetFighter.Repositorio;
using StreetFighter.Infra;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace StreetFighter.Aplicativo
{
    public class ServicoDeUsuario
    {
        private readonly IPersonagemRepositorio repositorio;

        public ServicoDeUsuario()
        {
            this.repositorio = new PersonagemRepositorio();
        }

        public ServicoDeUsuario(IPersonagemRepositorio repositorio)
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

