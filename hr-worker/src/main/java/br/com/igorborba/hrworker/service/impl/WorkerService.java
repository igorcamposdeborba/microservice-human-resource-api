package br.com.igorborba.hrworker.service.impl;

import br.com.igorborba.hrworker.entities.Worker;
import br.com.igorborba.hrworker.entities.dto.WorkerDTO;
import br.com.igorborba.hrworker.repositories.WorkerRepository;
import br.com.igorborba.hrworker.service.IWorkService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class WorkerService implements IWorkService {

    private WorkerRepository workerRepository;

    public WorkerService(WorkerRepository workerRepository) {
        this.workerRepository = workerRepository;
    }

    @Override
    public List<WorkerDTO> findAll() {
        List<Worker> worker = workerRepository.findAll();
        return worker.stream().map(entity -> new WorkerDTO(entity)).collect(Collectors.toList());
    }

    @Override
    public WorkerDTO findByID(Long id) {
        Worker worker = workerRepository.findById(id).orElseThrow(IllegalArgumentException::new);
        return new WorkerDTO(worker);
    }
}
