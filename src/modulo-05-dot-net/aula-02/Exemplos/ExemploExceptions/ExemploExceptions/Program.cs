using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ExemploExceptions
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("Digite um valor:");
            var valor = Console.ReadLine();

            try
            {
                var valorInteiro = Convert.ToInt32(valor);

                if (valorInteiro == 13)
                    throw new NumeroAzarException("Você digitou um número de azar. Número digitado: " + valorInteiro);
            } 
            catch(FormatException)
            {
                Console.WriteLine("Somente números são permitidos!");
            }
            catch(OverflowException)
            {
                Console.WriteLine("O valor excedeu o limite do int");
            }
            catch(Exception ex)
            {
                Console.WriteLine("Ocorreu um erro nao tratado. Detalhe do erro: " + ex.Message);
                throw;
            }

            Console.ReadKey();
        }
    }
}
