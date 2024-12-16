package controllers;

import models.Project;
import models.Stage;
import models.Dev;
import models.Activity;
import repositories.ProjectRepository;
import repositories.ActivityRepository;
import views.GenerateReportView;

import java.io.FileWriter;
import java.util.List;

public class GenerateReportCtrl {

	private ProjectRepository projectRepo;
	private ActivityRepository activityRepo;
	private GenerateReportView view;

	public GenerateReportCtrl(ProjectRepository projectRepo, ActivityRepository activityRepo) {
		this.projectRepo = projectRepo;
		this.activityRepo = activityRepo;
		this.view = new GenerateReportView();
	}

	public void generateReport() {
		// Solicita à view o tipo de relatório e o destino
		String reportType = view.getReportType();
		String reportDestination = view.getReportDestination();

		if (reportType.equals("1")) {
			String reportContent = getProjectReportContent();
			if (reportDestination.equals("1")) {
				view.displayReport(reportContent);
			} else if (reportDestination.equals("2")) {
				String filePath = "relatorio_projetos.pdf";
				boolean success = saveReportToFile(reportContent, filePath);
				view.displayFileSaveResult(success, filePath);
			}
		} else if (reportType.equals("2")) {
			// TODO: Implementar lógica para o relatório de Nota Fiscal
			view.displayNotImplementedMessage();
		}
	}

	private String getProjectReportContent() {
		StringBuilder report = new StringBuilder();
		report.append("===== RELATÓRIO DE PROJETOS =====\n\n");

		List<Project> projects = projectRepo.getProjects();
		if (projects.isEmpty()) {
			report.append("Nenhum projeto encontrado.\n");
			return report.toString();
		}

		for (Project project : projects) {
			report.append("Projeto: ").append(project.getTitle()).append("\n");
			report.append("Cliente: ").append(project.getClient()).append("\n");
			report.append("Data de Início: ").append(project.getStartDate()).append("\n");
			report.append("Prazo de Entrega: ").append(project.getDeliveryDeadline()).append("\n");
			report.append("Descrição: ").append(project.getDescription()).append("\n");

			report.append("\n--- Etapas do Projeto ---\n");
			for (Stage stage : project.getStages()) {
				report.append("   Cronograma: ").append(stage.getSchedule())
						.append(" | Status: ").append(stage.getStatus()).append("\n");
			}

			report.append("\n--- Desenvolvedores do Projeto ---\n");
			for (Dev dev : project.getDevs()) {
				report.append("   Nome: ").append(dev.getMember().getName())
						.append(" | Departamento: ").append(dev.getMember().getDepartment()).append("\n");
			}

			report.append("\n--- Atividades Relacionadas ---\n");
			for (Activity activity : activityRepo.getActivities()) {
				report.append("   Duração: ").append(activity.getDurationMinutes())
						.append(" min | Local: ").append(activity.getLocation()).append("\n");
				report.append("   Participantes: ").append(String.join(", ", activity.getParticipants())).append("\n");
				report.append("   Objetivo: ").append(activity.getGoal()).append("\n");
				report.append("   Resumo: ").append(activity.getSummary()).append("\n");
				report.append("   --------------------------\n");
			}

			report.append("\n====================================\n\n");
		}

		return report.toString();
	}

	private boolean saveReportToFile(String content, String filePath) {
		try (var writer = new FileWriter(filePath)) {
			writer.write(content);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
