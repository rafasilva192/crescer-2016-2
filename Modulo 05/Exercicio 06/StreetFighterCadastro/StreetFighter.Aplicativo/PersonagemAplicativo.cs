using StreetFighter.Dominio;
using StreetFighter.Repositorio;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace StreetFighter.Aplicativo
{
    public class PersonagemAplicativo
    {
        private readonly IPersonagemRepositorio repositorio;

        public PersonagemAplicativo()
        {
            this.repositorio = new PersonagemRepositorioEntityFramework();
        }

        public PersonagemAplicativo(IPersonagemRepositorio repositorio)
        {
            this.repositorio = repositorio;
        }

        public List<Personagem> ListarPersonagens(string filtro = null)
        {
            return repositorio.ListarPersonagens(filtro);
        }

        public void Salvar(Personagem personagem)
        {
            if(personagem.Id == 0)
            {
                repositorio.IncluirPersonagem(personagem);
            }
            else
            {
                repositorio.EditarPersonagem(personagem);
            }
        }
        public void Deletar(Personagem personagem)
        {
            repositorio.DeletarPersonagem(personagem);
        }
        }
}
