namespace AulaEF.Repository.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class AddingUserRole : DbMigration
    {
        public override void Up()
        {
            CreateTable(
                "dbo.UserRole",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        Title = c.String(),
                    })
                .PrimaryKey(t => t.Id);
            
            AddColumn("dbo.User", "Role_Id", c => c.Int());
            CreateIndex("dbo.User", "Role_Id");
            AddForeignKey("dbo.User", "Role_Id", "dbo.UserRole", "Id");
        }
        
        public override void Down()
        {
            DropForeignKey("dbo.User", "Role_Id", "dbo.UserRole");
            DropIndex("dbo.User", new[] { "Role_Id" });
            DropColumn("dbo.User", "Role_Id");
            DropTable("dbo.UserRole");
        }
    }
}
