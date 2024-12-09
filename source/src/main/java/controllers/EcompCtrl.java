package controllers;

import repositories.*;
import views.EcompView;

// Facade Pattern
public class EcompCtrl {

	private EcompView view;
	private ProjectRepository projectRepo;
	private MemberRepository memberRepo;
	private ActivityRepository activityRepo;

	public EcompCtrl() {
		this.view = new EcompView();
		this.projectRepo = new ProjectRepository();
		this.memberRepo = new MemberRepository();
		this.activityRepo = new ActivityRepository();
	}

	public void start() {
		int option;
		do {
			view.clearScreen();
			view.showMenu();
			option = view.getInputInt();
			view.clearScreen();

			switch (option) {
				case 1:
					new RegisterProjectCtrl().registerProject(projectRepo);
					break;
				case 2:
					new RegisterStageCtrl().registerStage(projectRepo);
					break;
				case 3:
					new AddDevsCtrl().addDevs();
					break;
				case 4:
					new RegisterActivityCtrl().registerActivity(activityRepo, memberRepo);
					break;
				case 5:
					new RegisterInvoiceCtrl().registerInvoice();
					break;
				case 6:
					new RegisterMemberCtrl().registerMember(memberRepo);
					break;
				case 7:
					new GenerateReportCtrl().generateReport();
					break;
				case 0:
					view.showSuccess("Saindo do sistema... Até logo!");
					break;
				default:
					view.showError("Opção inválida. Tente novamente.");
			}
		} while (option != 0);
	}
}
