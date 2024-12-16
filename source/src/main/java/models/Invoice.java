package models;

import java.util.List;
import java.util.ArrayList;
import java.time.LocalDate;

public class Invoice {

    private LocalDate date;
    private Integer value;
    private String type;

    public Invoice(LocalDate date, Integer value, String type) {
        this.date = date;
        this.value = value;
        this.type = type;
    }

    // Getter para o date
    public LocalDate getDate() {
        return this.date;
    }

    // Getter para o value
    public Integer getValue() {
        return this.value;
    }

    // Getter para o type
    public String getType() {
        return this.type; }

    // Setter para o date
    public void setDate(LocalDate date) {
        this.date = date;
    }

    // Setter para o value
    public void setValue(Integer value) {
        this.value = value;
    }

    //Setter para o type
    public void setType(String type) {
        this.type = type;
    }

    public List<String> validateFields() {
        List<String> erros = new ArrayList<>();

        if (this.date == null) {
            erros.add("Data não pode ser vazio.");
        }
        if (this.value == null) {
            erros.add("Valor não pode ser vazio.");
        }

        if (this.type == null || this.type.isEmpty()) {
            erros.add("Tipo não pode ser vazio.");
        }

        return erros;
    }
}

