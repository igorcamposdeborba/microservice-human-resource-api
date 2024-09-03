package br.com.igorborba.hrworker.controller;

import br.com.igorborba.hrworker.entities.dto.WorkerDTO;
import br.com.igorborba.hrworker.service.impl.WorkerService;
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

    private static Logger logger = Logger.getLogger(WorkerController.class.getName());

    WorkerService workerService;

    public WorkerController(WorkerService workerService){
        this.workerService = workerService;
    }

    @GetMapping(value = { "", "/"})
    public ResponseEntity<List<WorkerDTO>> findAll(){
        List<WorkerDTO> workers = workerService.findAll();
        return ResponseEntity.ok(workers);
    }

    @GetMapping(value = ID)
    public ResponseEntity<WorkerDTO> findById(@PathVariable Long id){
        WorkerDTO worker = workerService.findByID(id);
        return ResponseEntity.ok(worker);
    }

    @GetMapping(value = "/configs")
    public ResponseEntity<Void> getConfigs(){
        logger.info("Config = " + Arrays.stream(environment.getActiveProfiles()).collect(Collectors.toList())); // imprimir em tela os perfis ativos no microsserviço config-server
        return ResponseEntity.noContent().build();
    }

}
