using StreetFighter.Dominio;
using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace StreetFighter.Repositorio
{
    public class PersonagemRepositorio : IPersonagemRepositorio
    {
        public List<Personagem> ListarPersonagens(string filtro)
        {
            throw new NotImplementedException();
        }

        public void IncluirPersonagem(Personagem personagem)
        { 
            foreach (var prop in personagem.GetType().GetProperties())
            {
                File.AppendAllText(@"C:\Users\RAFAEL.SILVA\crescer-2016-2\Modulo 05\Exercicio 04\StreetFighterCadastro\StreetFighterCadastro\Content\StreetFighterPersonagens.txt", prop.GetValue(personagem).ToString() + ";");
            }
        }

        public void DeletarPersonagem(Personagem personagem)
        {

        }

        public void EditarPersonagem(Personagem personagem)
        {

        }
    }
}
