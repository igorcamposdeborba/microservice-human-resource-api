package br.com.igorborba.hrworker.controller;

import br.com.igorborba.hrworker.entities.Worker;
import br.com.igorborba.hrworker.entities.dto.WorkerDTO;
import br.com.igorborba.hrworker.repositories.WorkerRepository;
import br.com.igorborba.hrworker.service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/worker")
public class WorkerController {
    private static final String ID = "/{id}";

    @Autowired
    WorkerService workerService;

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
}
