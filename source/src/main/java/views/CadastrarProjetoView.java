package views;

import java.time.LocalDate;
import utils.PathUtil;
import utils.DateUtil;

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
        while (titulo == null || titulo.isEmpty()) {
            showError("Título não pode ser vazio.");
            System.out.print("Titulo: ");
            titulo = getInput();
        }
        return titulo;
    }

    public String inputCliente() {
        System.out.print("Cliente: ");
        String cliente = getInput();
        while (cliente == null || cliente.isEmpty()) {
            showError("Cliente não pode ser vazio.");
            System.out.print("Cliente: ");
            cliente = getInput();
        }
        return cliente;
    }

    public LocalDate inputDataInicial() {
        System.out.print("Data Inicial (dd/MM/yyyy): ");
        String data = getInput();
        LocalDate dataInicial = null;
        while (dataInicial == null) {
            try {
                dataInicial = DateUtil.parseDate(data);
            } catch (IllegalArgumentException e) {
                showError(e.getMessage());
                System.out.print("Data Inicial (dd/MM/yyyy): ");
                data = getInput();
            }
        }
        return dataInicial;
    }

    public LocalDate inputPrazoEntrega() {
        System.out.print("Prazo de entrega (dd/MM/yyyy): ");
        String prazo = getInput();
        LocalDate prazoEntrega = null;
        while (prazoEntrega == null) {
            try {
                prazoEntrega = DateUtil.parseDate(prazo);
            } catch (IllegalArgumentException e) {
                showError(e.getMessage());
                System.out.print("Prazo de entrega (dd/MM/yyyy): ");
                prazo = getInput();
            }
        }
        return prazoEntrega;
    }

    public String inputDescricao() {
        System.out.print("Descricao: ");
        String descricao = getInput();
        while (descricao == null || descricao.isEmpty()) {
            showError("Descrição não pode ser vazia.");
            System.out.print("Descricao: ");
            descricao = getInput();
        }
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
