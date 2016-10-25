import GrupoDeClassesSuper.Super;

public class Sub extends Super {
    public void foo() {
        variavel++;
        super.foo();
        System.out.println("Sub");
    }
    
    public void apenasSub() {
        System.out.println("Específico do Sub");
    }
}