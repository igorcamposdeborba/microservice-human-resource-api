package br.com.igorborba.consumerrabbitmq.entities.dto;

import br.com.igorborba.consumerrabbitmq.entities.Worker;

import java.io.Serializable;

public class WorkerDTO implements Serializable {
    private static final long serialVersionUID = 1L; // transformar o objeto em bytes para trafegar pela rede

    private Long id;
    private String name;
    private Double dailyIncome;

    public WorkerDTO() {}
    public WorkerDTO(Worker worker) {
        this.id = worker.getId();
        this.name = worker.getName();
        this.dailyIncome = worker.getDailyIncome();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getDailyIncome() {
        return dailyIncome;
    }

    public void setDailyIncome(Double dailyIncome) {
        this.dailyIncome = dailyIncome;
    }
}
