using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using StreetFighter.Dominio;
using System.Configuration;
using System.Data;
using System.Data.SqlClient;

namespace StreetFighter.Repositorio
{
    public class PersonagemRepositorioADO : IPersonagemRepositorio
    {
        public void DeletarPersonagem(Personagem personagem)
        {
            {
                string connectionString = ConfigurationManager.ConnectionStrings["Personagem"].ConnectionString;
                using (var connection = new SqlConnection(connectionString))
                {
                    connection.Open();

                    string sql = "DELETE FROM Personagem WHERE Id = @param_Id";

                    var command = new SqlCommand(sql, connection);
                    command.Parameters.AddWithValue("param_Id", personagem.Id);
                    command.ExecuteNonQuery();

                    connection.Close();
                }
            }
        }

        public void EditarPersonagem(Personagem personagem)
        {
            string connectionString = ConfigurationManager.ConnectionStrings["Personagem"].ConnectionString;
            using (var connection = new SqlConnection(connectionString))
            {
                connection.Open();

                string sql = "UPDATE Personagem SET Nome = @param_nome,DataNascimento = @param_datanasc,Origem = @param_origem,Altura = @param_altura,Peso = @param_peso,GolpeEspecial = @param_golpe,PersonagemOculto = @param_personagemoculto,Imagem = @param_imagem WHERE Id = @param_id";


                var command = new SqlCommand(sql, connection);
                command.CommandType = CommandType.Text;
                command.Parameters.AddWithValue("param_nome", personagem.Nome);
                command.Parameters.AddWithValue("param_datanasc", personagem.DataNascimento);
                command.Parameters.AddWithValue("param_origem", personagem.Origem);
                command.Parameters.AddWithValue("param_altura", personagem.Altura);
                command.Parameters.AddWithValue("param_peso", personagem.Peso);
                command.Parameters.AddWithValue("param_golpe", personagem.GolpesEspeciais);
                command.Parameters.AddWithValue("param_personagemoculto", personagem.PersonagemOculto);
                command.Parameters.AddWithValue("param_imagem", personagem.Imagem == null ? "" : personagem.Imagem);
                command.Parameters.AddWithValue("param_id", personagem.Id);

                command.ExecuteNonQuery();

                connection.Close();
            }
        }

        public void IncluirPersonagem(Personagem personagem)
        {
            string connectionString = ConfigurationManager.ConnectionStrings["Personagem"].ConnectionString;
            using (var connection = new SqlConnection(connectionString))
            {
                connection.Open();

                string sql = "INSERT INTO Personagem(Nome,DataNascimento,Origem,Altura,Peso,GolpeEspecial,PersonagemOculto,Imagem)"+
                    "VALUES(@param_nome,@param_datanasc,@param_origem,@param_altura,@param_peso,@param_golpe,@param_personagemoculto,@param_imagem)";


                var command = new SqlCommand(sql, connection);
                command.CommandType = CommandType.Text;
                command.Parameters.AddWithValue("param_nome", personagem.Nome);
                command.Parameters.AddWithValue("param_datanasc", personagem.DataNascimento);
                command.Parameters.AddWithValue("param_origem", personagem.Origem);
                command.Parameters.AddWithValue("param_altura", personagem.Altura);
                command.Parameters.AddWithValue("param_peso", personagem.Peso);
                command.Parameters.AddWithValue("param_golpe", personagem.GolpesEspeciais);
                command.Parameters.AddWithValue("param_personagemoculto", personagem.PersonagemOculto);
                command.Parameters.AddWithValue("param_imagem", personagem.Imagem==null?"":personagem.Imagem);
                
                command.ExecuteNonQuery();

                connection.Close();
            }
        }

        public List<Personagem> ListarPersonagens(string filtro = "%")
        {
            if (filtro == "" || filtro == null) filtro = "%";
            Personagem personagemEncontrado = null;
            var lista = new List<Personagem>();
            string connectionString = ConfigurationManager.ConnectionStrings["Personagem"].ConnectionString;
            using (var connection = new SqlConnection(connectionString))
            {
                connection.Open();
                var sql = "SELECT * FROM Personagem WHERE UPPER(Nome) Like @param1";

                var command = new SqlCommand(sql, connection);
                command.Parameters.Add(new SqlParameter("param1", $"%{filtro.ToUpperInvariant()}%"));

                SqlDataReader reader = command.ExecuteReader();

                while (reader.Read())
                {
                    personagemEncontrado = achouPersonagem(reader);
                    lista.Add(personagemEncontrado);
                }
                connection.Close();
            }
            lista.Sort((x, y) => string.Compare(x.Nome, y.Nome));
            return lista;
        }

        private Personagem achouPersonagem(SqlDataReader reader)
        {
            return new Personagem(
                        Convert.ToInt32(reader["Id"]),        //Id
                        reader["Nome"].ToString(),                   //Nome
                        Convert.ToDateTime(reader["DataNascimento"]),   //DataNascimento   
                        Convert.ToInt32(reader["Altura"]),        //Altura
                        Convert.ToDecimal(reader["Peso"]),    //Peso  
                        reader["Origem"].ToString(),                   //Origem
                        reader["GolpeEspecial"].ToString(),                   //GolpesEspeciais
                        Convert.ToBoolean(reader["PersonagemOculto"]),       //Oculto?
                        reader["Imagem"].ToString()
                );
        }
    }
}
