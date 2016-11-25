using LojaDeItens.Dominio.ItemMagico;
using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Web;

namespace LojaDeItens.Web.Models.ItemMagico
{
    public class ItemParaEdicaoViewModel
    {
        public ItemParaEdicaoViewModel()
        {
        }

        public ItemParaEdicaoViewModel(ItemMagicoEntidade item)
        {
            this.Id = item.Id;
            this.Nome = item.Nome;
            this.Descricao = item.Descricao;
            this.Preco = item.Preco;
            this.Estoque = item.Estoque;
            this.Raro = item.Raro;
        }

        public int? Id { get; set; }

        [Required]
        [StringLength(50)]
        public string Nome { get; set; }

        public string Descricao { get; set; }

        public decimal Preco { get; set; }

        public int Estoque { get; set; }

        public bool Raro { get; set; }
    }
}