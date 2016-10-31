using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CodingDojo
{
    class Program
    {
        static void Main(string[] args)
        {
            var repositorio = new RepositorioFrases();
            
            var texto = LeString("Escreva a frase: ");
            var autor = LeString("Escreva o autor da frase: ");
            var frase = new Frase(texto, autor);
            
            repositorio.AdicionarFrase(frase);
            
            var termo = LeString("Informe o termo de pesquisa");
            var frasesRetornadas = repositorio.PesquisarFrases(termo);
            ImprimeFrases(frasesRetornadas);

            Console.ReadKey();
        }

        public static string LeString(string frase)
        {
            Console.WriteLine(frase);
            return Console.ReadLine();
        }

        private static void ImprimeFrases(List<Frase> frasesRetornadas)
        {
            Console.WriteLine(Environment.NewLine + "FRASES RETORNADAS:" + Environment.NewLine);

            foreach (var frase in frasesRetornadas)
            {
                Console.WriteLine(frase);
            }
        }
    }
}

