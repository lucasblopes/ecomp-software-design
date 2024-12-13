package controllers;

import repositories.*;
import views.EcompView;

// Facade Pattern
public class EcompCtrl {

	private EcompView view;

    private RegisterProjectCtrl regProjCtrl;
    private RegisterStageCtrl regStageCtrl;
    private RegisterActivityCtrl regActCtrl;
    private RegisterMemberCtrl regMemberCtrl;
    private RegisterInvoiceCtrl regInvCtrl;
    private GenerateReportCtrl genRepCtrl;
    private DevCtrl devCtrl;

    private ProjectRepository projRepo;
	private MemberRepository memberRepo;
	private ActivityRepository activityRepo;
    private DevRepository devRepo;

	public EcompCtrl() {

		this.view = new EcompView();

        this.projRepo = new ProjectRepository();
        this.memberRepo = new MemberRepository();
        this.devRepo = new DevRepository(); 
        this.activityRepo = new ActivityRepository();

        this.regProjCtrl = new RegisterProjectCtrl(this.projRepo);
        this.regStageCtrl = new RegisterStageCtrl(this.projRepo);
        this.regActCtrl = new RegisterActivityCtrl(this.activityRepo, this.memberRepo);
        this.regMemberCtrl = new RegisterMemberCtrl(this.memberRepo);
        this.regInvCtrl = new RegisterInvoiceCtrl();
        this.genRepCtrl = new GenerateReportCtrl();
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
                    this.regProjCtrl.registerProject();
					break;
				case 2:
                    this.regStageCtrl.registerStage();
					break;
				case 3:
                    this.devCtrl.manage();
                    break;
				case 4:
                    this.regActCtrl.registerActivity();
					break;
				case 5:
                    this.regInvCtrl.registerInvoice();
					//new RegisterInvoiceCtrl().registerInvoice();
					break;
				case 6:
                    this.regMemberCtrl.registerMember();
					//new RegisterMemberCtrl().registerMember(memberRepo);
					break;
				case 7:
                    this.genRepCtrl.generateReport();
					//new GenerateReportCtrl().generateReport();
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
