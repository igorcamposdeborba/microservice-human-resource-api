package br.com.igorborba.hrworker.repositories;

import br.com.igorborba.hrworker.entities.Worker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkerRepository extends JpaRepository<Worker, Long> { // entidade, id da primary key

}
