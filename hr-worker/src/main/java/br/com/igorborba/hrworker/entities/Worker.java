package br.com.igorborba.hrworker.entities;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table (name = "tb_worker")
@Tag(name = "Worker", description = "Manage Worker") // descricao no swagger
public class Worker implements Serializable {
    private static final long serialVersionUID = 1L; // transformar o objeto em bytes para trafegar pela rede

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY) // id gerado pelo banco de dados
    @Schema(description = "Database generate the User id") // Anotacao para Swagger
    private Long id;
    private String name;
    private Double dailyIncome;

    public Worker(){}

    public Worker(Long id, String name, Double dailyIncome) {
        this.id = id;
        this.name = name;
        this.dailyIncome = dailyIncome;
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
