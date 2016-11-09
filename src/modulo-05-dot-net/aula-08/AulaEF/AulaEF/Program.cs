using AulaEF.Dominio;
using AulaEF.Repository;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace AulaEF
{
    class Program
    {
        static void Main(string[] args)
        {
            IUserRepository userRepository = new UserRepository();

            /*User trunks = new User()
            {
                CreationDate = DateTime.Now,
                Email = "trunks@outlok.com",
                IsActive = true,
                Name = "Trunks",
                Password = "asdasdasd123123123",
                RoleId = 1
            };*/

            //userRepository.Create(trunks);

            User savedTrunks = userRepository.GetById(1);
            savedTrunks.RoleId = 2;

            userRepository.Update(savedTrunks);

            Console.Read();
        }
    }
}
