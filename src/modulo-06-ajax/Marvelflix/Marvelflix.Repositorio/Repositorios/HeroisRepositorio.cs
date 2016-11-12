using Marvelflix.Dominio;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;

namespace Marvelflix.Repositorio
{
    public class HeroisRepositorio : IHeroisRepositorio
    {
        public int ContarRegistros()
        {
            using (var contexto = new ContextoDeDados())
                return contexto.Heroi.Count();
        }

        public IEnumerable<Heroi> Todos(int pagina, int tamanhoPagina)
        {
            // tamanhoPagina = 1
            // Skip(1) = 5*(0) = 0
            // Skip(2) = 5*(2-1) = 5
            // Skip(3) = 5*(3-1) = 10
            using (var contexto = new ContextoDeDados())
            {
                return contexto.Heroi
                    .OrderBy(_ => _.Id)
                    .Skip(tamanhoPagina * (pagina-1))
                    .Take(tamanhoPagina)
                    .ToList();
            }
        }

        public Heroi PorId(int id)
        {
            using (var contexto = new ContextoDeDados())
            {
                return contexto.Heroi
                    .Include(_ => _.Comics)
                    .SingleOrDefault(_ => _.Id == id);
            }
        }

        public void Adicionar(Heroi heroi)
        {
            using (var contexto = new ContextoDeDados())
            {
                contexto.Heroi.Add(heroi);
                contexto.SaveChanges();
            }
        }
    }
}
