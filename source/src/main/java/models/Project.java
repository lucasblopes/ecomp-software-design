package models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Projeto {
    private String titulo;
    private String cliente;
    private LocalDate dataInicio;
    private LocalDate prazoEntrega;
    private String descricao;
    private String contratoPDF;
    private List<Etapa> etapas;

    // Construtor protected para que apenas ProjetoBuilder possa instanciar
    protected Projeto(String titulo, String cliente, LocalDate dataInicio, LocalDate prazoEntrega,
            String descricao, String contratoPDF, List<Etapa> etapas) {
        this.titulo = titulo;
        this.cliente = cliente;
        this.dataInicio = dataInicio;
        this.prazoEntrega = prazoEntrega;
        this.descricao = descricao;
        this.contratoPDF = contratoPDF;
        this.etapas = etapas == null ? new ArrayList<>() : etapas; // Evita null
    }

    // Getters (sem setters para garantir imutabilidade)
    public String getTitulo() {
        return titulo;
    }

    public String getCliente() {
        return cliente;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public LocalDate getPrazoEntrega() {
        return prazoEntrega;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getContratoPDF() {
        return contratoPDF;
    }

    public List<Etapa> getEtapas() {
        return etapas;
    }

    // Adiciona Etapa ao projeto
    public void addEtapa(Etapa etapa) {
        if (this.etapas == null) {
            this.etapas = new ArrayList<>();
        }
        this.etapas.add(etapa);
    }

    // Método de validação dos campos com feedback detalhado
    public List<String> validarCampos() {
        List<String> erros = new ArrayList<>();

        if (titulo == null || titulo.isEmpty()) {
            erros.add("Título não pode ser vazio.");
        }
        if (cliente == null || cliente.isEmpty()) {
            erros.add("Cliente não pode ser vazio.");
        }
        if (dataInicio == null) {
            erros.add("Data de Início não pode ser vazia.");
        }
        if (prazoEntrega == null) {
            erros.add("Prazo de Entrega não pode ser vazio.");
        } else if (prazoEntrega.isBefore(dataInicio)) {
            erros.add("O prazo de entrega deve ser maior que a data de início.");
        }
        if (descricao == null || descricao.isEmpty()) {
            erros.add("Descrição não pode ser vazia.");
        }

        return erros;
    }

    // Método para mostrar o projeto
    public void printaProjeto() {
        System.out.println("Título: " + this.titulo);
        System.out.println("Cliente: " + this.cliente);
        System.out.println("Data de Início: " + this.dataInicio);
        System.out.println("Prazo de Entrega: " + this.prazoEntrega);
        System.out.println("Descrição: " + this.descricao);

        if (this.contratoPDF == null)
            System.out.println("Contrato não anexado");
        else
            System.out.println("Contrato: " + this.contratoPDF);

        System.out.println("Etapas:");
        for (Etapa etp : this.etapas) {
            System.out.println("    Cronograma " + etp.getCronograma() + " Status do Projeto: " + etp.getStatus());
        }
    }

    // Método para acessar o construtor através do ProjetoBuilder
    public static ProjetoBuilder builder() {
        return new ProjetoBuilder();
    }
}
