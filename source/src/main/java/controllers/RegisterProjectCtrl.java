package controllers;

import models.Project;
import java.time.LocalDate;
import repositories.ProjectRepository;
import views.RegisterProjectView;

public class RegisterProjectCtrl {

    private RegisterProjectView view;
    private ProjectRepository projectRepo;
	private DevCtrl devCtrl;

    public RegisterProjectCtrl(ProjectRepository projRepo, DevCtrl devCtrl) {
        this.view = new RegisterProjectView();
        this.projectRepo = projRepo;
		this.devCtrl = devCtrl;
    }

    // Método principal que gerencia o fluxo de cadastro
    public void registerProject() {
        view.showProjectRegistrationScreen();

        String title = view.getTitle();

        if (projectRepo.findProject(title).isPresent()) {
            view.showError("Já existe um projeto com o título '" + title + "'. Tente novamente com um título diferente.");
            return;
        }

        String client = view.getClient();
        LocalDate startDate = view.getInitialDate();
        LocalDate deliveryDeadline = view.getDeliveryDeadline();
        String description = view.getDescription();
        view.showConfirmation();
        String contractPDF = view.getPDFContractPath();

		// Criação do projeto usando Builder Pattern
        Project project = Project.builder()
                .title(title)
                .client(client)
                .startDate(startDate)
                .deliveryDeadline(deliveryDeadline)
                .description(description)
                .contractPDF(contractPDF)
                .build();
        if (project == null) {
            view.showError("Projeto " + title + " não foi cadastrado!");
            return;
        }

        // Adiciona o projeto à lista
        projectRepo.addProject(project);

		while(project.getDevs().size() == 0) {
			this.devCtrl.addDevToProject(project);	
		}

        view.showSuccess("Projeto " + project.getTitle() + " cadastrado com sucesso!");
    }
}
