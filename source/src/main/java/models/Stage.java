package models;

import java.util.List;
import java.util.ArrayList;

public class Stage {

    private String schedule;
    private String status;

    // Construtor protected para que apenas ProjectBuilder possa instanciar padrão
    protected Stage(String schedule, String status) {
        this.schedule = schedule;
        this.status = status;
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

    public List<String> validateFields() {
        List<String> erros = new ArrayList<>();

        if (schedule == null || schedule.isEmpty()) {
            erros.add("Cronograma não pode ser vazio.");
        }
        if (status == null || status.isEmpty()) {
            erros.add("Status não pode ser vazio.");
        }

        return erros;
    }

    // Método para acessar o construtor através do ProjectBuilder
    public static StageBuilder builder() {
        return new StageBuilder();
    }
}

