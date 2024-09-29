package br.com.igorborba.hrworker.controller;

import br.com.igorborba.hrworker.config.RabbitMQConstants;
import br.com.igorborba.hrworker.entities.dto.WorkerDTO;
import br.com.igorborba.hrworker.service.impl.WorkerService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@RefreshScope //atualizar configurações quando o servidor de configuracao ser atualizado
@RestController
@RequestMapping(value = "/worker")
public class WorkerController {
    private static final String ID = "/{id}";

    @Autowired
    private Environment environment; // contexto da aplicacao spring boot

    @Autowired
    private RabbitmqService rabbitmqService; // RabbitMQ para enviar mensagem
    @Autowired
    private ObjectMapper objectMapper;

    private static Logger logger = Logger.getLogger(WorkerController.class.getName());

    WorkerService workerService;

    public WorkerController(WorkerService workerService){
        this.workerService = workerService;
    }

    // Swagger: para testar endpoint e documentar
    @Operation(
            description = "Get all workes",
            summary = "The workers are going to retrieved from Worker repository",
            responses = {
                    @ApiResponse(description = "Ok", responseCode = "200")
            }
    )
    @GetMapping(value = { "", "/"})
    public ResponseEntity<List<WorkerDTO>> findAll(){
        List<WorkerDTO> workers = workerService.findAll();
        try {
            String workersJson = objectMapper.writeValueAsString(workers);
            rabbitmqService.sendMessage(RabbitMQConstants.WORKER_QUEUE, workersJson); // RabbitMQ: envia mensagem JSON
        } catch (JsonProcessingException e) {
            e.printStackTrace(); // Tratamento de erro na conversão para JSON
        }
        return ResponseEntity.ok(workers);
    }

    @Operation(
            description = "Get worker by Id",
            summary = "Get specific worker from Worker repository",
            responses = {
                    @ApiResponse(description = "Ok", responseCode = "200"),
                    @ApiResponse(description = "Not found", responseCode = "404")
            }
    )
    @GetMapping(value = ID)
    public ResponseEntity<WorkerDTO> findById(@PathVariable Long id){
        WorkerDTO worker = workerService.findByID(id);
        try {
            String workerJson = objectMapper.writeValueAsString(worker);
            rabbitmqService.sendMessage(RabbitMQConstants.WORKER_QUEUE, workerJson); // RabbitMQ: envia mensagem JSON
        } catch (JsonProcessingException e) {
            e.printStackTrace(); // Tratamento de erro na conversão para JSON
        }
        return ResponseEntity.ok(worker);
    }

    @Operation(
            description = "Get active profile",
            summary = "Get specific configs about the active profile",
            responses = {
                    @ApiResponse(description = "Ok", responseCode = "200")
            }
    )
    @GetMapping(value = "/configs")
    public ResponseEntity<Void> getConfigs(){
        logger.info("Config = " + Arrays.stream(environment.getActiveProfiles()).collect(Collectors.toList())); // imprimir em tela os perfis ativos no microsserviço config-server
        return ResponseEntity.noContent().build();
    }

}
