package br.com.igorborba.hrpayroll.entities.dto;

import br.com.igorborba.hrpayroll.entities.Payment;

public class PaymentDTO {

    private String name;
    private Double dailyIncome;
    private Integer days;
    private Double total;

    public PaymentDTO() {}
    public PaymentDTO(String name, Double dailyIncome, Integer days) {
        this.name = name;
        this.dailyIncome = dailyIncome;
        this.days = days;
    }
    public PaymentDTO(Payment payment){
        this.name = payment.getName();
        this.dailyIncome = payment.getDailyIncome();
        this.days = payment.getDays();
        this.total = payment.getTotal();
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

    public Integer getDays() {
        return days;
    }

    public void setDays(Integer days) {
        this.days = days;
    }

    public Double getTotal(){
        return dailyIncome * days;
    }
}
