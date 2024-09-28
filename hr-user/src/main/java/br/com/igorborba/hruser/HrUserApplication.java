package br.com.igorborba.hruser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient // Habilitar eureka client para se conectar ao eureka server para encontrar as portas de cada projeto baseado no nome
public class HrUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(HrUserApplication.class, args);
    }

}
