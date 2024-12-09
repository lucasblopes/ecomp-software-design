package controllers;

import java.util.Optional;
import models.*;
import repositories.ProjectRepository;
import views.RegisterStageView;

public class RegisterStageCtrl {
    private RegisterStageView view;

    public RegisterStageCtrl() {
		this.view = new RegisterStageView();
   	}

    public void registerStage(ProjectRepository projectRepo) {
		view.showRegisterStageScreen(projectRepo);

        String selectedProject = view.selectProject();

        Optional<Project> foundProject = projectRepo.findProject(selectedProject);
        if (foundProject.isPresent()) {
            //foundProject.get().printProject();
		} else {
           view.showError("Projeto não encontrado.");
		}
    }
}
