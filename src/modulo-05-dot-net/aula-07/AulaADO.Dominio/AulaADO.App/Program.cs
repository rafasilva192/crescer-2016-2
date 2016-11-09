using AulaADO.Dominio;
using AulaADO.Repositorio;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace AulaADO.App
{
    class Program
    {
        static void Main(string[] args)
        {
            IMovieRepository movieRepository = new MovieRepositoryAdo();
            List<Movie> movies = movieRepository.FilterByTitle("Tit");

            //...
        }
    }
}
