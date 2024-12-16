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
    private List<Invoice> invoices;

    // Construtor protected para que apenas ProjectBuilder possa instanciar
    protected Project(String title, String client, LocalDate startDate, LocalDate deliveryDeadline,
                      String description, String contractPDF, List<Stage> stages, List<Dev> devs, List<Invoice> invoices) {
        this.title = title;
        this.client = client;
        this.startDate = startDate;
        this.deliveryDeadline = deliveryDeadline;
        this.description = description;
        this.contractPDF = contractPDF;
        this.stages = stages == null ? new ArrayList<>() : stages; // Evita null
        this.devs = devs == null ? new ArrayList<>() : devs;
        this.invoices = invoices == null ? new ArrayList<>() : invoices;
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

    public List<Invoice> getInvoices() { return invoices; }

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

    public void addInvoice(Invoice invoice) {
        if (this.invoices == null) {
            this.invoices = new ArrayList<>();
        }
        this.invoices.add(invoice);
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

    @Override
    public String toString() {
        return "Título: '" + title + '\'' + "\n" +
               "Cliente: '" + client + '\'' + "\n" +
               "Data de Início: '" + startDate + '\'' + "\n" +
               "Prazo de Entrega: '" + deliveryDeadline + '\'' + "\n" +
               "Descrição: '" + description + '\'' + "\n" +
               "Contrato: '" + (contractPDF == null ? "Contrato não anexado" : contractPDF) + '\'' + "\n" +
               
               (stages != null && !stages.isEmpty() ? 
                   "=== Etapas ===\n" +
                   stages.stream()
                         .map(stage -> "    Cronograma: " + stage.getSchedule() + " Status do Projeto: " + stage.getStatus())
                         .reduce("", (a, b) -> a + b + "\n") : "") +
    
               (invoices != null && !invoices.isEmpty() ? 
                   "=== Notas Fiscais e Recibos ===\n" +
                   invoices.stream()
                           .map(invoice -> "    Data: " + invoice.getDate() + " Valor: " + invoice.getValue() + " Tipo: " + invoice.getType())
                           .reduce("", (a, b) -> a + b + "\n") : "=== Notas Fiscais e Recibos === Nenhuma nota fiscal associada.") +
    
               (devs != null && !devs.isEmpty() ? 
                   "=== Desenvolvedores ===\n" +
                   devs.stream()
                       .map(dev -> "    Nome: " + dev.getMember().getName())
                       .reduce("", (a, b) -> a + b + "\n") : "=== Desenvolvedores === Nenhum desenvolvedor associado.");
    }
    
    
    // Método para acessar o construtor através do ProjectBuilder
    public static ProjectBuilder builder() {
        return new ProjectBuilder();
    }
}

