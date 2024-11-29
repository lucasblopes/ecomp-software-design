package models;

import java.util.ArrayList;

// Class Model Projeto
public class Projeto {
    private String titulo;
    private String cliente;
    private String dataInicio;
    private String prazoEntrega;
    private String descricao;
    private String contratoPDF;
    private ArrayList<Etapa> etapas;

    // Construtor padrao
    public Projeto() {

    }

    // Construtor sem contratoPDF
    public Projeto(String titulo, String cliente, String dataInicio, String prazoEntrega, String descricao) {
        this(titulo, cliente, dataInicio, prazoEntrega, descricao, null, new ArrayList<>());
    }

    // Construtor sem etapas
    public Projeto(String titulo, String cliente, String dataInicio, String prazoEntrega, String descricao,
            String contratoPDF) {
        this(titulo, cliente, dataInicio, prazoEntrega, descricao, contratoPDF, new ArrayList<>());
    }

    // Construtor com etapas
    public Projeto(String titulo, String cliente, String dataInicio, String prazoEntrega, String descricao,
            String contratoPDF, ArrayList<Etapa> etapas) {
        setTitulo(titulo);
        setCliente(cliente);
        setDataInicio(dataInicio);
        setPrazoEntrega(prazoEntrega);
        setDescricao(descricao);
        setContratoPDF(contratoPDF);
        setEtapas(etapas);
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    // getters / setters
    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(String dataInicio) {
        this.dataInicio = dataInicio;
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

    public ArrayList<Etapa> getEtapas() {
        return etapas;
    }

    public void setEtapas(ArrayList<Etapa> etapas) {
        this.etapas = etapas;
    }

    // Adiciona Etapa à Lista de Etapas
    public void addEtapa(Etapa etapa) {
        this.etapas.add(etapa);
    }

    // Remove Etapa da Lista de Etapas
    public void removeEtapa(Etapa etapa) {
        this.etapas.remove(etapa);
    }

    // Método de validação dos campos obrigatórios
    public boolean ehValido() {
        return titulo != null && !titulo.isEmpty() && cliente != null && !cliente.isEmpty() &&
                dataInicio != null && !dataInicio.isEmpty() &&
                prazoEntrega != null && !prazoEntrega.isEmpty() &&
                descricao != null && !descricao.isEmpty();
    }
}
