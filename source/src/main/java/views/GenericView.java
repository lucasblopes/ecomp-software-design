package views;

import java.util.Scanner;

public abstract class GenericView {

    private Scanner scanner;

    public GenericView() {
        scanner = new Scanner(System.in);
    }

    // Lê o input do usuário
    public String getInput() {
        return scanner.nextLine();
    }

    // Lê o input int do usuário
    public int getInputInt() {
        try {
            return Integer.parseInt(getInput());
        } catch (NumberFormatException e) {
            showError("Entrada inválida. Insira um número inteiro.");
            return getInputInt();
        }
    }

    public abstract void showTitle();

    // Exibe mensagem de erro
    public void showError(String message) {
        System.out.println();
        System.out.println("Erro: " + message);
        continuar();
    }

    // Exibe mensagem de sucesso
    public void showSuccess(String message) {
        System.out.println();
        System.out.println(message);
        continuar();
    }

    public void confirmar() {
        System.out.println();
        System.out.print("ENTER para confirmar...");
        getInput();
        limparTela();
    }

    public void continuar() {
        System.out.println();
        System.out.print("ENTER para continuar...");
        getInput();
        limparTela();
    }

    // Limpa a tela do terminal
    public void limparTela() {
		System.out.print("\033[H\033[2J");
		System.out.flush();
    }

}
