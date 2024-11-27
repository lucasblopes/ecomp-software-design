package controllers;

import models.Projeto;
import views.CadastrarProjetoView;
import java.util.ArrayList;

public class CadastrarProjetoCtrl {
    private CadastrarProjetoView view;
    private ArrayList<Projeto> projetos;

    public CadastrarProjetoCtrl(ArrayList<Projeto> projetos) {
        this.view = new CadastrarProjetoView();
        this.projetos = projetos;
    }

    // Método principal que gerencia o fluxo de cadastro
    public void cadastrarProjeto() {
        // Exibe a tela de cadastro de projeto
        view.showCadastroProjetoScreen();
        view.limparTela();

        String titulo = view.inputTitulo();

        // Verifica se o título do projeto já existe na lista
        if (isTituloDuplicado(titulo)) {
            view.showError("Já existe um projeto com esse título. Tente novamente com um título diferente.");
            view.continuar();
            return;
        }

        String cliente = view.inputCliente();
        String diaInicio = view.inputDataInicial();
        String prazoEntrega = view.inputPrazoEntrega();
        String descricao = view.inputDescricao();

        view.confirmar();
        view.limparTela();

        // Valida os dados
        Projeto projeto = new Projeto(titulo, cliente, diaInicio, prazoEntrega, descricao, null);

        if (!projeto.isValid()) {
            view.showError("Todos os campos devem ser preenchidos.");
            return;
        }

        // Exibe a tela de upload do contrato
        String contratoPDF = view.inputCaminhoContrato();

        if (!contratoPDF.equals("")) {
            view.mostrarTelaContratoImportado(contratoPDF);
        }

        view.confirmar();
        view.limparTela();

        // Adiciona o contrato ao projeto
        projeto.setContratoPDF(contratoPDF);

        // Adiciona o projeto à lista
        cadastrarProjeto(projeto);

        // Cadastra o projeto
        view.showSuccess("Projeto " + projeto.getTitulo() + " cadastrado com sucesso!");

        // Exibe a tela inicial após o cadastro
        // view.showInitialScreen();
    }

    // Adiciona o projeto à lista de Projetos
    public void cadastrarProjeto(Projeto projeto) {
        projetos.add(projeto);
    }

    // Verifica se o título do projeto já existe
    public boolean isTituloDuplicado(String titulo) {
        for (Projeto p : projetos) {
            if (p.getTitulo().equalsIgnoreCase(titulo)) {
                return true; // Título duplicado
            }
        }
        return false; // Título único
    }
}
