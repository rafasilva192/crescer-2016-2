using AutoMapper;
using StreetFighter.Aplicativo;
using StreetFighter.Dominio;
using StreetFighter.Web.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace StreetFighter.Web.Controllers
{
    public class StreetFighterController : Controller
    {
        public ActionResult Index()
        {
            return View();
        }

        public ActionResult Manter(int? id)
        {
            if (id.HasValue)
            {
                var aplicativo = new PersonagemAplicativo();
                var personagem = aplicativo.ObterPersonagensPorId(id.Value);
                
                var model = Mapper.Map<Personagem, PersonagemModel>(personagem);

                return View(model);
            }

            return View();
        }

        [Route("BLABLABLA/Nunes/HelloWorld")]
        [Route("RotaOpcional2")]
        public ActionResult ExemploRedirecionamento(bool redirecionar)
        {
            if (redirecionar)
            {
                TempData["Mensagem"] = "Ocorreu um redirecionamento.";

                return RedirectToAction("Index");
            }
            else
            {
                return View("Index");
            }
        }
        
        public ActionResult Listar(string filtro)
        {
            var aplicativo = new PersonagemAplicativo();

            var model = aplicativo.ObterPersonagensPorNome(filtro).Take(10);

            return View("Listagem", model);
        }

        public ActionResult Excluir(int id)
        {
            var aplicativo = new PersonagemAplicativo();

            aplicativo.Excluir(id);

            return RedirectToAction("Listar");
        }

        public ActionResult Salvar(PersonagemModel model)
        {
            if (ModelState.IsValid)
            {
                try
                {
                    var aplicativo = new PersonagemAplicativo();
                    Personagem personagem;

                    if (model.Id.HasValue)
                        personagem = new Personagem(model.Id.Value, model.Nome, model.Origem);
                    else
                        personagem = new Personagem(model.Nome, model.Origem);

                    aplicativo.Salvar(personagem);

                    return View("FichaTecnica", model);
                }
                catch (RegraNegocioException ex)
                {
                    ModelState.AddModelError("", ex.Message);
                }
                catch (Exception)
                {
                    ModelState.AddModelError("", "Ocorreu um erro inesperado. Contate o administrador do sistema.");
                }
            }

            return View("Cadastro", model);
        }
    }
}