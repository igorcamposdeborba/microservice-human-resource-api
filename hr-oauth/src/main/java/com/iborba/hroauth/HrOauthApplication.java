package com.iborba.hroauth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients  // fazer chamadas para outras APIs
@EnableEurekaClient // controlador: conectar-se ao gerenciador eureka server para que ele conecte via IP e porta os microservicos
@SpringBootApplication // Habilitar eureka client para se conectar ao eureka server para encontrar as portas de cada projeto baseado no nome
public class HrOauthApplication {

	public static void main(String[] args) {
		SpringApplication.run(HrOauthApplication.class, args);
	}

}
