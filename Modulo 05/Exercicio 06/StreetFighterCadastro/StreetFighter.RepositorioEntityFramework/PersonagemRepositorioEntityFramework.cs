using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using StreetFighter.Dominio;
using System.Configuration;
using System.Data;
using System.Data.SqlClient;
using StreetFighter.RepositorioEntityFramework;

namespace StreetFighter.Repositorio
{
    public class PersonagemRepositorioEntityFramework : IPersonagemRepositorio
    {
        public void DeletarPersonagem(Personagem personagem)
        {
               using (var connection = new ContextoBancoDeDados())
                {
                    var itemToRemove = connection.Personagem.SingleOrDefault(x => x.Id == personagem.Id); //returns a single item.

                    if (itemToRemove != null)
                    {
                        connection.Personagem.Remove(itemToRemove);
                        connection.SaveChanges();
                    }
                }
        }

        public void EditarPersonagem(Personagem personagem)
        {
            using (var connection = new ContextoBancoDeDados())
            {
                var resultado = connection.Personagem.SingleOrDefault(p => p.Id == personagem.Id);
                if (resultado != null)
                {
                    connection.Entry(resultado).CurrentValues.SetValues(personagem);
                    connection.SaveChanges();
                }
            }
        }

        public void IncluirPersonagem(Personagem personagem)
        {
            using (var connection = new ContextoBancoDeDados())
            {
                connection.Personagem.Add(personagem);
                connection.SaveChanges();
            }
        }

        public List<Personagem> ListarPersonagens(string filtro = "")
        {
            if (filtro == null) filtro = "";
            using (var connection = new ContextoBancoDeDados())
            {
                var personagens = connection.Personagem.Where(p => p.Nome.Contains(filtro)).OrderBy(p => p.Nome).ToList();
                return personagens;
            }           
        }
    }
}

