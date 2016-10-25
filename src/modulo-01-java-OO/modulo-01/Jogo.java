import java.util.Scanner;
import java.util.InputMismatchException;

public class Jogo {

    private static String texto = "EA Sports. It's in the game...";

    public static void main(String[] args) {
        System.out.println(texto);
        System.out.println("Escolha o tipo de Exército:");
        System.out.println("1 - Exército normal");
        System.out.println("2 - Batalhão especial");
        System.out.println("3 - Faca na caveira");
        try {
            Exercito exercito = criarExercito();
            if (exercito != null) {
                exercito.atacar();
            }
        } catch (NaoPodeAlistarException inputException) {
            System.out.println("Tratando novamente!");
        }
    }

    private static Exercito criarExercito() throws NaoPodeAlistarException {
        Exercito exercito = null;
        try {
            Scanner scanner = new Scanner(System.in);
            int tipo = scanner.nextInt();
            exercito = Jogo.criarExercito(tipo);
        } catch(InputMismatchException ime) {
            System.out.println("Informe um tipo correto de exército. Tente novamente. Contate o administrador. Bad, bad server, no donut for you.");
            throw new NaoPodeAlistarException();
        } /*catch(Exception ex) {
            System.out.println("Tente novamente.");
        } */finally {
            return exercito;
        }
    }

    private static Exercito criarExercito(int tipo) {
        Exercito exercito = null;
        switch (tipo) {
            case 1:
            exercito = new ExercitoDeElfos();
            break;
            case 2:
            exercito = new BatalhaoEspecialDeElfos();
            break;
            case 3:
            exercito = new BOPElfos();
        }
        return exercito;
    }

}

