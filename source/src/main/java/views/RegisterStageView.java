package views;

import models.Projeto;
import repositories.ProjetoRepository;
import java.util.List;

public class RegisterStageView extends GenericView {

	public RegisterStageView() {
		super();
	}

	public void showProjects(ProjectRepository repo) {
		if (repo.getProjetos().isEmpty()) {
			showError("Nenhum projeto cadastrado ainda");
			return;
		}

		for (Project project : repo.getProjects()) {
			System.out.println("- " + project.getTitle());
		}
	}

	public void showCadastroEtapaScreen(ProjetoRepository repo) {
		showTitle();
		System.out.println("Selecione o nome do projeto desejado:");
		showProjects(repo);
	}

	public String selectProject() {
		System.out.println("Projeto Selecionado: ");
		return getInput();
	}

	public void showTitle() {
		System.out.println("=== Cadastro de Etapas do Projeto ===");
	}
}
