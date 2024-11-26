package controllers;

import java.util.Scanner;

public class Ecomp {
    private Scanner scanner;

    public Ecomp() {
        this.scanner = new Scanner(System.in);
    }

    // Método que exibe o menu principal
    public void exibirMenu() {
        System.out.println("=== Sistema Ecomp ===");
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

    // Método que processa a escolha do usuário
    public void iniciar() {
        int opcao;
        do {
            // Exibe o menu e lê a opção do usuário
            exibirMenu();
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpa o buffer

            // Processa a opção selecionada
            switch (opcao) {
                case 1:
                    cadastrarProjeto();
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

    // Funções de cada caso de uso
    private void cadastrarProjeto() {
        System.out.println("Iniciando cadastro de projeto...");
        // Aqui você chamaria o código referente ao caso de uso "Cadastrar Projeto"
    }

    private void cadastrarEtapas() {
        System.out.println("Iniciando cadastro de etapas do projeto...");
        // Aqui você chamaria o código referente ao caso de uso "Cadastrar Etapas"
    }

    private void adicionarDesenvolvedores() {
        System.out.println("Iniciando cadastro de desenvolvedores ao projeto...");
        // Aqui você chamaria o código referente ao caso de uso "Adicionar Desenvolvedores"
    }

    private void cadastrarAtividade() {
        System.out.println("Iniciando cadastro de atividade...");
        // Aqui você chamaria o código referente ao caso de uso "Cadastrar Nova Atividade"
    }

    private void cadastrarNotasFiscais() {
        System.out.println("Iniciando cadastro de notas fiscais e recibos...");
        // Aqui você chamaria o código referente ao caso de uso "Cadastrar Notas Fiscais e Recibos"
    }

    private void cadastrarMembro() {
        System.out.println("Iniciando cadastro de membro...");
        // Aqui você chamaria o código referente ao caso de uso "Cadastrar Membro"
    }

    private void gerarRelatorio() {
        System.out.println("Gerando relatório...");
        // Aqui você chamaria o código referente ao caso de uso "Gerar Relatório"
    }
}
