package models;

public class Etapa {

    private String cronograma;
    private String status;

    public Etapa() {

    }

    public String getCronograma() {
        return cronograma;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setCronograma(String cronograma) {
        this.cronograma = cronograma;
    }
}
