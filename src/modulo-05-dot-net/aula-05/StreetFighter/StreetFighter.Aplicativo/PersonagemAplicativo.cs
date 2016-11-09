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
            this.repositorio = new PersonagemRepositorio();
        }

        internal PersonagemAplicativo(IPersonagemRepositorio repositorio)
        {
            this.repositorio = repositorio;
        }

        public IEnumerable<Personagem> ObterPersonagensPorNome(string nome)
        {
            return repositorio.ObterPersonagensPorNome(nome);
        }

        public Personagem ObterPersonagensPorId(int id)
        {
            return repositorio.ObterPersonagemPorId(id);
        }

        public void Salvar(Personagem personagem)
        {
            if (personagem.Id == 0)
                repositorio.IncluirPersonagem(personagem); 
            else
                repositorio.EditarPersonagem(personagem);
        }

        public void Excluir(int id)
        {
            repositorio.ExcluirPersonagem(id);
        }
    }
}
