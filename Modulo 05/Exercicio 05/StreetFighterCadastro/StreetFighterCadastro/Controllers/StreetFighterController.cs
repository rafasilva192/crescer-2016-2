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

                    var personagem = new Personagem(model.Id==null?0:(int)model.Id, model.Nome,model.DataNascimento,model.Altura,model.Peso,model.Origem,model.GolpesEspeciais,model.PersonagemOculto,model.Imagem);

                    aplicativo.Salvar(personagem);
                }
                catch (RegraNegocioException)
                {
                    ModelState.AddModelError("","Não é permetido cadastrar membros do Illuminati");
                }
                catch
                {
                    ModelState.AddModelError("","Ocorreu um erro inesperado, chama o Nunes");
                }
                return RedirectToAction("ListaDePersonagens");
            }
            else
            {
                ModelState.AddModelError("", "Ocorreu um erro inesperado, entre em contato com o Nunes");
                return View("Cadastro", model);
            }
        }

        public ActionResult FichaTecnica(int id)
        {
            var aplicativo = new PersonagemAplicativo();
            var model = aplicativo.ListarPersonagens().Where(p => p.Id == id).ToList().First();
            return View(model);
        }

        public ActionResult ListaDePersonagens(string filtro = null)
        {
            var aplicativo = new PersonagemAplicativo();
            var model = aplicativo.ListarPersonagens(filtro);
            return View(model);
        }

        public ActionResult Deletar(int id)
        {
            var aplicativo = new PersonagemAplicativo();
            var personagem = aplicativo.ListarPersonagens().Where(p => p.Id == id).ToList().First();
            aplicativo.Deletar(personagem);
            return RedirectToAction("ListaDePersonagens");
        }

        public ActionResult Editar(int id)
        {
            ListaOrigem();
            var aplicativo = new PersonagemAplicativo();
            var model = aplicativo.ListarPersonagens().Where(p => p.Id == id).ToList().First();
            ListaDePersonagens personagem = new ListaDePersonagens();
            personagem.Id = model.Id;
            personagem.Nome = model.Nome;
            personagem.DataNascimento = model.DataNascimento;
            personagem.Altura = model.Altura;
            personagem.Peso = model.Peso;
            personagem.Origem = model.Origem;
            personagem.GolpesEspeciais = model.GolpesEspeciais;
            personagem.PersonagemOculto = model.PersonagemOculto;
            personagem.Imagem = model.Imagem;
            return View("Cadastro", personagem);
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
                new SelectListItem() { Value = "MDP", Text = "Morro da Pedra" },
                new SelectListItem() { Value = "CND", Text = "Canada" }
            };
        }
    }

}