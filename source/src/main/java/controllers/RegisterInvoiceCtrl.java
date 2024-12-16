package controllers;

import models.*;
import views.RegisterInvoiceView;
import repositories.ProjectRepository;
import repositories.ActivityRepository;

import java.time.LocalDate;
import java.util.Optional;

public class RegisterInvoiceCtrl {

    private RegisterInvoiceView view;
    private ProjectRepository projectRepo;
    private ActivityRepository activityRepo;

    public RegisterInvoiceCtrl(ProjectRepository projectRepo, ActivityRepository activityRepo) {
        this.view = new RegisterInvoiceView();
        this.projectRepo = projectRepo;
        this.activityRepo = activityRepo;
    }

    public void registerInvoice() {
        String choice = view.showChoice();
        Optional<?> event = Optional.empty();  // Usar Optional generico
    
        if (choice.equalsIgnoreCase("projeto")) {
            if (view.showProjects(projectRepo) == false)
                return;
    
            String selectedProject = view.selectProject();
    
            Optional<Project> foundProject = projectRepo.findProject(selectedProject);
            if (foundProject.isPresent()) {
                System.out.println(foundProject.get().toString());
                event = Optional.of(foundProject.get());  // Atribui o projeto encontrado ao event
            } else {
                view.showError("Projeto não encontrado.");
                return;
            }
        } else if (choice.equalsIgnoreCase("atividade")) {
            if (view.showActivities(activityRepo) == false)
                return;
    
            String selectedActivity = view.selectActivity();
    
            Optional<Activity> foundActivity = activityRepo.findActivity(selectedActivity);
            if (foundActivity.isPresent()) {
                System.out.println(foundActivity.get().toString());
                event = Optional.of(foundActivity.get());  // Atribui a atividade encontrada ao event
            } else {
                view.showError("Atividade não encontrada.");
                return;
            }
        }
    
        // Solicita os dados da nota fiscal
        Integer value = view.getValue();
        String type = view.getType();
        LocalDate date = view.getDate();
    
        Invoice invoice = new Invoice(date, value, type);
    
        // Adiciona a nota fiscal ao evento correto
        if (event.isPresent()) {
            if (event.get() instanceof Activity) {
                ((Activity) event.get()).addInvoice(invoice);
            } else if (event.get() instanceof Project) {
                ((Project) event.get()).addInvoice(invoice);
            }
            // Exibe a mensagem de sucesso
            view.showSuccess("Nota Fiscal atribuída com sucesso! Tipo: " + invoice.getType() + 
                             " Data: " + invoice.getDate() + " Valor: " + invoice.getValue());
        } else {
            view.showError("Erro ao atribuir a Nota Fiscal.");
        }
    }
}
