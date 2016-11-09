using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace AulaADO.Dominio
{
    public class Movie
    {
        public Movie(string title)
        {
            this.Title = title;
        }

        public Movie(int id, string title) : this(title)
        {
            this.Id = id;
        }

        public int Id { get; private set; }
        public string Title { get; private set; }
    }
}
