using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace AulaEF.Dominio
{
    public interface IUserRepository
    {
        User GetById(int id);
        void Create(User user);
        void Update(User user);

        IList<User> FilterByName(string name);
    }


}
