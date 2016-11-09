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
        public string Nome { get; private set; }
        public string Origem { get; private set; }

        public Personagem(int id, string nome, string origem)
            : this(nome, origem)
        {
            if (id == 0)
                throw new RegraNegocioException("Não é permitido recuperar um personagem já persistido sem informar um Id");
            this.Id = id;
        }

        public Personagem(string nome, string origem)
        {
            if (nome.ToUpperInvariant().Contains("NUNES"))
                throw new RegraNegocioException("Não é permitido cadastrar um personagem overpowered.");

            this.Nome = nome;
            this.Origem = origem;
        }
    }
}
