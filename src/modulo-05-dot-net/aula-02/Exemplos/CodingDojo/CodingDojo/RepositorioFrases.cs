using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;

namespace CodingDojo
{
    public class RepositorioFrases
    {
        const string CaminhoArquivo = @"C:\Users\fabriciosilva\Desktop\frases.csv";
        public List<Frase> Frases { get; private set; } = new List<Frase>();

        public RepositorioFrases()
        {
            var frases = File.ReadAllLines(CaminhoArquivo).ToList();

            foreach (var frase in frases)
            {
                Frases.Add(new Frase(frase));
            }
        }

        public void AdicionarFrase(Frase novaFrase)
        {
            this.Frases.Add(novaFrase);
            File.AppendAllText(CaminhoArquivo, Environment.NewLine + novaFrase.ToString());
        }

        public List<Frase> PesquisarFrases(string termo)
        {
            return this.Frases
                       .Where(frase => frase.Texto.Contains(termo))
                       .ToList();
        }
    }
}
