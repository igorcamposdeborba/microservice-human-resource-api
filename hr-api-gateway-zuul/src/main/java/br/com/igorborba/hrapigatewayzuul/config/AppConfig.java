package br.com.igorborba.hrapigatewayzuul.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@RefreshScope // atualizar valores das variáveis com o actuator em tempo de execucao
@Configuration
public class AppConfig {

    @Value("${jwt.secret}") // pegar chave do application.properties do github: https://github.com/igorcamposdeborba/microservice-human-resource-api/blob/main/application.properties
    private String jwtSecret;

    @Bean
    public JwtAccessTokenConverter accessTokenConverter() {
        JwtAccessTokenConverter tokenConverter = new JwtAccessTokenConverter();
        tokenConverter.setSigningKey(jwtSecret);
        return tokenConverter;
    }

    @Bean
    public JwtTokenStore tokenStore() {
        return new JwtTokenStore(accessTokenConverter());
    }
}
