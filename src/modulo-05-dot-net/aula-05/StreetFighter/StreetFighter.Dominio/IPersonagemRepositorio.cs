using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace StreetFighter.Dominio
{
    public interface IPersonagemRepositorio
    {
        Personagem ObterPersonagemPorId(int id);
        IEnumerable<Personagem> ObterPersonagensPorNome(string nome);
        void IncluirPersonagem(Personagem personagem);
        void EditarPersonagem(Personagem personagem);
        void ExcluirPersonagem(int id);
    }
}
