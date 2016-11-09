using System;
using System.Collections.Generic;
using System.Configuration;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace AulaEF.Repository
{
    public abstract class BaseRepository
    {
        protected string ConnectionString
        {
            get
            {
                return ConfigurationManager.ConnectionStrings["AulaEF"].ConnectionString;
            }
        }
    }
}
