using StreetFighter.Dominio;
using StreetFighter.Infra;
using System;
using System.Collections.Generic;
using System.Configuration;
using System.Data;
using System.Data.SqlClient;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace StreetFighter.Repositorio
{
    public class UsuarioRepositorioADO : IUsuarioRepositorio
    {
        public Usuario BuscarUsuario(Usuario usuario)
        {
            Usuario usuarioEncontrado = null;
            string senhaFinal = ServicoDeCriptografia.ConverterParaMD5($"{usuario.Nome}_$_{usuario.Senha}");
            string connectionString = ConfigurationManager.ConnectionStrings["Usuario"].ConnectionString;
            using (var connection = new SqlConnection(connectionString))
            {
                connection.Open();

                string sql = "SELECT Nome,Senha FROM Usuario WHERE Nome Like @param1 and Senha Like @param2";

                var command = new SqlCommand(sql, connection);
                command.Parameters.Add(new SqlParameter("param1", usuario.Nome));
                command.Parameters.Add(new SqlParameter("param2", senhaFinal));

                SqlDataReader reader = command.ExecuteReader();
                
                if (reader.Read())
                {
                    usuarioEncontrado = new Usuario(reader["Nome"].ToString(), reader["Senha"].ToString());
                }
                connection.Close();
            }
                return usuarioEncontrado;
        }

        public List<Usuario> ListarUsuarios(bool buscarSenha)
        {
            throw new NotImplementedException();
        }

        public void SalvarUsuario(Usuario usuario)
        {
            string senhaFinal = ServicoDeCriptografia.ConverterParaMD5($"{usuario.Nome}_$_{usuario.Senha}");
            string connectionString = ConfigurationManager.ConnectionStrings["Usuario"].ConnectionString;
            using (var connection = new SqlConnection(connectionString))
            {
                connection.Open();

                string sql = "INSERT INTO Usuario(Nome,Senha)VALUES(@param_nome,@param_senha)";

                var command = new SqlCommand(sql, connection);
                command.CommandType = CommandType.Text;
                command.Parameters.AddWithValue("param_nome", usuario.Nome);
                command.Parameters.AddWithValue("param_senha", senhaFinal);
                
                command.ExecuteNonQuery();

                connection.Close();
            }
        }
        
    }
}
