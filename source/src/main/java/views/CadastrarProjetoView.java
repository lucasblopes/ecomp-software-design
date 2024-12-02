package views;

import utils.PathUtil;

public class CadastrarProjetoView extends GenericView {

    public CadastrarProjetoView() {
        super();
    }

    // Exibe o menu para cadastrar o projeto
    public void showCadastroProjetoScreen() {
        showTitle("Cadastro de Projetos");
        System.out.println("Titulo: ");
        System.out.println("Cliente: ");
        System.out.println("Data Inicial: ");
        System.out.println("Prazo entrega: ");
        System.out.println("Descricao: ");
        System.out.println("Contrato em PDF: ");
        continuar();
    }

    public String inputTitulo() {
        showTitle("Cadastro de Projetos");
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

    public String inputCaminhoContratoPDF() {
        showTitle("Cadastro de Projetos");
        System.out.print("Caso tenha um contrato PDF, adicione o caminho dele: ");
        String path = getInput();
        if (!path.isEmpty()) {
            showTelaContratoImportado(path);
        } else {
            showError("Contrato PDF não anexado!");
        }

        return path;
    }

    public void showTelaContratoImportado(String caminhoContratoPDF) {
        System.out.println("Contrato adicionado: " + PathUtil.getLastPartOfPath(caminhoContratoPDF));
        continuar();
    }
}
