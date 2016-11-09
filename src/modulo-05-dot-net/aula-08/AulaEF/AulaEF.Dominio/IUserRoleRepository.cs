using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace AulaEF.Dominio
{
    public interface IUserRoleRepository
    {
        UserRole GetById(int id);
    }
}
