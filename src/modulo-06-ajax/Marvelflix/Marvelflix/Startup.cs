using Microsoft.Owin;
using Owin;

[assembly: OwinStartup(typeof(Marvelflix.Startup))]

namespace Marvelflix
{
    public partial class Startup
    {
        public void Configuration(IAppBuilder app)
        {
        }
    }
}
