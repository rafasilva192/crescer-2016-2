using StreetFighter.Aplicativo;
using StreetFighter.Dominio;
using StreetFighter.Web.Models;
using StreetFighterCadastro.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
namespace StreetFighter.Web.Controllers
{
    public class StreetFighterController : Controller
    {
        // GET: StreetFighter
        public ActionResult Index()
        {
            return View();
        }

        public ActionResult Cadastro()
        {
            ListaOrigem();
            return View();
        }

        public ActionResult Salvar(ListaDePersonagens model)
        {
            ListaOrigem();
            if (ModelState.IsValid)
            {
                try
                {
                    var aplicativo = new PersonagemAplicativo();

                    var personagem = new Personagem(model.Nome,model.DataNascimento,model.Altura,model.Peso,model.Origem,model.GolpesEspeciais,model.PersonagemOculto,model.Imagem);

                    aplicativo.Salvar(personagem);
                }
                catch
                {
                    ModelState.AddModelError("","Ocorreu um erro inesperado, chama o Nunes");
                }
                return View("FichaTecnicaModel", model);
            }
            else
            {
                ModelState.AddModelError("", "Ocorreu um erro inesperado, entre em contato com o Nunes");
                return View("Cadastro");
            }
        }

        public ActionResult ListaDePersonagens()
        {
            var model = new ListaDePersonagens();
            model.Imagem = @"http://www.streetfighter.com.br/upload/editor/20120823194105_127.png";
            model.Nome = "Blanka";
            model.DataNascimento = new DateTime(1966,02,12);
            model.Altura = 192;
            model.Peso = 96;
            model.Origem = "Brasil (lugar de nascença é provável como sendo Tailândia).";
            model.GolpesEspeciais = "Electric Thunder, Rolling Attack.";
            model.PersonagemOculto = false;
            return View(model);
        }

        public ActionResult SobreModel()
        {
            var model = new SobreModel();
            model.Sobre = "Rafael Henrique da Silva é um trainee da empresa CWI, ele tem 21 anos e é formado como Técnico em Eletrônica na Fundação Liberato, este site foi feito como um treinamento em HTML e CSS.";


            return View(model);
        }

        private void ListaOrigem()
        {
            //ViewBag.ListaPersonagens
            ViewData["ListaOrigem"] = new List<SelectListItem>()
            {
                new SelectListItem() { Value = "BRA", Text = "Brasil" },
                new SelectListItem() { Value = "USA", Text = "Estados Unidos" },
                new SelectListItem() { Value = "ARG", Text = "Argentina" },
                new SelectListItem() { Value = "LUX", Text = "Luxemburgo" },
                new SelectListItem() { Value = "SGP", Text = "Singapura" },
                new SelectListItem() { Value = "JPN", Text = "Japão" },
                new SelectListItem() { Value = "MBQ", Text = "Moçambique" },
                new SelectListItem() { Value = "FRN", Text = "França" },
                new SelectListItem() { Value = "KRA", Text = "Korea" },
                new SelectListItem() { Value = "CND", Text = "Canada" }
            };
        }
    }

}