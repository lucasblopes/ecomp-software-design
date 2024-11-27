package controllers;

import models.Projeto;
import views.CadastrarProjetoView;
import views.EcompView;
import java.util.Scanner;
import java.util.ArrayList;

public class Ecomp {

    private EcompView view;
    private Scanner scanner;
    private ArrayList<Projeto> projetos;

    public Ecomp() {
        this.view = new EcompView();
        this.scanner = new Scanner(System.in);
        this.projetos = new ArrayList<>();
    }

    // Método que processa a escolha do usuário
    public void iniciar() {
        int opcao;
        do {
            // Exibe o menu e lê a opção do usuário
            view.limparTela();
            view.showMenu();
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpa o buffer
            view.limparTela();

            // Processa a opção selecionada
            switch (opcao) {
                case 1:
                    CadastrarProjetoCtrl controller = new CadastrarProjetoCtrl(projetos);
                    controller.cadastrarProjeto();
                    break;
                case 2:
                    cadastrarEtapas();
                    break;
                case 3:
                    adicionarDesenvolvedores();
                    break;
                case 4:
                    cadastrarAtividade();
                    break;
                case 5:
                    cadastrarNotasFiscais();
                    break;
                case 6:
                    cadastrarMembro();
                    break;
                case 7:
                    gerarRelatorio();
                    break;
                case 0:
                    System.out.println("Saindo do sistema... Até logo!");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 0);
    }

    public void cadastrarEtapas() {
        System.out.println("Iniciando cadastro de etapas do projeto...");
        // Aqui você chamaria o código referente ao caso de uso "Cadastrar Etapas"
    }

    public void adicionarDesenvolvedores() {
        System.out.println("Iniciando cadastro de desenvolvedores ao projeto...");
        // Aqui você chamaria o código referente ao caso de uso "Adicionar
        // Desenvolvedores"
    }

    public void cadastrarAtividade() {
        System.out.println("Iniciando cadastro de atividade...");
        // Aqui você chamaria o código referente ao caso de uso "Cadastrar Nova
        // Atividade"
    }

    public void cadastrarNotasFiscais() {
        System.out.println("Iniciando cadastro de notas fiscais e recibos...");
        // Aqui você chamaria o código referente ao caso de uso "Cadastrar Notas Fiscais
        // e Recibos"
    }

    public void cadastrarMembro() {
        System.out.println("Iniciando cadastro de membro...");
        // Aqui você chamaria o código referente ao caso de uso "Cadastrar Membro"
    }

    public void gerarRelatorio() {
        System.out.println("Gerando relatório...");
        // Aqui você chamaria o código referente ao caso de uso "Gerar Relatório"
    }
}
