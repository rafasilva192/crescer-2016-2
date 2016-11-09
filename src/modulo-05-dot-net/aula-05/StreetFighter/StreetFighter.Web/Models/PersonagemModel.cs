using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Web;

namespace StreetFighter.Web.Models
{
    public class PersonagemModel
    {
        public int? Id { get; set; }
        [Required]
        public string Nome { get; set; }

        public string Origem { get; set; }
    }
}