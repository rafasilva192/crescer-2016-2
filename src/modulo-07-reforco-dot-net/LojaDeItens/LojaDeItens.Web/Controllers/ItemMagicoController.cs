using LojaDeItens.Dominio.Configuracao;
using LojaDeItens.Dominio.ItemMagico;
using LojaDeItens.Web.Models.ItemMagico;
using LojaDeItens.Web.Servicos;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading;
using System.Web;
using System.Web.Mvc;

namespace LojaDeItens.Web.Controllers
{
    public class ItemMagicoController : Controller
    {
        private ItemMagicoServico itemMagicoServico;
        private IServicoDeConfiguracao servicoDeConfiguracao;

        public ItemMagicoController()
        {
            this.itemMagicoServico = ServicoDeDependencia.CriarItemMagicoServico();
            this.servicoDeConfiguracao = ServicoDeDependencia.CriarServicoDeConfiguracao();
        }

        public ActionResult Index()
        {
            return View();
        }

        public ActionResult Editar(int? id)
        {
            ItemParaEdicaoViewModel model = null;

            if (id.HasValue && id.Value > 0)
            {
                ItemMagicoEntidade itemMagico = this.itemMagicoServico.BuscarPorId(id.Value);
                model = new ItemParaEdicaoViewModel(itemMagico);
            }
            
            return View(model);
        }

        [HttpPost]
        [ValidateAntiForgeryToken]
        public JsonResult Salvar(ItemParaEdicaoViewModel model)
        {
            return Json(new { Mensagem = "Cadastro efetuado com sucesso." }, JsonRequestBehavior.AllowGet);
        }

        [HttpPost]
        public JsonResult Excluir(int id)
        {
            this.itemMagicoServico.Excluir(id);

            return Json(new { Mensagem = "Item excluido com sucesso." }, JsonRequestBehavior.AllowGet);
        }

        public PartialViewResult CarregarListaComTodosOsItens(int pagina)
        {
            IList<ItemMagicoEntidade> todosOsItens = this.itemMagicoServico.BuscarTodos(pagina);
            ItemMagicoListagemViewModel model = CriarItemMagicoListagemViewModel(todosOsItens, pagina);
            model.GridId = "grid-todos-os-itens";

            return PartialView("_ListagemDeItensMagicos", model);
        }
        
        public PartialViewResult CarregarListaDeRaros()
        {
            IList<ItemMagicoEntidade> itensRaros = this.itemMagicoServico.BuscarPorRaridade(true);

            ItemMagicoListagemViewModel model = CriarItemMagicoListagemViewModel(itensRaros);
            model.GridId = "grid-itens-raros";

            foreach (ItemMagicoParaListaViewModel item in model.Itens)
            {
                item.PodeEditar = false;
            }

            return PartialView("_ListagemDeItensMagicos", model);
        }
        
        public JsonResult FazNada()
        {
            return Json(new { Mensagem = "Nada!" }, JsonRequestBehavior.AllowGet);
        }

        private ItemMagicoListagemViewModel CriarItemMagicoListagemViewModel(IList<ItemMagicoEntidade> todosOsItens, int? pagina = null)
        {
            var model = new ItemMagicoListagemViewModel(todosOsItens);

            if(pagina.HasValue)
            {
                model.PaginaAtual = pagina.Value;
            }

            model.QuantidadeDeItensPorPagina = this.servicoDeConfiguracao.QuantidadeDeItensPorPagina;
            return model;
        }
    }
}