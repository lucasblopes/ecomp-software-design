package views;

import java.util.Scanner;

public class View {

    private Scanner scanner;

    public View() {
        scanner = new Scanner(System.in);
    }

    // Exibe o menu para cadastrar o projeto
    public void showCadastroProjetoScreen() {
        System.out.println("=== Cadastro de Projeto ===");
        System.out.print("Cliente: ");
    }

    // Lê o input do usuário
    public String getInput() {
        return scanner.nextLine();
    }

    // Exibe a tela de upload do contrato
    public void showUploadContractScreen() {
        System.out.print("Informe o caminho do arquivo do contrato (PDF): ");
    }

    // Exibe mensagem de erro
    public void showError(String message) {
        System.out.println("Erro: " + message);
    }

    // Exibe mensagem de sucesso
    public void showSuccess(String message) {
        System.out.println(message);
    }

    // Exibe a tela inicial após cadastro
    public void showInitialScreen() {
        System.out.println("Cadastro de projeto concluído com sucesso!");
    }
}