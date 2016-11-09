using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace AulaADO.Dominio
{
    public interface IMovieRepository
    {
        Movie FindById(int id);
        List<Movie> FilterByTitle(string title);

        void Save(Movie movie);
    }
}
