package views;

import models.Project;
import repositories.ProjectRepository;
import java.util.List;

public class RegisterStageView extends GenericView {

	public RegisterStageView() {
		super();
	}

	public void showProjects(ProjectRepository projectRepo) {
		if (projectRepo.getProjects().isEmpty()) {
			showError("Nenhum projeto cadastrado ainda");
			return;
		}

		for (Project project : projectRepo.getProjects()) {
			System.out.println("- " + project.getTitle());
		}
	}

	public void showRegisterStageScreen(ProjectRepository projectRepo) {
		showTitle();
		System.out.println("Selecione o nome do projeto desejado:");
		showProjects(projectRepo);
	}

	public String selectProject() {
		System.out.println("Projeto Selecionado: ");
		return getInput();
	}

	public void showTitle() {
		System.out.println("=== Cadastro de Etapas do Projeto ===");
	}
}
