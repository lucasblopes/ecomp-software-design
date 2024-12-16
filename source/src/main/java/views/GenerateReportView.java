package views;

public class GenerateReportView extends GenericView {

    public GenerateReportView() {
        super();
    }

    // Exibe o título da tela
    public void showTitle() {
        System.out.println("=== Geração de Relatórios ===");
    }

    // Pergunta ao usuário qual tipo de relatório ele quer gerar
    public String getReportType() {
        System.out.println("Selecione o tipo de relatório:");
        System.out.println("1 - Relatório de Projetos");
        System.out.println("2 - Relatório Financeiro (Notas Fiscais)");
        System.out.print("Opção: ");

        String option = getInput();
        while (!option.equals("1") && !option.equals("2")) {
            showError("Opção inválida! Escolha '1' ou '2'.");
            System.out.print("Opção: ");
            option = getInput();
        }
        return option;
    }

    // Pergunta ao usuário onde ele deseja ver o relatório
    public String getReportDestination() {
        System.out.println("Deseja visualizar o relatório ou salvá-lo em um arquivo?");
        System.out.println("1 - Visualizar (print no console)");
        System.out.println("2 - Salvar em arquivo PDF");
        System.out.print("Opção: ");

        String option = getInput();
        while (!option.equals("1") && !option.equals("2")) {
            showError("Opção inválida! Escolha '1' ou '2'.");
            System.out.print("Opção: ");
            option = getInput();
        }
        return option;
    }

    // Exibe o conteúdo do relatório no console
    public void displayReport(String reportContent) {
        System.out.println("\n=== Relatório Gerado ===");
        System.out.println(reportContent);
        showContinue();
    }

    // Exibe o resultado da tentativa de salvar o relatório em arquivo
    public void displayFileSaveResult(boolean success, String filePath) {
        if (success) {
            System.out.println("Relatório salvo com sucesso em: " + filePath);
        } else {
            System.out.println("Erro ao salvar o relatório em: " + filePath);
        }
    }

    // Exibe uma mensagem para funcionalidades não implementadas (caso seja necessário no futuro)
    public void displayNotImplementedMessage() {
        System.out.println("Função ainda não implementada.");
    }
}
