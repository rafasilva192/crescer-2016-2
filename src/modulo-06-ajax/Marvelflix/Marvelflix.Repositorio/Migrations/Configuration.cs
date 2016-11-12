namespace Marvelflix.Repositorio.Migrations
{
    using Dominio;
    using System.Data.Entity.Migrations;

    internal sealed class Configuration : DbMigrationsConfiguration<Marvelflix.Repositorio.ContextoDeDados>
    {
        public Configuration()
        {
            AutomaticMigrationsEnabled = false;
        }

        protected override void Seed(Marvelflix.Repositorio.ContextoDeDados context)
        {
            var captainMarvel = new Heroi
            {
                Nome = "Captain Marvel (Carol Danvers)",
                UrlThumbnail = "http://i.annihil.us/u/prod/marvel/i/mg/6/80/5269608c1be7a.jpg",
                Comics =
                {
                    new Comic
                    {
                        Titulo = "Captain America: Steve Rogers (2016) #6",
                        PrecoTotal = 3.99m,
                        QtdPaginas = 32,
                        UrlThumbnail = "http://i.annihil.us/u/prod/marvel/i/mg/6/90/58010c888eac6.jpg",
                    },
                    new Comic
                    {
                        Titulo = "Captain Marvel (2016) #8",
                        PrecoTotal = 3.99m,
                        QtdPaginas = 32,
                        UrlThumbnail = "http://i.annihil.us/u/prod/marvel/i/mg/6/20/57a8b5d10a753.jpg",
                    },
                }
            };

            var spiderMan = new Heroi
            {
                Nome = "Spider-Man",
                UrlThumbnail = "http://i.annihil.us/u/prod/marvel/i/mg/3/50/526548a343e4b.jpg",
                Comics =
                {
                    new Comic
                    {
                        Titulo = "Civil War II (2016) #6",
                        PrecoTotal = 4.99m,
                        QtdPaginas = 40,
                        UrlThumbnail = "http://i.annihil.us/u/prod/marvel/i/mg/6/80/580a89098acc0.jpg",
                    },
                    new Comic
                    {
                        Titulo = "Spider-Man (2016) #8",
                        PrecoTotal = 3.99m,
                        QtdPaginas = 32,
                        UrlThumbnail = "http://i.annihil.us/u/prod/marvel/i/mg/3/90/57c983ca61622.jpg",
                    }
                }
            };

            context.Heroi.AddOrUpdate(
                h => h.Nome,
                captainMarvel,
                spiderMan
            );
        }
    }
}
