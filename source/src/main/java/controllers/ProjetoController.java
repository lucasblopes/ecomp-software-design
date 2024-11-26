package controllers;

import models.Projeto;
import views.View;

public class ProjetoController {
    private View view;

    public ProjetoController() {
        this.view = new View();
    }

    // Método principal que gerencia o fluxo de cadastro
    public void cadastrarProjeto() {
        // Exibe a tela de cadastro de projeto
        view.showCadastroProjetoScreen();

        // Lê as entradas do usuário
        String cliente = view.getInput();
        String diaInicio = view.getInput();
        String prazoEntrega = view.getInput();
        String descricao = view.getInput();

        // Valida os dados
        Projeto projeto = new Projeto(cliente, diaInicio, prazoEntrega, descricao, null);

        if (!projeto.isValid()) {
            view.showError("Todos os campos devem ser preenchidos.");
            return;
        }

        // Exibe a tela de upload do contrato
        view.showUploadContractScreen();
        String contratoPDF = view.getInput();  // Aqui simula o upload do arquivo

        // Adiciona o contrato ao projeto
        projeto.setContratoPDF(contratoPDF);

        // Simula o cadastro do projeto
        view.showSuccess("Projeto " + projeto.getCliente() + " cadastrado com sucesso!");

        // Exibe a tela inicial após o cadastro
        view.showInitialScreen();
    }
}