using StreetFighter.Dominio;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace StreetFighter.Repositorio
{
    internal static class PersonagemExtension
    {
        internal static string ParaString(this Personagem personagem)
        {
            return $"{personagem.Id};{personagem.Nome};{personagem.Origem}";
        }

        internal static string ParaString(this Personagem personagem, int idAutal)
        {
            return $"{idAutal};{personagem.Nome};{personagem.Origem}";
        }

        internal static Personagem ParaPersonagem(this string personagem)
        {
            var propriedadesPersonagem = personagem.Split(';');

            return new Personagem(
                Convert.ToInt32(propriedadesPersonagem.First()),
                propriedadesPersonagem.ElementAt(1),
                propriedadesPersonagem.Last()
            );
        }
    }
}
