using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ExemploLinqLambda
{
    class Program
    {
        static void Main(string[] args)
        {
            var alunos = new List<Aluno>()
            {
                new Aluno() { Nome = "Wolverine", Id = 1 },
                new Aluno() { Nome = "Goku", Id = 2 },
                new Aluno() { Nome = "Bob Esponja", Id = 4 },
                new Aluno() { Nome = "Nunes", Id = 4 },
                new Aluno() { Nome = "Fabricio", Id = 1 },
                new Aluno() { Nome = "Vegeta", Id = 1 },
                new Aluno() { Nome = "Sasuke", Id = 1 },
                new Aluno() { Nome = "Kakashi", Id = 1 },
                new Aluno() { Nome = "Anna", Id = 1 },
                new Aluno() { Nome = "Fabricio", Id = 1 }
            };

            ExemplosLambda(alunos);   

            Console.ReadKey();
        }

        //private static void ExemplosLambda(List<string> alunos)
        //{
        //    var alunosFiltrados = alunos.Where(aluno => aluno.Contains("e"));
        //    ImprimeResultados(alunosFiltrados);

        //    Console.WriteLine("\n\n");

        //    var alunosOrdenados = alunos.OrderBy(aluno => aluno);
        //    ImprimeResultados(alunosOrdenados);

        //    Console.WriteLine("\n\n");

        //    var a = alunos.Select(aluno => aluno + " da Silva");
        //    ImprimeResultados(a);

        //    Console.WriteLine("\n\n");

        //    var agrupados = alunos.GroupBy(aluno => aluno)
        //                  .Select(g => 
        //                  new
        //                  {
        //                      Nome = g.Key,
        //                      Quantidade = g.Count()
        //                  })
        //                  .ToList();

        //    foreach (var agrupado in agrupados)
        //    {
        //        Console.WriteLine("Nome: " + agrupado.Nome + " Quantidade: " + agrupado.Quantidade);
        //    }

        //    Console.WriteLine("\n\n");

        //    alunos.ForEach(aluno => Console.WriteLine(aluno));

        //    Console.WriteLine("\n\n");

        //    var c = alunos.ElementAt(2);
        //    Console.WriteLine(c);

        //    Console.WriteLine("\n\n");

        //    Console.WriteLine("Primeiro aluno: " + alunos.FirstOrDefault(x => x == "alycioneto"));
        //}

        private static void ExemplosLambda(List<Aluno> alunos)
        {
            var alunosFiltrados = alunos.Where(aluno => aluno.Nome.Contains("e"));
            ImprimeResultados(alunosFiltrados);

            Console.WriteLine("\n\n");

            var alunosOrdenados = alunos.OrderBy(aluno => aluno.Nome);
            ImprimeResultados(alunosOrdenados);

            Console.WriteLine("\n\n");

            var alunosOrdenadosPorId = alunos.OrderBy(aluno => aluno.Id);
            ImprimeResultados(alunosOrdenadosPorId);

            Console.WriteLine("\n\n");

            var anonimo = alunos.Select(aluno => new
            {
                NomeDoAluno = aluno.Nome + " da Silva",
                Idade = aluno.Id = 200
            }).ToList();

            foreach (var anon in anonimo)
            {
                Console.WriteLine(anon.NomeDoAluno + " " + anon.Idade);
            }
        }

        private static void ExemplosLinq(List<string> alunos)
        {
            //var alunosFiltrados = alunos.Where(aluno => aluno.Contains("ii"));
            var alunosFiltrados = from aluno in alunos
                                  where aluno.Contains("ii")
                                  select aluno;
            ImprimeResultados(alunosFiltrados);

            Console.WriteLine("\n\n");

            //var alunosOrdenados = alunos.OrderBy(aluno => aluno);
            var alunosOrdenados = from aluno in alunos
                                  orderby aluno
                                  select aluno;

            ImprimeResultados(alunosOrdenados);

            //var agrupados = alunos.GroupBy(aluno => aluno)
            //             .Select(g => new { Nome = g.Key, Qtd = g.Count() })
            //             .ToList();

            var agrupados = from aluno in alunos
                            group aluno by aluno into g
                            select new { Nome = g.Key, Qtd = g.Count() };

            foreach (var agrupado in agrupados)
            {
                Console.WriteLine("Nome: " + agrupado.Nome + " Quantidade: " + agrupado.Qtd);
            }
        }

        

        public static void ImprimeResultados(IEnumerable<string> lista)
        {
            foreach (var item in lista)
            {
                Console.WriteLine(item);
            }
        }

        public static void ImprimeResultados(IEnumerable<Aluno> lista)
        {
            foreach (var item in lista)
            {
                Console.WriteLine(item.Nome);
            }
        }
    }
}
