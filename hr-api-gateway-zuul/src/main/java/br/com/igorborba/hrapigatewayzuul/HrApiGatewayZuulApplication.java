package br.com.igorborba.hrapigatewayzuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy // habilitar API Gateway para chamar os microsservicos
@EnableDiscoveryClient // Habilitar eureka client para se conectar ao eureka server para encontrar as portas de cada projeto baseado no nome
public class HrApiGatewayZuulApplication {

    public static void main(String[] args) {
        SpringApplication.run(HrApiGatewayZuulApplication.class, args);
    }

}
