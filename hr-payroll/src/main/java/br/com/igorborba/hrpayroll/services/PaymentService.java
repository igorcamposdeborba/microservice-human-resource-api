package br.com.igorborba.hrpayroll.services;

import br.com.igorborba.hrpayroll.controller.hrworker.IWorker;
import br.com.igorborba.hrpayroll.entities.Payment;
import br.com.igorborba.hrpayroll.entities.dto.PaymentDTO;
import br.com.igorborba.hrpayroll.entities.hrworker.Worker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    @Autowired
    private IWorker iWorker;

    public PaymentDTO getPayment(Long id, int daysWorked) {
        Worker worker = iWorker.getWorkerById(id).getBody(); // buscar no outro microsserviço

        Payment payment = new Payment(worker.getName(), worker.getDailyIncome(), daysWorked); // aplicar lógica neste microserviço
        return new PaymentDTO(payment);
    }
}
