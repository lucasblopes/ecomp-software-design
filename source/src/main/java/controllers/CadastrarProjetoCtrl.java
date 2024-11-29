package controllers;

import models.Projeto;
import repositories.ProjetoRepository;
import views.CadastrarProjetoView;

public class CadastrarProjetoCtrl {
    private CadastrarProjetoView view;

    public CadastrarProjetoCtrl() {
        this.view = new CadastrarProjetoView();
    }

    // Método principal que gerencia o fluxo de cadastro
    public void cadastrarProjeto(ProjetoRepository projetos) {
        // Exibe a tela de cadastro de projeto
        view.showCadastroProjetoScreen();

        String titulo = view.inputTitulo();

        // Verifica se já existe um projeto com o título fornecido
        if (projetos.buscarProjeto(titulo).isPresent()) {
            view.showError(
                    "Já existe um projeto com o título '" + titulo + "'. Tente novamente com um título diferente.");
            return;
        }

        // Coletar dados do projeto
        String cliente = view.inputCliente();
        String dataInicio = view.inputDataInicial();
        String prazoEntrega = view.inputPrazoEntrega();
        String descricao = view.inputDescricao();

        view.confirmar();

        // Valida os dados
        Projeto projeto = new Projeto(titulo, cliente, dataInicio, prazoEntrega, descricao);
        if (!projeto.ehValido()) {
            view.showError("Todos os campos devem ser preenchidos.");
            return;
        }

        // Exibe a tela de upload do contrato PDF
        String contratoPDF = view.inputCaminhoContratoPDF();
        if (!contratoPDF.isEmpty()) {
            projeto.setContratoPDF(contratoPDF);
        }

        // Adiciona o projeto à lista
        projetos.adicionarProjeto(projeto);

        view.showSuccess("Projeto " + projeto.getTitulo() + " cadastrado com sucesso!");
    }
}
