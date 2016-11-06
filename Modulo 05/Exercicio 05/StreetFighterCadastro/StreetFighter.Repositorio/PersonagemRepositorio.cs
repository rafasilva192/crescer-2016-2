﻿using StreetFighter.Dominio;
using StreetFighter.Infra;
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

        private string usuariopath = @"C:\Users\Rafael\crescer-2016-2\Modulo 05\Exercicio 05\StreetFighterCadastro\StreetFighterCadastro\Content\Usuarios.txt";

        private string textopath = @"C:\Users\Rafael\crescer-2016-2\Modulo 05\Exercicio 05\StreetFighterCadastro\StreetFighterCadastro\Content\StreetFighterPersonagens.txt";
        //private string textopath = @"C:\Users\RAFAEL.SILVA\crescer-2016-2\Modulo 05\Exercicio 04\StreetFighterCadastro\StreetFighterCadastro\Content\StreetFighterPersonagens.txt";
        public List<Personagem> ListarPersonagens(string filtro = null)
        {
            var lista = new List<Personagem>();
            using (var fileStream = File.OpenRead(textopath))
            using (var streamReader = new StreamReader(fileStream, Encoding.UTF8, true))
            {
                String linhaAtual;
                while ((linhaAtual = streamReader.ReadLine()) != null)
                {
                    string[] propriedadePersonagem = linhaAtual.Split(';');

                    lista.Add(
                        new Personagem
                        (
                        int.Parse(propriedadePersonagem[0]),        //Id
                        propriedadePersonagem[1],                   //Nome
                        DateTime.Parse(propriedadePersonagem[2]),   //DataNascimento   
                        int.Parse(propriedadePersonagem[3]),        //Altura
                        decimal.Parse(propriedadePersonagem[4]),    //Peso  
                        propriedadePersonagem[5],                   //Origem
                        propriedadePersonagem[6],                   //GolpesEspeciais
                        bool.Parse(propriedadePersonagem[7]),       //Oculto?
                        propriedadePersonagem[8]                    //Imagem
                        ));
                }
                streamReader.Dispose();
        }
            lista.Sort((x,y) => string.Compare(x.Nome, y.Nome));
            if (filtro == null || filtro == "") return lista;
            else return lista.Where(p => p.Nome.ToUpperInvariant().Contains(filtro.ToUpperInvariant())).OrderBy(p => p.Id).ToList();
        }

        public void IncluirPersonagem(Personagem personagem)
        {
            int personagemId = 0;
            if (new FileInfo(textopath).Length != 0)
            {
                var lista = ListarPersonagens();
                var listaPorId = lista.Select(p => p.Id).ToList();
                listaPorId.Sort((a, b) => b - a);
                personagemId = listaPorId.First();
            }

                 var formatacao = String.Format(
                $"{ personagemId + 1 };{ personagem.Nome };{ personagem.DataNascimento};{ personagem.Altura};{ personagem.Peso};{ personagem.Origem};{ personagem.GolpesEspeciais};{ personagem.PersonagemOculto};{ personagem.Imagem};"
            );
            
            File.AppendAllText(textopath, formatacao + Environment.NewLine);
        }

        public void DeletarPersonagem(Personagem personagem)
        {
            var lista = ListarPersonagens();
            lista.RemoveAll(p => p.Id == personagem.Id);
            incluirPersonagens(lista);
        }  

        public void EditarPersonagem(Personagem personagem)
        {
            var lista = ListarPersonagens();
            lista.RemoveAll(p => p.Id == personagem.Id);
            lista.Add(personagem);
            lista.OrderBy(p => p.Id);
            incluirPersonagens(lista);
        }
        public List<Usuario> ListarUsuarios(bool buscarSenha = false)
        {
            var lista = new List<Usuario>();
            using (var fileStream = File.OpenRead(usuariopath))
            using (var streamReader = new StreamReader(fileStream, Encoding.UTF8, true))
            {
                String linhaAtual;
                while ((linhaAtual = streamReader.ReadLine()) != null)
                {
                    string[] Usuarios = linhaAtual.Split(';');
                    if (buscarSenha)
                    {
                        lista.Add(
                           new Usuario
                           (
                               Usuarios[0],
                               Usuarios[1]
                           ));
                    }
                    else
                    {
                        lista.Add(
                            new Usuario
                            (
                                Usuarios[0]
                            ));
                    }
                }
                streamReader.Dispose();
            }
            return lista;
        }

        public void SalvarUsuario(Usuario usuario)
        {
            var lista = ListarUsuarios();
            if (new FileInfo(usuariopath).Length != 0)
            {
                foreach (Usuario pessoa in lista)
                {
                    if (usuario.Nome.Equals(pessoa)) throw new RegraNegocioException("Já possui um usuario com esse nome");
                }
            }
            string senhaFinal = ServicoDeCriptografia.ConverterParaMD5($"{usuario.Nome}_$_{usuario.Senha}");

            var formatacao = String.Format(
           $"{ usuario.Nome };{ senhaFinal };"
       );

            File.AppendAllText(usuariopath, formatacao + Environment.NewLine);
        }


        public Usuario BuscarUsuario(Usuario usuario)
        {
            bool buscarSenhas = true;
            var lista = ListarUsuarios(buscarSenhas);
            string senhaFinal = ServicoDeCriptografia.ConverterParaMD5($"{usuario.Nome}_$_{usuario.Senha}");
            if (new FileInfo(usuariopath).Length != 0)
            {
                foreach (Usuario pessoa in lista)
                {
                    if (usuario.Nome.Equals(pessoa.Nome))
                    {
                        if (senhaFinal.Equals(pessoa.Senha))
                        {
                            var usuarioEncontrado = new Usuario(pessoa.Nome, pessoa.Senha);
                            return usuarioEncontrado;
                        }
                    }
                }
            }
            return null;
        }
    
    private void incluirPersonagens(List<Personagem> lista)
        {
            System.IO.File.WriteAllText(textopath, string.Empty);
            foreach (Personagem pers in lista)
            {
                IncluirPersonagem(pers);
            }
        }
    }
 }