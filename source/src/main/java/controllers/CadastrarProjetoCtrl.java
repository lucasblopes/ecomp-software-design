package controllers;

import models.Projeto;
import java.time.LocalDate;
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

        // Coletar titulo do projeto (serve como identificador)
        String titulo = view.inputTitulo();

        // Verifica se já existe um projeto com o título fornecido
        if (projetos.buscarProjeto(titulo).isPresent()) {
            view.showError(
                    "Já existe um projeto com o título '" + titulo + "'. Tente novamente com um título diferente.");
            return;
        }

        // Coletar dados do projeto
        String cliente = view.inputCliente();
        LocalDate dataInicio = view.inputDataInicial();
        LocalDate prazoEntrega = view.inputPrazoEntrega();
        String descricao = view.inputDescricao();

        view.confirmar();

        // Exibe a tela de upload do contrato PDF
        String contratoPDF = view.inputCaminhoContratoPDF();

        // Criação do Projeto usando Builder Pattern
        Projeto projeto = Projeto.builder()
                .titulo(titulo)
                .cliente(cliente)
                .dataInicio(dataInicio)
                .prazoEntrega(prazoEntrega)
                .descricao(descricao)
                .contratoPDF(contratoPDF)
                .build();

        if (projeto == null) {
            view.showError("Projeto " + titulo + " não foi cadastrado!");
            return;
        }

        // Adiciona o projeto à lista
        projetos.adicionarProjeto(projeto);

        view.showSuccess("Projeto " + projeto.getTitulo() + " cadastrado com sucesso!");
    }
}
