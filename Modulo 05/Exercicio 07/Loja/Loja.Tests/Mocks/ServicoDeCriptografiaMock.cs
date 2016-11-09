﻿using Loja.Dominio;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Loja.Tests.Mocks
{
    public class ServicoDeCriptografiaMock : IServicoDeCriptografia
    {
        public string Criptografar(string email, string senha)
        {
            return senha;
        }
    }
}
