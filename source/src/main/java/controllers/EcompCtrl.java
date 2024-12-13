package controllers;

import repositories.*;
import views.EcompView;

// Facade Pattern
public class EcompCtrl {
    private EcompView view;
    private ProjectRepository projectRepo;
    private MemberRepository memberRepo;
    private ActivityRepository activityRepo;

    private RegisterProjectCtrl projectCtrl;
    private RegisterStageCtrl stageCtrl;
    private AddDevsCtrl devsCtrl;
    private RegisterActivityCtrl activityCtrl;
    private RegisterInvoiceCtrl invoiceCtrl;
    private RegisterMemberCtrl memberCtrl;
    private GenerateReportCtrl reportCtrl;

    public EcompCtrl() {
        // Inicialização dos repositórios
        this.view = new EcompView();
        this.projectRepo = new ProjectRepository();
        this.memberRepo = new MemberRepository();
        this.activityRepo = new ActivityRepository();

        // Inicialização dos controladores
        this.projectCtrl = new RegisterProjectCtrl();
        this.stageCtrl = new RegisterStageCtrl();
        this.devsCtrl = new AddDevsCtrl();
        this.activityCtrl = new RegisterActivityCtrl();
        this.invoiceCtrl = new RegisterInvoiceCtrl();
        this.memberCtrl = new RegisterMemberCtrl();
        this.reportCtrl = new GenerateReportCtrl();
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
                projectCtrl.registerProject(projectRepo);
                break;
            case 2:
                stageCtrl.registerStage(projectRepo);
                break;
            case 3:
                devsCtrl.addDevs();
                break;
            case 4:
                activityCtrl.registerActivity(activityRepo, memberRepo);
                break;
            case 5:
                invoiceCtrl.registerInvoice();
                break;
            case 6:
                memberCtrl.registerMember(memberRepo);
                break;
            case 7:
                reportCtrl.generateReport();
                break;
            case 0:
                view.showSuccess("Saindo do sistema... Até logo!");
                break;
            default:
                view.showError("Opção inválida. Tente novamente.");
        }
    }
}