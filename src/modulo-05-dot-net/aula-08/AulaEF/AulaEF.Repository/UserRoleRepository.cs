using AulaEF.Dominio;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace AulaEF.Repository
{
    public class UserRoleRepository : IUserRoleRepository
    {
        public UserRole GetById(int id)
        {
            using (var context = new DatabaseContext())
            {
                return context.UserRole.Find(id);
            }
        }
    }
}
