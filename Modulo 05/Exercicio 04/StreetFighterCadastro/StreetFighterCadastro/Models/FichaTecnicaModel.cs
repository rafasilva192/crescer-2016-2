using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace StreetFighter.Web.Models
{
    public class FichaTecnicaModel : Controller
    {
        public string Imagem { get; set; }
        public string Nome { get; set; }
        public DateTime DataNascimento { get; set; }
        public int Altura { get; set; }
        public decimal Peso { get; set; }
        public string Medidas { get; set; }
        public string Origem { get; set; }
        public string GolpesEspeciais { get; set; }
        public string PersonagemOculto { get; set; }
    }
}