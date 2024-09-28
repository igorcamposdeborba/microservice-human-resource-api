package br.com.igorborba.hroauth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients // fazer chamadas para outras APIs
@EnableDiscoveryClient // Habilitar eureka client para se conectar ao eureka server para encontrar as portas de cada projeto baseado no nome
public class HrOauthApplication {

    public static void main(String[] args) {
        SpringApplication.run(HrOauthApplication.class, args);
    }

}
