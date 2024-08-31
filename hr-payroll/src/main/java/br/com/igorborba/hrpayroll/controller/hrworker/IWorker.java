package br.com.igorborba.hrpayroll.controller.hrworker;

import br.com.igorborba.hrpayroll.entities.hrworker.Worker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component // SpringBoot gerencia ciclo de vida
             // nome do microsservico gerenciado pelo Eureka server: value = "hr-worker"
@FeignClient(value = "hr-worker", path = "/worker") // OpenFeign para fazer chamadas para APIS externas de terceiros
public interface IWorker {

    @GetMapping("/{workerID}")
    ResponseEntity<Worker> getWorkerById(@PathVariable("workerID") Long workerID);
}
