using ExemploModelsComplexas.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace ExemploModelsComplexas.Controllers
{
    public class ExemploController : Controller
    {
        public ActionResult CadastroSimples()
        {
            PopularPersonagens();

            return View();
        }
        
        public ActionResult Salvar(ExemploModel model)
        {
            PopularPersonagens();

            if (ModelState.IsValid)
            {
                ViewBag.Mensagem = "Cadastro concluído com sucesso.";
                return View("Detalhe", model);
            }
            else
            {
                ModelState.AddModelError("", "Ocorreu algum erro. Da uma olhada aí pls :(");
                return View("CadastroSimples");
            }
        }

        private void PopularPersonagens()
        {
            //ViewBag.ListaPersonagens
            ViewData["ListaPersonagens"] = new List<SelectListItem>()
            {
                new SelectListItem() { Value = "1", Text = "Verde" },
                new SelectListItem() { Value = "2", Text = "Branco" },
                new SelectListItem() { Value = "3", Text = "Preto" },
                new SelectListItem() { Value = "4", Text = "Azul" },
                new SelectListItem() { Value = "5", Text = "Rosa" },
                new SelectListItem() { Value = "6", Text = "Amarelo" },
                new SelectListItem() { Value = "7", Text = "Vermelho" }
            };
        }
    }
}