package models;

import java.util.ArrayList;

// Classe Model que representa o Projeto
public class Projeto {
    private String titulo;
    private String cliente;
    private String diaInicio;
    private String prazoEntrega;
    private String descricao;
    private String contratoPDF;
    private ArrayList<Etapa> etapas;

    // Construtor
    public Projeto(String titulo, String cliente, String diaInicio, String prazoEntrega, String descricao,
            String contratoPDF) {
        this.titulo = titulo;
        this.cliente = cliente;
        this.diaInicio = diaInicio;
        this.prazoEntrega = prazoEntrega;
        this.descricao = descricao;
        this.contratoPDF = contratoPDF;
    }

    // Métodos getters e setters
    public String getTitulo() {
        return titulo;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getDiaInicio() {
        return diaInicio;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setDiaInicio(String diaInicio) {
        this.diaInicio = diaInicio;
    }

    public String getPrazoEntrega() {
        return prazoEntrega;
    }

    public void setPrazoEntrega(String prazoEntrega) {
        this.prazoEntrega = prazoEntrega;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getContratoPDF() {
        return contratoPDF;
    }

    public void setContratoPDF(String contratoPDF) {
        this.contratoPDF = contratoPDF;
    }

    // Método de validação dos campos obrigatórios
    public boolean isValid() {
        return titulo != null && !titulo.isEmpty() && cliente != null && !cliente.isEmpty() &&
                diaInicio != null && !diaInicio.isEmpty() &&
                prazoEntrega != null && !prazoEntrega.isEmpty() &&
                descricao != null && !descricao.isEmpty();
    }
}
