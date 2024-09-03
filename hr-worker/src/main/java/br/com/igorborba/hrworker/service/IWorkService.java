package br.com.igorborba.hrworker.service;

import br.com.igorborba.hrworker.entities.dto.WorkerDTO;

import java.util.List;

public interface IWorkService {

    List<WorkerDTO> findAll();
    WorkerDTO findByID(Long id);
}
