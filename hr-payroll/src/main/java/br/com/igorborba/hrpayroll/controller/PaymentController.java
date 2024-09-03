package br.com.igorborba.hrpayroll.controller;
import br.com.igorborba.hrpayroll.entities.dto.PaymentDTO;
import br.com.igorborba.hrpayroll.services.impl.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
@RequestMapping(value = "/payment")
public class PaymentController {

    private static Logger log = Logger.getLogger(PaymentController.class.getName());

    @Autowired
    private PaymentService paymentService;

    @Autowired
    private Environment environment; // contexto da aplicacao spring boot

    @HystrixCommand(fallbackMethod = "getPaymentAlternative") // Hystrix: metodo alternativo (default) em caso de exception no outro microsservico
    @GetMapping(value = "/{workerID}/days/{daysWorked}")
    public ResponseEntity<PaymentDTO> getPayment(@PathVariable("workerID") Long workerID, @PathVariable("daysWorked") Integer daysWorked) {
        log.info("PORT = " + environment.getProperty("local.server.port")); // imprimir a porta do loadbalancer atual

        PaymentDTO payment = paymentService.getPayment(workerID, daysWorked);
        return ResponseEntity.ok(payment);
    }

    public ResponseEntity<PaymentDTO> getPaymentAlternative(Long workerID, Integer daysWorked){
        PaymentDTO paymentDTO = new PaymentDTO("Default", 400.0, daysWorked);
        return ResponseEntity.ok(paymentDTO);
    }
}
