package br.com.igorborba.hrworker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import javax.servlet.annotation.WebServlet;

@SpringBootApplication
@EnableDiscoveryClient // Habilitar eureka client para se conectar ao eureka server para encontrar as portas de cada projeto baseado no nome
public class HrWorkerApplication {

	public static void main(String[] args) {
		SpringApplication.run(HrWorkerApplication.class, args);
	}

}
