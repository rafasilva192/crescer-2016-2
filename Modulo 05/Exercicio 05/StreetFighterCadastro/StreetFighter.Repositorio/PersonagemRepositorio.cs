using StreetFighter.Dominio;
using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace StreetFighter.Repositorio
{
    public class PersonagemRepositorio : IPersonagemRepositorio
    {
        private string textopath = @"C:\Users\Rafael\crescer-2016-2\Modulo 05\Exercicio 05\StreetFighterCadastro\StreetFighterCadastro\Content\StreetFighterPersonagens.txt";
        //private string textopath = @"C:\Users\RAFAEL.SILVA\crescer-2016-2\Modulo 05\Exercicio 04\StreetFighterCadastro\StreetFighterCadastro\Content\StreetFighterPersonagens.txt";
        public List<Personagem> ListarPersonagens(string filtro)
        {
            using (var fileStream = File.OpenRead(textopath))
            using (var streamReader = new StreamReader(fileStream, Encoding.UTF8, true))
            {
                String linhaAtual;
                while ((linhaAtual = streamReader.ReadLine()) != null)
                {
                    string[] propriedadePersonagem = linhaAtual.Split(';');
                }
  }
            throw new NotImplementedException();
        }

        public void IncluirPersonagem(Personagem personagem)
        {
            var numeroLinhas = File.ReadLines(textopath).Count() +1;
            var formatacao = String.Format("{0};{1};{2};{3};{4};{5};{6};{7};{8};",
            numeroLinhas, 
            personagem.Nome,
            personagem.DataNascimento,
            personagem.Altura,
            personagem.Peso,
            personagem.Origem,
            personagem.GolpesEspeciais,
            personagem.PersonagemOculto,
            personagem.Imagem);
            
            File.AppendAllText(textopath, formatacao + Environment.NewLine);
        }

        public void DeletarPersonagem(Personagem personagem)
        {

        }

        public void EditarPersonagem(Personagem personagem)
        {

        }

        
    }
}
