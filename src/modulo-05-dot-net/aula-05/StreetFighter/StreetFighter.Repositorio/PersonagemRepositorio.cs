using StreetFighter.Dominio;
using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Reflection;
using System.Text;
using System.Threading.Tasks;

namespace StreetFighter.Repositorio
{
    public class PersonagemRepositorio : IPersonagemRepositorio
    {
        private readonly string arquivo;
        private readonly object lockObject = new object();

        public PersonagemRepositorio()
        {
            var arquivoDll = (new System.Uri(Assembly.GetExecutingAssembly().CodeBase)).AbsolutePath;
            var pastaBin = Path.GetDirectoryName(arquivoDll);

            arquivo = Path.Combine(pastaBin, "personagens.csv");
            lock (lockObject)
            {
                if (!File.Exists(arquivo))
                {
                    File.AppendAllText(arquivo, "1;Ryu;Tókio" + Environment.NewLine);
                    File.AppendAllText(arquivo, "2;Blanka;Amazonia" + Environment.NewLine);
                    File.AppendAllText(arquivo, "3;Zangief;Russia" + Environment.NewLine);
                }
            }
        }

        public void IncluirPersonagem(Personagem personagem)
        {
            lock (lockObject)
            {
                int idAtual = 0;

                var linhas = File.ReadAllLines(arquivo);
                if (linhas.Count() != 0)
                {
                    var ultimaLinha = linhas.Last();
                    idAtual = Convert.ToInt32(ultimaLinha.Split(';').First());
                }

                File.AppendAllText(arquivo, personagem.ParaString(idAtual + 1) + Environment.NewLine);
            }
        }

        public void EditarPersonagem(Personagem personagem)
        {
            lock (lockObject)
            {
                var linhas = File.ReadAllLines(arquivo).ToList();

                var linha = linhas.FirstOrDefault(l => l.Split(';').FirstOrDefault() == personagem.Id.ToString());
                var indiceLinha = linhas.IndexOf(linha);

                if (indiceLinha != -1)
                    linhas[indiceLinha] = personagem.ParaString();

                File.WriteAllLines(arquivo, linhas);
            }
        }

        public void ExcluirPersonagem(int id)
        {
            lock (lockObject)
            {
                var linhas = File.ReadAllLines(arquivo).ToList();
                var linhaASerRemovida = linhas.FirstOrDefault(x => x.Split(';').First() == id.ToString());

                if (linhas.Remove(linhaASerRemovida))
                    File.WriteAllLines(arquivo, linhas);
                else
                    throw new InvalidOperationException("Personagem não encontrado");
            }
        }

        public Personagem ObterPersonagemPorId(int id)
        {
            lock (lockObject)
            {
                using (var streamReader = new StreamReader(arquivo))
                {
                    var linha = "";
                    while (linha != null)
                    {
                        linha = streamReader.ReadLine();
                        var personagem = linha.ParaPersonagem();

                        if (personagem.Id == id)
                            return personagem;
                    }
                }

                return null;
            }
        }

        public IEnumerable<Personagem> ObterPersonagensPorNome(string nome)
        {
            lock (lockObject)
            {
                using (var streamReader = new StreamReader(arquivo))
                {
                    var linha = streamReader.ReadLine();
                    while (linha != null)
                    {
                        var personagem = linha.ParaPersonagem();

                        if (nome == null || personagem.Nome.Contains(nome))
                            yield return personagem;

                        linha = streamReader.ReadLine();
                    }
                }
            }
        }
    }
}
