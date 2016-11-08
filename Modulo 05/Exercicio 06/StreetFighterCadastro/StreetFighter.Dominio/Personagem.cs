using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace StreetFighter.Dominio
{
    public class Personagem
    {
        public int Id { get; private set; }
        public string Origem { get; private set; }
        public DateTime DataNascimento { get; private set; }
        public int Altura { get; private set; }
        public decimal Peso { get; private set; }
        public string GolpeEspecial { get; private set; }
        public bool PersonagemOculto { get; private set; }
        public string Imagem { get; private set; }
        public string Nome { get; private set; }

        public Personagem()
        {

        }

        public Personagem(int id, string nome, DateTime datanascimento, int altura, decimal peso, string origem, string golpes, bool personagemoculto, string imagem) : this(nome, datanascimento, altura, peso,origem, golpes, personagemoculto, imagem)
        {
            this.Id = id;
        }

        public Personagem(string nome, DateTime datanascimento, int altura, decimal peso, string origem, string golpes, bool personagemoculto, string imagem)
        {
            if (nome.ToUpperInvariant().Contains("NUNES"))
                throw new RegraNegocioException("Não é permetido cadastrar membros do Illuminati");
            if (origem.Contains("MDP"))
                throw new RegraNegocioException("Só um personagem pode ser do morro da Pedra");
            this.Nome = nome;
            this.DataNascimento = datanascimento;
            this.Altura = altura;
            this.Peso = peso;
            this.Origem = origem;
            this.GolpeEspecial = golpes;
            this.PersonagemOculto = personagemoculto;
            this.Imagem = imagem;

        }
    }
}
