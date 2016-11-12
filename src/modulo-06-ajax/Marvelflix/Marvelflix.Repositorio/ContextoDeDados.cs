using Marvelflix.Dominio;
using System.Data.Entity;
using System.Data.Entity.ModelConfiguration.Conventions;

namespace Marvelflix.Repositorio
{
    public class ContextoDeDados : DbContext
    {
        public ContextoDeDados() : base("Marvelflix")
        {
        }

        public DbSet<Heroi> Heroi { get; set; }
        public DbSet<Comic> Comic { get; set; }

        protected override void OnModelCreating(DbModelBuilder modelBuilder)
        {
            modelBuilder.Conventions.Remove<PluralizingTableNameConvention>();
            base.OnModelCreating(modelBuilder);
        }
    }
}
