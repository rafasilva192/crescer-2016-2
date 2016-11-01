using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;

namespace StreetFighter.Web.Models
{
    public class SobreModel : ApiController
    {
        public string Sobre { get; set; }
    }
}