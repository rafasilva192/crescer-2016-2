using System.Collections.Generic;

namespace Marvelflix.Dominio
{
    public class Heroi
    {
        public Heroi()
        {
            Comics = new List<Comic>();
        }

        public int Id { get; set; }
        public string Nome { get; set; }
        public string UrlThumbnail { get; set; }
        public ICollection<Comic> Comics { get; set; }
    }
}
