using StreetFighter.Dominio;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace StreetFighter.Repositorio
{
    public interface IPersonagemRepositorio
    {
         List<Personagem> ListarPersonagens(string filtro);

         void IncluirPersonagem(Personagem personagem);

         void DeletarPersonagem(Personagem personagem);

         void EditarPersonagem(Personagem personagem);
        
    }
}
