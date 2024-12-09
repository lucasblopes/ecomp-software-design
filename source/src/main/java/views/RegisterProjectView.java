package views;

import java.time.LocalDate;
import utils.PathUtil;
import utils.DateUtil;

public class RegisterProjectView extends GenericView {

	public RegisterProjectView() {
		super();
	}

	// Exibe o menu para cadastrar o projeto
	public void showProjectRegistrationScreen() {
		this.showTitle();
		System.out.println("Titulo: ");
		System.out.println("Cliente: ");
		System.out.println("Data Inicial: ");
		System.out.println("Prazo entrega: ");
		System.out.println("Descricao: ");
		System.out.println("Contrato em PDF: ");
		continuar();
	}

	public String getTitle() {
		showTitle();
		System.out.print("Titulo: ");
		String title = getInput();
		while (title == null || title.isEmpty()) {
			showError("Título não pode ser vazio.");
			System.out.print("Titulo: ");
			title = getInput();
		}
		return title;
	}

	public String getClient() {
		System.out.print("Cliente: ");
		String client = getInput();
		while (client == null || client.isEmpty()) {
			showError("Cliente não pode ser vazio.");
			System.out.print("Cliente: ");
			client = getInput();
		}
		return client;
	}

	public LocalDate getInitialDate() {
		System.out.print("Data Inicial (dd/MM/yyyy): ");
		String data = getInput();
		LocalDate initialDate = null;
		while (initialDate == null) {
			try {
				initialDate = DateUtil.parseDate(data);
			} catch (IllegalArgumentException e) {
				showError(e.getMessage());
				System.out.print("Data Inicial (dd/MM/yyyy): ");
				data = getInput();
			}
		}
		return initialDate;
	}

	public LocalDate getDeliveryDeadline() {
		System.out.print("Prazo de entrega (dd/MM/yyyy): ");
		String prazo = getInput();
		LocalDate deliveryDeadline = null;
		while (deliveryDeadline == null) {
			try {
				deliveryDeadline = DateUtil.parseDate(prazo);
			} catch (IllegalArgumentException e) {
				showError(e.getMessage());
				System.out.print("Prazo de entrega (dd/MM/yyyy): ");
				prazo = getInput();
			}
		}
		return deliveryDeadline;
	}

	public String getDescription() {
		System.out.print("Descricao: ");
		String description = getInput();
		while (description == null || description.isEmpty()) {
			showError("Descrição não pode ser vazia.");
			System.out.print("Descricao: ");
			description = getInput();
		}
		return description;
	}

	public String getPDFContractPath() {
		this.showTitle();
		System.out.print("Caso tenha um contrato PDF, adicione o caminho dele: ");
		String path = getInput();
		if (!path.isEmpty()) {
			showImportedContractScreen(path);
		} else {
			showError("Contrato PDF não anexado!");
		}
		return path;
	}

	public void showImportedContractScreen(String contractPDFPath) {
		System.out.println("Contrato adicionado: " + PathUtil.getLastPartOfPath(contractPDFPath));
		continuar();
	}

	public void showTitle() {
		System.out.println("=== Cadastro de Projeto ===");
	}
}
