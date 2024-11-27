package views;

import utils.PathUtil;

public class CadastrarProjetoView extends GenericView {

    public CadastrarProjetoView() {
        super();
    }

    // Exibe o menu para cadastrar o projeto
    public void showCadastroProjetoScreen() {
        System.out.println("=== Cadastro de Projeto ===");
        System.out.println("Titulo: ");
        System.out.println("Cliente: ");
        System.out.println("Data Inicial: ");
        System.out.println("Prazo entrega: ");
        System.out.println("Descricao: ");
        System.out.println("Contrato em PDF: ");
        continuar();
        getInput();
    }

    public String inputTitulo() {
        System.out.print("Titulo: ");
        String titulo = getInput();
        return titulo;
    }

    public String inputCliente() {
        System.out.print("Cliente: ");
        String cliente = getInput();
        return cliente;
    }

    public String inputDataInicial() {
        System.out.print("Data Inicial: ");
        String data = getInput();
        return data;
    }

    public String inputPrazoEntrega() {
        System.out.print("Prazo de entrega: ");
        String prazo = getInput();
        return prazo;
    }

    public String inputDescricao() {
        System.out.print("Descricao: ");
        String descricao = getInput();
        return descricao;
    }

    public String inputCaminhoContrato() {
        System.out.print("Caso tenha um contrato, adicione o caminho dele: ");
        String descricao = getInput();
        return descricao;
    }

    public void mostrarTelaContratoImportado(String caminhoContratoPDF) {
        System.out.println("Contrato adicionado: " + PathUtil.getLastPartOfPath(caminhoContratoPDF));
    }

    // Exibe a tela de upload do contrato
    public void showUploadContractScreen() {
        System.out.print("Informe o caminho do arquivo do contrato (PDF) ou deixe em branco caso na ");
    }

    // Exibe a tela inicial após cadastro
    public void showInitialScreen() {
        System.out.println("Cadastro de projeto concluído com sucesso!");
    }
}
