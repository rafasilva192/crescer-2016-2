namespace Marvelflix.Dominio
{
    public class Comic
    {
        public int Id { get; set; }
        public string Titulo { get; set; }
        public int QtdPaginas { get; set; }
        public string UrlThumbnail { get; set; }
        public decimal PrecoTotal { get; set; }
    }
}