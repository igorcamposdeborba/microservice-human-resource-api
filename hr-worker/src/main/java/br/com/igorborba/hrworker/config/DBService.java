package br.com.igorborba.hrworker.config;

import br.com.igorborba.hrworker.entities.Worker;
import br.com.igorborba.hrworker.repositories.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Arrays;

@Service // injetar instancias em outras partes do código
public class DBService {

    @Autowired
    private WorkerRepository workerRepository;

    public void instantiateDataBase() {
        // Instanciar objetos para pré-popular o banco de dados
        Worker worker1 = new Worker(1L, "Igor", 200.0);
        Worker worker2 =new Worker(2L, "Andressa", 300.0);
        Worker worker3 = new Worker(3L, "Luiza", 250.0);

        workerRepository.saveAll(Arrays.asList(worker1, worker2, worker3));
    }
}
