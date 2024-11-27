package views;

import java.util.Scanner;

public class GenericView {

    private Scanner scanner;

    public GenericView() {
        scanner = new Scanner(System.in);
    }

    // Lê o input do usuário
    public String getInput() {
        return scanner.nextLine();
    }

    // Exibe mensagem de erro
    public void showError(String message) {
        System.out.println();
        System.out.println("Erro: " + message);
    }

    // Exibe mensagem de sucesso
    public void showSuccess(String message) {
        System.out.println();
        System.out.println(message);
    }

    public void confirmar() {
        System.out.println();
        System.out.print("ENTER para confirmar...");
        getInput();
    }

    public void continuar() {
        System.out.println();
        System.out.print("ENTER para continuar...");
        getInput();
    }

    // Limpa a tela do terminal
    public static void limparTela() {
        for (int i = 0; i < 50; ++i) {
            System.out.println();
        }
    }

}
