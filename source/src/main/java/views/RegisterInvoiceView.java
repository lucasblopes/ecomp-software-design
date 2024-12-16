package views;

import models.Project;
import models.Activity;
import repositories.ActivityRepository;
import repositories.ProjectRepository;
import utils.DateUtil;

import java.time.LocalDate;

public class RegisterInvoiceView extends GenericView {

    public RegisterInvoiceView() {
        super();
    }

    public String showChoice() {
        showTitle();
        System.out.println("Você deseja atribuir uma Nota Fiscal a um Projeto ou Atividade?");
        return getInput();
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

    public boolean showActivities(ActivityRepository activityRepo) {
        showTitle();
        System.out.println("Selecione o nome da atividade desejada:");

        if (activityRepo.getActivities().isEmpty()) {
            showError("Nenhum projeto cadastrado ainda");
            return false;
        }

        for (Activity activity : activityRepo.getActivities()) {
            System.out.println("- " + activity.getName());
        }
        return true;
    }

    public String selectProject() {
		System.out.println("Projeto Selecionado: ");
		return getInput();
	}

    public String selectActivity() {
		System.out.println("Atividade Selecionado: ");
		return getInput();
	}

    public LocalDate getDate() {
        System.out.println("Data (dd/MM/yyyy): ");
		String date = getInput();
        LocalDate data = null;
		while (data == null) {
			try {
				data = DateUtil.parseDate(date);
			} catch (IllegalArgumentException e) {
				showError(e.getMessage());
				System.out.print("Data (dd/MM/yyyy): ");
				date = getInput();
			}
		}
		return data;
    }

    public String getType() {
        System.out.println("Tipo: ");
        return getInput();
    }

    public Integer getValue() {
        System.out.println("Valor: ");
        return getInputInt();
    }

	public void showTitle() {System.out.println("=== Cadastrar Notas Fiscais e Recibos ===");}
}
