package br.com.igorborba.hruser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
@EnableDiscoveryClient // Habilitar eureka client para se conectar ao eureka server para encontrar as portas de cada projeto baseado no nome
public class HrUserApplication {

    @Autowired
    private final BCryptPasswordEncoder passwordEncoder;

    public HrUserApplication(BCryptPasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    public static void main(String[] args) {
        SpringApplication.run(HrUserApplication.class, args);
    }

}
