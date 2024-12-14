package models;

import java.util.List;

public class StageBuilder {
    private String schedule;
    private String status;

    public StageBuilder schedule (String schedule) {
        this.schedule = schedule;
        return this;
    }

    public StageBuilder status (String status) {
        this.status = status;
        return this;
    }

    public Stage build() {
        Stage stage = new Stage(schedule, status);

        List<String> errors = stage.validateFields();
        if (!errors.isEmpty()) {
            System.out.println("Erro de validação: " + String.join(", ", errors));
            return null;
        }

        return stage;
    }
}