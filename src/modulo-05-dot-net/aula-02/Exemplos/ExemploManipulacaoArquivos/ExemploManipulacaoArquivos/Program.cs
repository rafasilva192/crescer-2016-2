using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ExemploManipulacaoArquivos
{
    class Program
    {
        static string caminhoArquivo = @"C:\Users\fabriciosilva\Desktop\exemplo.txt";

        //static void Main(string[] args)
        //{
        //    var streamReader = new StreamReader(caminhoArquivo);

        //    try
        //    {
        //        //string linha;
        //        //do
        //        //{
        //        //    linha = streamReader.ReadLine();
        //        //}
        //        //while (linha != null);

        //        var linha = streamReader.ReadToEnd();
        //    }
        //    finally
        //    {
        //        streamReader.Dispose();
        //    }

        //    Console.WriteLine("Caiu aqui");
        //    Console.ReadKey();
        //}

        //static void Main(string[] args)
        //{
        //    string linha;
        //    using (var streamReader = new StreamReader(caminhoArquivo))
        //    {
        //        linha = streamReader.ReadToEnd();
        //    }

        //    Console.WriteLine(linha);
        //    Console.ReadKey();
        //}

        static void Main(string[] args)
        {
            File.AppendAllText(caminhoArquivo, "balbla");

            Console.ReadKey();
        }
    }
}
