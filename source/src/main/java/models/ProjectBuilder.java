package models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ProjectBuilder {
    private String title;
    private String client;
    private LocalDate startDate;
    private LocalDate deliveryDeadline;
    private String description;
    private String contractPDF;
    private List<Stage> stages;
    private List<Dev> devs;
    private List<Invoice> invoices;

    // Construtor padrão que inicializa a lista de etapas
    public ProjectBuilder() {
        this.stages = new ArrayList<>();
    }

    // Define o título do projeto
    public ProjectBuilder title(String title) {
        this.title = title;
        return this;
    }

    // Define o cliente do projeto
    public ProjectBuilder client(String client) {
        this.client = client;
        return this;
    }

    // Define a data de início do projeto
    public ProjectBuilder startDate(LocalDate startDate) {
        this.startDate = startDate;
        return this;
    }

    // Define o prazo de entrega do projeto
    public ProjectBuilder deliveryDeadline(LocalDate deliveryDeadline) {
        this.deliveryDeadline = deliveryDeadline;
        return this;
    }

    // Define a descrição do projeto
    public ProjectBuilder description(String description) {
        this.description = description;
        return this;
    }

    // Define o arquivo PDF do contrato do projeto
    public ProjectBuilder contractPDF(String contractPDF) {
        this.contractPDF = contractPDF;
        return this;
    }

    // Define as etapas do projeto
    public ProjectBuilder stages(List<Stage> stages) {
        this.stages = stages;
        return this;
    }

    public ProjectBuilder devs(List<Dev> devs) {
        this.devs = devs;
        return this;
    }

    public ProjectBuilder invoices(List<Invoice> invoices) {
        this.invoices = invoices;
        return this;
    }

    // Método para construir o objeto Project
    public Project build() {
        Project project = new Project(title, client, startDate, deliveryDeadline, description, contractPDF, stages, devs, invoices);

        // Valida os campos do projeto
        List<String> errors = project.validateFields();
        if (!errors.isEmpty()) {
            System.out.println("Erro de validação: " + String.join(", ", errors));
            return null;
        }

        return project;
    }
}

