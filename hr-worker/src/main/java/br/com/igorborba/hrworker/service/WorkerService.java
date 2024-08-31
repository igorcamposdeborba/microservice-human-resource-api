package br.com.igorborba.hrworker.service;

import br.com.igorborba.hrworker.controller.WorkerController;
import br.com.igorborba.hrworker.entities.Worker;
import br.com.igorborba.hrworker.entities.dto.WorkerDTO;
import br.com.igorborba.hrworker.repositories.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class WorkerService {

    @Autowired
    private WorkerRepository workerRepository;

    public List<WorkerDTO> findAll() {
        List<Worker> worker = workerRepository.findAll();
        return worker.stream().map(entity -> new WorkerDTO(entity)).collect(Collectors.toList());
    }

    public WorkerDTO findByID(Long id) {
        Worker worker = workerRepository.findById(id).filter(Objects::nonNull).get();
        return new WorkerDTO(worker);
    }
}
