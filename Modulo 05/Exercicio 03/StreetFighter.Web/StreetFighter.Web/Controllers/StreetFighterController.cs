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
        // GET: StreetFighter
        public ActionResult Index()
        {
            return View();
        }

        public ActionResult FichaTecnicaModel()
        {
            var model = new FichaTecnicaModel();

            model.PrimeiraAparicao = "Street Fighter II The World Warrior (1991).";
            model.Nascimento = new DateTime(12/02/1966);
            model.Altura = 192;
            model.Peso = 96;
            model.Medidas = "B198, C120, Q172.";
            model.TipoSanguineo = "B.";
            model.HabilidadesEspeciais = "Caçar, Eletricidade.";
            model.Gosta = "Frutas tropicais, Pirarucu, Sua mãe.";
            model.Desgosta = "Army ants (espécie de formiga).";
            model.EstiloLuta = "Luta Selvagem autodidata (Army Ants) / Capoeira.";
            model.Origem = "Brasil (lugar de nascença é provável como sendo Tailândia).";
            model.FalaVitoria = "Ver você em ação é uma piada!";
            model.SSF2Nickname = "A selvagem criança da natureza.";
            model.SFA3Nickname = "A animal pessoa amazônica.";
            model.SF4Nickname = "Guerreiro da selva";
            model.SFA3Stage = "Ramificação do Rio Madeira - pantano, Brasil (ramificação do rio Madeira: talvez possa ser Mato Grosso, ou Tocantins?).";
            model.SF2Stafe = "Bacia do rio Amazonas (Brasil).";
            model.GolpesEspeciais = "Electric Thunder, Rolling Attack.";

            return View(model);
        }

        public ActionResult Sobre()
        {
            var model = new SobreModel();
            model.Sobre = "Rafael Henrique da Silva é um trainee da empresa CWI, ele tem 21 anos e é formado como Técnico em Eletrônica na Fundação Liberato, este site foi feito como um treinamento em HTML e CSS."


                return View(model);
     }
        }

}