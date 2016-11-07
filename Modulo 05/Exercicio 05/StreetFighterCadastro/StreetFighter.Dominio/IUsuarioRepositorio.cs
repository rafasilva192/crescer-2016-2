using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace StreetFighter.Dominio
{
    public interface IUsuarioRepositorio
    {
        List<Usuario> ListarUsuarios(bool buscarSenha);

        void SalvarUsuario(Usuario usuario);

        Usuario BuscarUsuario(Usuario usuario);
    }
}
