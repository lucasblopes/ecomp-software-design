package views;

import models.Project;
import repositories.ProjectRepository;

public class RegisterStageView extends GenericView {

	public RegisterStageView() {
		super();
	}

	public boolean showProjects(ProjectRepository projectRepo) {
		showTitle();
		System.out.println("Selecione o nome do projeto desejado:");

		if (projectRepo.getProjects().isEmpty()) {
			showError("Nenhum projeto cadastrado ainda");
			return false;
		}

		for (Project project : projectRepo.getProjects()) {
			System.out.println("- " + project.getTitle());
		}
		return true;
	}

	public String selectProject() {
		System.out.println("Projeto Selecionado: ");
		return getInput();
	}

	public String getSchedule() {
		System.out.println("Cronograma: ");
		String schedule = getInput();

		return schedule;
	}

	public String getStatus() {
		System.out.println("Status do Projeto: ");
		String status = getInput();

		return status;
	}

	public void showTitle() {
		System.out.println("=== Cadastro de Etapas do Projeto ===");
	}
}
