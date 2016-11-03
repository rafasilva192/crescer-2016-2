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

        public ActionResult Salvar(Cadastro model)
        {
            ListaOrigem();
            if (ModelState.IsValid)
            {
                var cadastro = new FichaTecnicaModel();
                cadastro.Imagem = model.Imagem;
                cadastro.Nome = model.Nome;
                cadastro.DataNascimento = model.DataNascimento;
                cadastro.Altura = model.Altura;
                cadastro.Peso = model.Peso;
                cadastro.Origem = model.Origem;
                cadastro.GolpesEspeciais = model.GolpesEspeciais;
                if (model.PersonagemOculto) cadastro.PersonagemOculto = "Sim";
                else cadastro.PersonagemOculto = "Não";
                return View("FichaTecnicaModel", cadastro);
            }
            else
            {
                ModelState.AddModelError("", "Ocorreu um erro inesperado, entre em contato com o Nunes");
                return View("Cadastro");
            }
        }

        public ActionResult FichaTecnicaModel()
        {
            var model = new FichaTecnicaModel();
            model.Imagem = @"http://www.streetfighter.com.br/upload/editor/20120823194105_127.png";
            model.Nome = "Blanka";
            model.DataNascimento = new DateTime(1966,02,12);
            model.Altura = 192;
            model.Peso = 96;
            model.Medidas = "B198, C120, Q172.";
            model.Origem = "Brasil (lugar de nascença é provável como sendo Tailândia).";
            model.GolpesEspeciais = "Electric Thunder, Rolling Attack.";
            model.PersonagemOculto = "Não";
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