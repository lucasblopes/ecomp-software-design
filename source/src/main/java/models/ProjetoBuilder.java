package models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ProjetoBuilder {
    private String titulo;
    private String cliente;
    private LocalDate dataInicio;
    private LocalDate prazoEntrega;
    private String descricao;
    private String contratoPDF;
    private List<Etapa> etapas;

    public ProjetoBuilder() {
        this.etapas = new ArrayList<>();
    }

    public ProjetoBuilder titulo(String titulo) {
        this.titulo = titulo;
        return this;
    }

    public ProjetoBuilder cliente(String cliente) {
        this.cliente = cliente;
        return this;
    }

    public ProjetoBuilder dataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
        return this;
    }

    public ProjetoBuilder prazoEntrega(LocalDate prazoEntrega) {
        this.prazoEntrega = prazoEntrega;
        return this;
    }

    public ProjetoBuilder descricao(String descricao) {
        this.descricao = descricao;
        return this;
    }

    public ProjetoBuilder contratoPDF(String contratoPDF) {
        this.contratoPDF = contratoPDF;
        return this;
    }

    public ProjetoBuilder etapas(List<Etapa> etapas) {
        this.etapas = etapas;
        return this;
    }

    // Método para construir o objeto Projeto
    public Projeto build() {
        Projeto projeto = new Projeto(titulo, cliente, dataInicio, prazoEntrega, descricao, contratoPDF, etapas);

        // Valida os campos do projeto
        List<String> erros = projeto.validarCampos();
        if (!erros.isEmpty()) {
            System.out.println("Erro de validação: " + String.join(", ", erros));
            return null;
        }

        return projeto;
    }
}
