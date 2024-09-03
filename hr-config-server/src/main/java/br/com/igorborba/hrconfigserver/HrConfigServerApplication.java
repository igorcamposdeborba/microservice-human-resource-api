package br.com.igorborba.hrconfigserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer // Habilitar para que todos os projetos busquem a configuração neste microservico
public class HrConfigServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(HrConfigServerApplication.class, args);
    }

}
