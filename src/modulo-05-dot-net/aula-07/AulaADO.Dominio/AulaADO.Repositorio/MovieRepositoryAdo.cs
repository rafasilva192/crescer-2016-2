using AulaADO.Dominio;
using System;
using System.Collections.Generic;
using System.Configuration;
using System.Data.SqlClient;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Transactions;

namespace AulaADO.Repositorio
{
    public class MovieRepositoryAdo : IMovieRepository
    {
        public Movie FindById(int id)
        {
            string connectionString = 
                ConfigurationManager.ConnectionStrings["MovieConnection"]
                                    .ConnectionString;

            Movie result = null;

            using (var connection = new SqlConnection(connectionString))
            {
                connection.Open();

                string sql = "SELECT * FROM Movies WHERE Id = " + id;

                var command = new SqlCommand(sql, connection);

                SqlDataReader reader = command.ExecuteReader();

                if (reader.Read())
                {
                    result = ConvertReaderToMovie(reader);
                }
                
                connection.Close();
            }
            
            return result;
        }

        public List<Movie> FilterByTitle(string title)
        {
            string connectionString =
                ConfigurationManager.ConnectionStrings["MovieConnection"]
                                    .ConnectionString;

            var result = new List<Movie>();

            using (var connection = new SqlConnection(connectionString))
            {
                connection.Open();

                string sql = $"SELECT * FROM Movies WHERE Title LIKE @param_title";

                var command = new SqlCommand(sql, connection);
                command.Parameters.Add(new SqlParameter("param_title", title));

                SqlDataReader reader = command.ExecuteReader();

                while (reader.Read())
                {
                    Movie found = ConvertReaderToMovie(reader);

                    result.Add(found);
                }

                connection.Close();
            }

            return result;
        }

        private Movie ConvertReaderToMovie(SqlDataReader reader)
        {
            int idRow = Convert.ToInt32(reader["Id"]);
            string titleRow = reader["Title"].ToString();

            var movie = new Movie(
                id: idRow,
                title: titleRow
                );

            return movie;
        }

        public void Save(Movie movie)
        {
            string connectionString =
                ConfigurationManager.ConnectionStrings["MovieConnection"]
                                    .ConnectionString;

            var result = new List<Movie>();

            using (var transaction = new TransactionScope(TransactionScopeOption.Required))
            using (var connection = new SqlConnection(connectionString))
            {
                try
                {
                    connection.Open();
                    string sql = "";
                    var parameters = new List<SqlParameter>();
                    
                    if (movie.Id > 0)
                    {
                        sql = $"UPDATE Movies SET Title=@param_title WHERE Id = @param_id";
                        parameters.Add(new SqlParameter("param_title", movie.Title));
                        parameters.Add(new SqlParameter("param_id", movie.Id));
                    }
                    else
                    {
                        sql = $"INSERT INTO Movies (Title) values (@param_title)";
                        parameters.Add(new SqlParameter("param_title", movie.Title));
                    }

                    var command = new SqlCommand(sql, connection);
                    foreach (SqlParameter param in parameters)
                    {
                        command.Parameters.Add(param);
                    }
                    command.ExecuteNonQuery();
                    transaction.Complete();
                }
                catch (Exception ex)
                {
                    //... 
                }
                finally
                {
                    connection.Close();
                }
            }
        }
    }
}
