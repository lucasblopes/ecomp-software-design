package models;

import java.util.ArrayList;
import java.util.List;

public class Activity {

    private String name;
    private int durationMinutes;
    private String location;
    private List<String> participants;
    private String goal;
    private String summary;
    private List<Invoice> invoices;

    public Activity() {
    }

    public Activity(String name, int durationMinutes, String location, List<String> participants, String goal, String summary, List<Invoice> invoices) {
        this.name = name;
        this.durationMinutes = durationMinutes;
        this.location = location;
        this.participants = participants;
        this.goal = goal;
        this.summary = summary;
        this.invoices = invoices;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDurationMinutes() {
        return durationMinutes;
    }

    public void setDurationMinutes(int durationMinutes) {
        this.durationMinutes = durationMinutes;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<String> getParticipants() {
        return participants;
    }

    public void setParticipants(List<String> participants) {
        this.participants = participants;
    }

    public List<Invoice> getInvoices() {
        return invoices;
    }

    public void setInvoices(List<Invoice> invoices) {
        this.invoices = invoices;
    }

    public String getGoal() {
        return goal;
    }

    public void setGoal(String goal) {
        this.goal = goal;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public void addInvoice(Invoice invoice) {
        if (this.invoices == null) {
            this.invoices = new ArrayList<>();
        }
        this.invoices.add(invoice);
    }

    @Override
    public String toString() {
        return "Nome: '" + name + '\'' + "\n" +
            "Duração (em minutos): " + durationMinutes + "\n" +
            "Localização: '" + location + '\'' + "\n" +
            "Participantes: " + participants + "\n" +
            "Objetivo: '" + goal + '\'' + "\n" +
            "Resumo: '" + summary + '\'' + "\n" +
            (invoices != null && !invoices.isEmpty() ? 
                "=== Notas Fiscais e Recibos ===\n" +
                invoices.stream()
                        .map(invoice -> "    Data: " + invoice.getDate() + " Valor: " + invoice.getValue() + " Tipo: " + invoice.getType())
                        .reduce("", (a, b) -> a + b + "\n") : "=== Notas Fiscais e Recibos ===\nNenhuma nota fiscal associada.");
    }
}
