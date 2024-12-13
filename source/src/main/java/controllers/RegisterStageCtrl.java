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
		view.showRegisterStageScreen(projectRepo);

        String selectedProject = view.selectProject();

        Optional<Project> foundProject = projectRepo.findProject(selectedProject);
        if (foundProject.isPresent()) {
            foundProject.get().printProject();
		} else {
           view.showError("Projeto não encontrado.");
		}
    }
}
