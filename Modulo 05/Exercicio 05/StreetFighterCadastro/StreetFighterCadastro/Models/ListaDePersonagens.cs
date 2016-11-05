using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace StreetFighterCadastro.Models
{
    public class ListaDePersonagens
    {
        public int Id { get; set; }

        public string Imagem { get; set; }

        [Required]
        public string Nome { get; set; }

        [Required]
        [DisplayName("Data de Nascimento")]
        public DateTime DataNascimento { get; set; }

        [Required]
        public int Altura { get; set; }

        [Required]
        public decimal Peso { get; set; }

        [Required]
        public string Origem { get; set; }

        [Required]
        [DisplayName("Golpes Especiais")]
        public string GolpesEspeciais { get; set; }

        [Required]
        [DisplayName("Personagem Oculto?")]
        public bool PersonagemOculto { get; set; }
    }
}