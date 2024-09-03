package br.com.igorborba.hrpayroll.services;

import br.com.igorborba.hrpayroll.entities.dto.PaymentDTO;

public interface IPaymentService {

    PaymentDTO getPayment(Long id, int daysWorked);
}
