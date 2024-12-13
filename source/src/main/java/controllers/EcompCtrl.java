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

	private RegisterProjectCtrl regProjCtrl;
	private RegisterStageCtrl stageCtrl;
	private RegisterActivityCtrl activityCtrl;
	private RegisterInvoiceCtrl invoiceCtrl;
	private RegisterMemberCtrl memberCtrl;
	private GenerateReportCtrl genRepCtrl;
	private DevCtrl devCtrl;

	private boolean isAuthenticated = false;

	public EcompCtrl() {
		// Inicialização dos repositórios
		this.view = new EcompView();
		this.projRepo = new ProjectRepository();
		this.memberRepo = new MemberRepository();
		this.activityRepo = new ActivityRepository();

		// Inicialização dos controladores
		this.regProjCtrl = new RegisterProjectCtrl(this.projRepo);
		this.stageCtrl = new RegisterStageCtrl(this.projRepo);
		this.activityCtrl = new RegisterActivityCtrl(this.activityRepo, this.memberRepo);
		this.memberCtrl = new RegisterMemberCtrl(this.memberRepo);
		this.invoiceCtrl = new RegisterInvoiceCtrl();
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

			processOption(option);
		} while (option != 0);
	}

	private void processOption(int option) {
		switch (option) {
			case 1:
				regProjCtrl.registerProject();
				break;
			case 2:
				stageCtrl.registerStage();
				break;
			case 3:
				devCtrl.manage();
				break;
			case 4:
				if (isAuthenticated) {
					activityCtrl.registerActivity();
				} else {
					view.showError("Usuário não autenciado. Por favor, faça login antes de continua");
				}
				break;
			case 5:
				invoiceCtrl.registerInvoice();
				break;
			case 6:
				memberCtrl.registerMember();
				break;
			case 7:
				genRepCtrl.generateReport();
				break;
			case 8:
				System.out.println("===Login do Sistema===");
				System.out.printf("Digite o usuário: ");
				String username = view.getInput();
				System.out.printf("Digite a senha: ");
				String password = view.getInput();

				if (username.equals("a") && password.equals("a")) {
					isAuthenticated = true;
					view.showSuccess("Login realizado com sucesso!");
				} else {
					view.showSuccess("Credenciais inválidas. Tente novamente.");
				}
				break;
			case 0:
				view.showSuccess("Saindo do sistema... Até logo!");
				break;
			default:
				view.showError("Opção inválida. Tente novamente.");
		}
	}
}
