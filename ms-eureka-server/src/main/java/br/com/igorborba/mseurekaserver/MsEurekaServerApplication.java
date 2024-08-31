package br.com.igorborba.mseurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer // habilitar eureka server para mapear mapear porta e nome dos microservicos
public class MsEurekaServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsEurekaServerApplication.class, args);
    }

}
