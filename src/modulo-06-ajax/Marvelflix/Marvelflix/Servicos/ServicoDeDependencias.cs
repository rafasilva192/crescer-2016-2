using Marvelflix.Dominio;
using Marvelflix.Repositorio;

namespace Marvelflix.Servicos
{
    public class ServicoDeDependencias
    {
        public static IHeroisRepositorio MontarHeroisRepositorio()
        {
            return new HeroisRepositorio();
        }
    }
}