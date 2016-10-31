using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CodingDojo
{
    public class Frase
    {
        public string Texto { get; private set; }
        public string Autor { get; private set; }

        public Frase(string texto, string autor)
        {
            if (texto.Contains("Nunes"))
                throw new ArgumentException("Palavra reservada!");

            this.Texto = texto;
            this.Autor = autor;
        }

        public Frase(string fraseComAutor) : 
            this(fraseComAutor.Split(';').First(),
                fraseComAutor.Split(';').Last())
        {  }

        public override string ToString()
        {
            //return string.Format("{0}; ({1})", Texto, Autor);
            return $"{Texto}; ({Autor})";
        }
    }
}
