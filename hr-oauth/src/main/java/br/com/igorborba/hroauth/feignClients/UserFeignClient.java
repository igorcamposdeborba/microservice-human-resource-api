package br.com.igorborba.hroauth.feignClients;

import br.com.igorborba.hroauth.entities.UserDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Component // componente gerenciado pelo spring boot
@FeignClient (name = "hr-user", path = "/user") // comunicar-se com o microsservico hr-user no path do endpoint /user
public interface UserFeignClient {

    @GetMapping(value = "/search")
    public ResponseEntity<UserDTO> findByEmail(@RequestParam String email);
}
