package controllers;

import repositories.ProjetoRepository;
import views.EcompView;

public class EcompCtrl {

    private EcompView view;
    private ProjetoRepository projetos;

    public EcompCtrl() {
        this.view = new EcompView();
        this.projetos = new ProjetoRepository();
    }

    // Método que processa a escolha do usuário
    public void iniciar() {
        int opcao;
        do {
            // Exibe o menu e lê a opção do usuário via view
            view.limparTela();
            view.showMenu();
            opcao = view.getInputInt();
            view.limparTela();

            // Processa a opção selecionada
            switch (opcao) {
                case 1:
                    new CadastrarProjetoCtrl().cadastrarProjeto(projetos);
                    break;
                case 2:
                    new CadastrarEtapasCtrl().cadastrarEtapa();
                    break;
                case 3:
                    new AdicionarDevsCtrl().adicionarDevs();
                    break;
                case 4:
                    new CadastrarAtividadeCtrl().cadastrarAtividade();
                    break;
                case 5:
                    new CadastrarNotasFiscaisCtrl().cadastrarNotasFiscais();
                    break;
                case 6:
                    new CadastrarMembroCtrl().cadastrarMembro();
                    break;
                case 7:
                    new GerarRelatorioCtrl().gerarRelatorio();
                    break;
                case 0:
                    view.showSuccess("Saindo do sistema... Até logo!");
                    break;
                default:
                    view.showError("Opção inválida. Tente novamente.");
            }
        } while (opcao != 0);
    }
}
