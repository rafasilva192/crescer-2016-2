using AulaEF.Dominio;
using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Data.SqlClient;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace AulaEF.Repository
{
    public class UserRepository : IUserRepository
    {
        public void Create(User user)
        {
            using (var context = new DatabaseContext())
            {
                context.Entry<User>(user).State = EntityState.Added;
                if(user.Role != null)
                {
                    context.Entry<UserRole>(user.Role).State = EntityState.Unchanged;
                }
                context.SaveChanges();
            }
        }

        public IList<User> FilterByName(string name)
        {
            using (var context = new DatabaseContext())
            {
                IQueryable<User> query = context.User.Where(u => u.Name.Contains(name));

                return query.ToList();
            }
        }

        public User GetById(int id)
        {
            using (var context = new DatabaseContext())
            {
                User userFound = context.User
                                        .Include("Role")
                                        .FirstOrDefault(u => u.Id == id);
                return userFound;
            }
        }

        public void Update(User user)
        {
            using (var context = new DatabaseContext())
            {
                user.Role = context.UserRole.Find(user.RoleId);
                context.Entry<User>(user).State = EntityState.Modified;
                context.SaveChanges();
            }
        }
        
    }
}
