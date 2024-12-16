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

    public EcompCtrl() {
        // Inicialização dos repositórios
        this.view = new EcompView();
        this.projRepo = new ProjectRepository();
        this.memberRepo = new MemberRepository();
        this.activityRepo = new ActivityRepository();
		this.devRepo = new DevRepository();

        // Inicialização dos controladores
        this.stageCtrl = new RegisterStageCtrl(this.projRepo);
        this.activityCtrl = new RegisterActivityCtrl(this.activityRepo, this.memberRepo);
        this.memberCtrl = new RegisterMemberCtrl(this.memberRepo);
        this.invoiceCtrl = new RegisterInvoiceCtrl(this.projRepo, this.activityRepo);
        this.genRepCtrl = new GenerateReportCtrl();
        this.devCtrl = new DevCtrl(this.projRepo, this.memberRepo, this.devRepo);
        this.regProjCtrl = new RegisterProjectCtrl(this.projRepo, this.devCtrl);
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
                activityCtrl.registerActivity();
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
            case 0:
                view.showSuccess("Saindo do sistema... Até logo!");
                break;
            default:
                view.showError("Opção inválida. Tente novamente.");
        }
    }
}
