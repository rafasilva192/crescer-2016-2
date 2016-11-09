using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Web;

namespace ExemploModelsComplexas.Models
{
    public class ExemploModel
    {
        public int Id { get; set; }

        [Required]
        public string Nome { get; set; }

        [Required]
        [Range(1, 150, ErrorMessage = "A idade deve ser entre 1 e 150.")]
        public int? Idade { get; set; }

        [DisplayName("Data de Cadastro")]
        public DateTime DataCadastro { get; set; }

        public decimal Valor { get; set; }

        [DisplayName("Deseja receber Newsletter?")]
        public bool QuerReceberNewsletter { get; set; }

        [DisplayName("Gênero")]
        public char Sexo { get; set; }

        public int IdPowerRangerPreferido { get; set; }
    }
}