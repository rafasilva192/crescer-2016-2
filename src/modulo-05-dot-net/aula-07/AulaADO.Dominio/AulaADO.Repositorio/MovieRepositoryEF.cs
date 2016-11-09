using AulaADO.Dominio;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace AulaADO.Repositorio
{
    public class MovieRepositoryEF : IMovieRepository
    {
        public List<Movie> FilterByTitle(string title)
        {
            throw new NotImplementedException();
        }

        public Movie FindById(int id)
        {
            throw new NotImplementedException();
        }
    }
}
