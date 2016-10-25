package GrupoDeClassesSuper;
import GrupoDeClassesSuper.PacoteInterno.ClasseInterna;

public class Super extends SuperDaSuper {
    public void foo() {
        variavel++;
        super.foo();
        //new ClasseInterna().interna++;
        System.out.println("Super");
    }
}