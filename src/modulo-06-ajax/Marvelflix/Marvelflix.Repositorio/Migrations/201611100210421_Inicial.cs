namespace Marvelflix.Repositorio.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class Inicial : DbMigration
    {
        public override void Up()
        {
            CreateTable(
                "dbo.Heroi",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        Nome = c.String(),
                        UrlThumbnail = c.String(),
                    })
                .PrimaryKey(t => t.Id);
            
            CreateTable(
                "dbo.Comic",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        Titulo = c.String(),
                        QtdPaginas = c.Int(nullable: false),
                        UrlThumbnail = c.String(),
                        PrecoTotal = c.Decimal(nullable: false, precision: 18, scale: 2),
                        Heroi_Id = c.Int(),
                    })
                .PrimaryKey(t => t.Id)
                .ForeignKey("dbo.Heroi", t => t.Heroi_Id)
                .Index(t => t.Heroi_Id);
            
        }
        
        public override void Down()
        {
            DropForeignKey("dbo.Comic", "Heroi_Id", "dbo.Heroi");
            DropIndex("dbo.Comic", new[] { "Heroi_Id" });
            DropTable("dbo.Comic");
            DropTable("dbo.Heroi");
        }
    }
}
