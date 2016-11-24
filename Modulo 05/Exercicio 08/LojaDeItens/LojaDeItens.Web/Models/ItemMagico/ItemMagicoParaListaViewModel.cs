using LojaDeItens.Dominio.ItemMagico;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace LojaDeItens.Web.Models.ItemMagico
{
    public class ItemMagicoParaListaViewModel
    {
        public ItemMagicoParaListaViewModel(ItemMagicoEntidade item)
        {
            this.Id = item.Id;
            this.Nome = item.Nome;
            this.PodeEditar = true;
        }

        public int Id { get; private set; }

        public string Nome { get; private set; }

        public bool PodeEditar { get; set; }
    }
}