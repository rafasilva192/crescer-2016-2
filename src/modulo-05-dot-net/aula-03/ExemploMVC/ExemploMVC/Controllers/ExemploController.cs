using ExemploMVC.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace ExemploMVC.Controllers
{
    public class ExemploController : Controller
    {
        // GET: Exemplo
        public ActionResult ViewComMesmoNome()
        {
            return View();
        }

        public ActionResult ViewComNomeDiferente()
        {
            return View("ViewComMesmoNome");
        }

        public ActionResult VaiDarTreta()
        {
            return View(@"~\Views\Erro\ErroDesconhecido.cshtml");
        }

        public ActionResult ListasPersonagens()
        {
            ViewBag.PersonagemExtra = "Yusuke";  

            return View();
        }

        public ActionResult ExemplosRazor(string nomeAlunoEspecial, int? idade)
        {
            var lista = new List<string>()
            {
                "Anna da Silva",
                "Arthur Lima",
                "Cassio Machado",
                "Daniel Fedrigo",
                "Douglas Freitas",
                "Eduardo Ribas",
                "Eliseu Daroit",
                "Felipe Souza",
                "Gabriel Henz",
                "Gabriel Rosa",
                "Henrique Mentz",
                "Henrique Oestermann",
                "Jennifer Costa",
                "Jonathan Mendes",
                "Leonardo Almeida",
                "Máicon Loenbes",
                "Mateus Ramos",
                "Matheus Schmitz",
                "Mateus Teixeira",
                "Otávio Bubans",
                "Rafael da Silva",
                "Régis Martiny",
                "Rodrigo Scheuer",
                "Pablo Schlusen",
                "Victor Bittencourt",
                nomeAlunoEspecial
            };

            var alunosModel = new AlunosModel()
            {
                ListaCompleta = lista
            };

            return View(alunosModel);
        }
    }
}