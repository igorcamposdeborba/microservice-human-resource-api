package br.com.igorborba.hrapigatewayzuul.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@Configuration
@EnableResourceServer // Indica que este Microsservico é um resource server (pega recursos/arquivos) dos microsservicos
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {
    @Autowired
    private JwtTokenStore tokenStore;

    private static final String [] PUBLIC = { "/hr-oauth/oauth/token" }; // rota para fazer autenticacao: pública

    private static final String [] OPERATOR = { "/hr-worker/**" }; // rota disponível para quem tem role de operador

    private static final String [] ADMIN = { "/hr-payroll/**", "/hr-user/**" }; // rota disponível para quem tem role de admin

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        resources.tokenStore(tokenStore); // projeto lê o token
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers(PUBLIC).permitAll()
                .antMatchers(HttpMethod.GET, OPERATOR).hasAnyRole("OPERATOR", "ADMIN")
                .antMatchers(ADMIN).hasAnyRole("ADMIN")
                .anyRequest().authenticated();
    }
}
