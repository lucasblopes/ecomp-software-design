package models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Project {

    private String title;
    private String client;
    private LocalDate startDate;
    private LocalDate deliveryDeadline;
    private String description;
    private String contractPDF;
    private List<Stage> stages;
    private List<Dev> devs;

    // Construtor protected para que apenas ProjectBuilder possa instanciar
    protected Project(String title, String client, LocalDate startDate, LocalDate deliveryDeadline,
                      String description, String contractPDF, List<Stage> stages, List<Dev> devs) {
        this.title = title;
        this.client = client;
        this.startDate = startDate;
        this.deliveryDeadline = deliveryDeadline;
        this.description = description;
        this.contractPDF = contractPDF;
        this.stages = stages == null ? new ArrayList<>() : stages; // Evita null
        this.devs = devs == null ? new ArrayList<>() : devs;
    }

    // Getters (sem setters para garantir imutabilidade)
    public String getTitle() {
        return title;
    }

    public String getClient() {
        return client;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getDeliveryDeadline() {
        return deliveryDeadline;
    }

    public String getDescription() {
        return description;
    }

    public String getContractPDF() {
        return contractPDF;
    }

    public List<Stage> getStages() {
        return stages;
    }

    public List<Dev> getDevs() {
        return devs;
    }

    // Adiciona Stage ao projeto
    public void addStage(Stage stage) {
        if (this.stages == null) {
            this.stages = new ArrayList<>();
        }
        this.stages.add(stage);
    }

    public void addDev(Dev dev) {
        this.devs.add(dev);         
    }

    // Método de validação dos campos com feedback detalhado
    public List<String> validateFields() {
        List<String> erros = new ArrayList<>();

        if (title == null || title.isEmpty()) {
            erros.add("Título não pode ser vazio.");
        }
        if (client == null || client.isEmpty()) {
            erros.add("Cliente não pode ser vazio.");
        }
        if (startDate == null) {
            erros.add("Data de Início não pode ser vazia.");
        }
        if (deliveryDeadline == null) {
            erros.add("Prazo de Entrega não pode ser vazio.");
        } else if (deliveryDeadline.isBefore(startDate)) {
            erros.add("O prazo de entrega deve ser maior que a data de início.");
        }
        if (description == null || description.isEmpty()) {
            erros.add("Descrição não pode ser vazia.");
        }

        return erros;
    }

    // Método para mostrar o projeto
    public void printProject() {

        System.out.println("Título: " + this.title);
        System.out.println("Cliente: " + this.client);
        System.out.println("Data de Início: " + this.startDate);
        System.out.println("Prazo de Entrega: " + this.deliveryDeadline);
        System.out.println("Descrição: " + this.description);

        if (this.contractPDF == null)
            System.out.println("Contrato não anexado");
        else
            System.out.println("Contrato: " + this.contractPDF);

        System.out.println("Etapas:");
        for (Stage stage : this.stages) {
            System.out.println("    Cronograma " + stage.getSchedule() + " Status do Projeto: " + stage.getStatus());
        }
    }

    // Método para acessar o construtor através do ProjectBuilder
    public static ProjectBuilder builder() {
        return new ProjectBuilder();
    }
}

