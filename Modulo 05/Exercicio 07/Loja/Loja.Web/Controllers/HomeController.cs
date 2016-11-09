using Loja.Dominio;
using Loja.Web.Filters;
using Loja.Web.Models;
using Loja.Web.Servicos;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace Loja.Web.Controllers
{
    [LojaAutorizador]
    public class HomeController : Controller
    {
        public ActionResult Index(string filtro)
        {
            var model = ListarProdutos(filtro);
            return View(model);
        }

        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Escolher(string filtro, string submitbtn)
        {
            switch (submitbtn)
            {
                case "cadastrar":
                    return RedirectToAction("Cadastro");
                default:
                    var model = ListarProdutos(filtro);
                    return View("Index", model);
            }
        }

        public ActionResult Cadastro()
        {
            return View();
        }

        public ActionResult Salvar(ProdutoModel model)
        {
            if (ModelState.IsValid)
            {
                if (model.Id != null)
                {
                    var aplicativo = ServicoDeDependencias.MontarProdutoServico();

                    var produto = new Produto((int)model.Id, model.Nome, model.Valor);

                    aplicativo.AlterarProduto(produto);

                    return RedirectToAction("Index");
                }
                else
                {
                    var aplicativo = ServicoDeDependencias.MontarProdutoServico();

                    var produto = new Produto(model.Nome, model.Valor);

                    aplicativo.SalvarProduto(produto);

                    return RedirectToAction("Index");
                }
            }
            else
            {
                ModelState.AddModelError("", "Ocorreu um erro inesperado, entre em contato com o Nunes");
                return View("Cadastro", model);
            }
        }

        public ActionResult Editar(int id)
        {
            var aplicativo = ServicoDeDependencias.MontarProdutoServico();
            var lista = aplicativo.ListarOsProdutos();
            var produto = lista.Where(p => p.Id == id).FirstOrDefault();
            var model = new ProdutoModel(
                                         produto.Id,
                                         produto.Nome,
                                         produto.Valor
                                         );
            return View("Cadastro", model);
        }

        public ActionResult Deletar(int id)
        {
            var aplicativo = ServicoDeDependencias.MontarProdutoServico();
            var lista = aplicativo.ListarOsProdutos();
            var produto = lista.Where(p => p.Id == id).FirstOrDefault();
            aplicativo.RemoverProduto(produto);
            return RedirectToAction("Index");
        }

        public ActionResult Produto(int Id)
        {
            var model = ListarProdutos("").Where(p => p.Id == Id).FirstOrDefault();
            return View(model);
        }

        public ActionResult About()
        {
            ViewBag.Message = "Your application description page.";

            return View();
        }

        public ActionResult Contact()
        {
            ViewBag.Message = "Your contact page.";

            return View();
        }

        private IList<Produto> ListarProdutos(string filtro)
        {
            var aplicativo = ServicoDeDependencias.MontarProdutoServico();
            return aplicativo.ListarOsProdutos(filtro);
        } 
    }
}