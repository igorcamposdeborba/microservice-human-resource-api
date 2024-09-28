package br.com.igorborba.hrpayroll.services.impl;

import br.com.igorborba.hrpayroll.controller.hrworker.IWorker;
import br.com.igorborba.hrpayroll.entities.Payment;
import br.com.igorborba.hrpayroll.entities.dto.PaymentDTO;
import br.com.igorborba.hrpayroll.entities.hrworker.Worker;
import br.com.igorborba.hrpayroll.services.IPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService implements IPaymentService {

//    @Autowired
    private IWorker iWorker;

    public PaymentService(IWorker iWorker) {
        this.iWorker = iWorker;
    }

    @Override
    public PaymentDTO getPayment(Long id, int daysWorked) {

        Worker worker = iWorker.getWorkerById(id).getBody(); // buscar no outro microsserviço

        Payment payment = new Payment(worker.getName(), worker.getDailyIncome(), daysWorked); // aplicar lógica neste microserviço
        return new PaymentDTO(payment);
    }
}
