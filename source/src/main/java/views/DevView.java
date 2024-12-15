package views;

public class DevView extends GenericView {

    public void showManageScreen() {

        super.clearScreen();
        System.out.println("=== Gerenciar Desenvolvedores ===");
        System.out.println("1 - Cadastrar Desenvolvedor");
        System.out.println("2 - Adicionar Issue");
        System.out.println("0 - Sair");
        System.out.print("Escolha uma opção (1-2): ");
    }

	public void showAddDevToProjectScreen() {

        super.clearScreen();
        System.out.println("=== Cadastrar Desenvolvedor ===");
        System.out.println("Nome:");
        System.out.println("Projeto:");
        super.showContinue();
	}

	public void showAddDevToProjectScreenAlt() {

        super.clearScreen();
        System.out.println("=== Cadastrar Desenvolvedor ===");
        System.out.println("Nome:");
		super.showContinue();
	}

	public void showAddIssueToDevScreen() {

        super.clearScreen();
        System.out.println("=== Adicionar Issue ===");
        System.out.println("Nome:");
        System.out.println("Issue:");
        System.out.println("Horas trabalhadas:");
        super.showContinue();
	}

    public String getDevName() {

        String name;

        System.out.print("Nome: ");
        name = super.getInput().trim();
        while(name == null || name.isEmpty()) {
            super.showError("Nome não pode ser vazio.");
            System.out.print("Nome: ");
            name = super.getInput().trim();
        }
        
        return name;
    }

    public String getProjName() {

        String proj;

        System.out.print("Projeto: ");
        proj = super.getInput().trim();
        while(proj == null || proj.isEmpty()) {
            super.showError("Projeto não pode ser vazio.");
            System.out.print("Projeto: ");
            proj = super.getInput().trim();
        }
        
        return proj;
    } 

    public String getIssue() {

        String issue;

        System.out.print("Issue: ");
        issue = super.getInput().trim();
        while(issue == null || issue.isEmpty()) {
            super.showError("Issue não pode ser vazio.");
            System.out.print("Issue: ");
            issue = super.getInput().trim();
        }
        
        return issue;
    }

    public int getHours() {

        int hours;

        System.out.print("Horas trabalhadas: ");
        hours = super.getInputInt();

        return hours;
    }
}
