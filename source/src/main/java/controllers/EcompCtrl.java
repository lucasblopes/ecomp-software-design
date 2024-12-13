package controllers;

import repositories.*;
import views.EcompView;

// Facade Pattern
public class EcompCtrl {

	private EcompView view;

    private ProjectRepository projRepo;
	private MemberRepository memberRepo;
	private ActivityRepository activityRepo;
    private DevRepository devRepo;

    private DevCtrl devCtrl;

	public EcompCtrl() {

		this.view = new EcompView();

        this.projRepo = new ProjectRepository();
        this.memberRepo = new MemberRepository();
        this.devRepo = new DevRepository(); 
        this.activityRepo = new ActivityRepository();

        this.devCtrl = new DevCtrl(this.projRepo, this.memberRepo, this.devRepo);
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
					new RegisterProjectCtrl().registerProject(projRepo);
					break;
				case 2:
					new RegisterStageCtrl().registerStage(projRepo);
					break;
				case 3:
                    this.devCtrl.manage();
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
