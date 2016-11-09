using AulaDeAutenticacao.Aplicacao;
using AulaDeAutenticacao.Dominio;
using AulaDeAutenticacao.Filters;
using AulaDeAutenticacao.Models;
using AulaDeAutenticacao.Services;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace AulaDeAutenticacao.Controllers
{
    public class LoginController : Controller
    {
        // GET: Login
        public ActionResult Index()
        {
            return View();
        }

        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult FazerLogin(string usuario, string senha)
        {
            Usuario usuarioAutenticado = ServicoDeUsuario.BuscarUsuarioAutenticado(
                    usuario, senha);

            if (usuarioAutenticado != null)
            {
                ServicoDeAutenticacao.Autenticar(new UsuarioLogadoModel(
                    usuarioAutenticado.Nome, usuarioAutenticado.Permissoes));
                return RedirectToAction("Secreta");
            }

            return RedirectToAction("Index");
        }

        [CwiAutorizador]
        public ActionResult Secreta()
        {
            return View();
        }

        [CwiAutorizador(Roles = "DIRETOR")]
        public ActionResult SuperSecreta()
        {
            return View();
        }
    }
}