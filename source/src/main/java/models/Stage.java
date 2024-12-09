package models;

public class Stage {

    private String schedule;
    private String status;

    // Construtor padrão
    public Stage() {

    }

    // Getter para o cronograma
    public String getSchedule() {
        return schedule;
    }

    // Getter para o status
    public String getStatus() {
        return status;
    }

    // Setter para o status
    public void setStatus(String status) {
        this.status = status;
    }

    // Setter para o cronograma
    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }
}

