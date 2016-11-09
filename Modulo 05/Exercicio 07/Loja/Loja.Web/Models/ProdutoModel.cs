using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Web;

namespace Loja.Web.Models
{
    public class ProdutoModel
    {
        public int? Id { get; set; }

        [Required]
        public string Nome { get; set; }

        [Required]
        public decimal Valor { get; set; }

        public ProdutoModel()
        {

        }

        public ProdutoModel(int Id, string Nome, decimal Valor)
        {
            this.Id = Id;
            this.Nome = Nome;
            this.Valor = Valor;
        }
    }
}