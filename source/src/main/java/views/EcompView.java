package views;

public class EcompView extends GenericView {

    public EcompView() {
        super();
    }

    public void showMenu() {
		this.showTitle();
        System.out.println("1 - Cadastrar Projetos");
        System.out.println("2 - Cadastrar Etapas do Desenvolvimento do Projeto");
        System.out.println("3 - Adicionar Desenvolvedores ao Projeto");
        System.out.println("4 - Cadastrar Nova Atividade");
        System.out.println("5 - Cadastrar Notas Fiscais e Recibos");
        System.out.println("6 - Cadastrar Membro");
        System.out.println("7 - Gerar Relatório");
        System.out.println("0 - Sair");
        System.out.print("Escolha uma opção (1-7): ");
    }

	@Override
	public void showTitle() {
		System.out.println("=== Sistema Ecomp ===");
	}
}

