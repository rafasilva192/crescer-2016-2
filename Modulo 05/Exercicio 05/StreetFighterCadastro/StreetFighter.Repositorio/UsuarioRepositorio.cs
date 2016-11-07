using StreetFighter.Dominio;
using StreetFighter.Infra;
using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace StreetFighter.Repositorio
{


    public class UsuarioRepositorio : IUsuarioRepositorio
    {
        //private string usuariopath = @"C:\Users\Rafael\crescer-2016-2\Modulo 05\Exercicio 05\StreetFighterCadastro\StreetFighterCadastro\Content\Usuarios.txt";
        private string usuariopath = @"C:\Users\RAFAEL.SILVA\crescer-2016-2\Modulo 05\Exercicio 05\StreetFighterCadastro\StreetFighterCadastro\Content\Usuarios.txt";
        public List<Usuario> ListarUsuarios(bool buscarSenha = false)
        {
            var lista = new List<Usuario>();
            using (var fileStream = File.OpenRead(usuariopath))
            using (var streamReader = new StreamReader(fileStream, Encoding.UTF8, true))
            {
                String linhaAtual;
                while ((linhaAtual = streamReader.ReadLine()) != null)
                {
                    string[] Usuarios = linhaAtual.Split(';');
                    if (buscarSenha)
                    {
                        lista.Add(
                           new Usuario
                           (
                               Usuarios[0],
                               Usuarios[1]
                           ));
                    }
                    else
                    {
                        lista.Add(
                            new Usuario
                            (
                                Usuarios[0]
                            ));
                    }
                }
                streamReader.Dispose();
            }
            return lista;
        }

        public void SalvarUsuario(Usuario usuario)
        {
            var lista = ListarUsuarios();
            if (new FileInfo(usuariopath).Length != 0)
            {
                foreach (Usuario pessoa in lista)
                {
                    if (usuario.Nome.Equals(pessoa)) throw new RegraNegocioException("Já possui um usuario com esse nome");
                }
            }
            string senhaFinal = ServicoDeCriptografia.ConverterParaMD5($"{usuario.Nome}_$_{usuario.Senha}");

            var formatacao = String.Format(
           $"{ usuario.Nome };{ senhaFinal };"
       );

            File.AppendAllText(usuariopath, formatacao + Environment.NewLine);
        }


        public Usuario BuscarUsuario(Usuario usuario)
        {
            bool buscarSenhas = true;
            var lista = ListarUsuarios(buscarSenhas);
            string senhaFinal = ServicoDeCriptografia.ConverterParaMD5($"{usuario.Nome}_$_{usuario.Senha}");
            if (new FileInfo(usuariopath).Length != 0)
            {
                foreach (Usuario pessoa in lista)
                {
                    if (usuario.Nome.Equals(pessoa.Nome))
                    {
                        if (senhaFinal.Equals(pessoa.Senha))
                        {
                            var usuarioEncontrado = new Usuario(pessoa.Nome, pessoa.Senha);
                            return usuarioEncontrado;
                        }
                    }
                }
            }
            return null;
        }
    }
}
