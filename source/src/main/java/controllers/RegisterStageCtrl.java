package controllers;

import java.util.Optional;
import models.*;
import repositories.ProjectRepository;
import views.RegisterStageView;

public class RegisterStageCtrl {

    private RegisterStageView view;
    private ProjectRepository projectRepo;

    public RegisterStageCtrl(ProjectRepository projectRepo) {
		this.view = new RegisterStageView();
        this.projectRepo = projectRepo;
   	}

    public void registerStage() {
		if(view.showProjects(projectRepo) == false)
            return;

        String selectedProject = view.selectProject();

        Optional<Project> foundProject = projectRepo.findProject(selectedProject);
        if (foundProject.isPresent()) {
            System.out.println(foundProject.get().toString());
		} else {
            view.showError("Projeto não encontrado.");
		}

        String schedule = view.getSchedule();
        String status = view.getStatus();

        // Criação da etapa usando Builder Pattern
        Stage stage = Stage.builder()
                .schedule(schedule)
                .status(status)
                .build();

        if(stage == null) {
            view.showError("Etapa não foi cadastrada!");
            return;
        }

        // Adiciona etapa ao projeto
        foundProject.get().addStage(stage);
        view.showSuccess("Etapa cadastrada com sucesso! Cronograma:" + stage.getSchedule() + " Status:" + stage.getStatus());
    }
}
