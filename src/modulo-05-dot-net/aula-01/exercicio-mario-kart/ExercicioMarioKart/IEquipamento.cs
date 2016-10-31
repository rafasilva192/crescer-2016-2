using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ExercicioMarioKart
{
    // A melhor forma de representarmos um equipamento em nosso exercício
    // é por uma interface, uma vez que teremos o SkyFusion, que é um
    // cart e uma interface.
    // Como não é permitido herdar múltiplas classes em c#, precisamos que
    // seja uma interface.
    public interface IEquipamento
    {
        // cada equipamento possui um bônus único, e esse bônus não muda,
        // ele é apenas o valor computado de várias outras coisas, então
        // a melhor opção no momento é uma propriedade somente get.
        int Bonus { get; }
    }
}
