package br.com.igorborba.hroauth.services;

import br.com.igorborba.hroauth.entities.UserDTO;
import br.com.igorborba.hroauth.feignClients.UserFeignClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserFeignClient userFeignClient;

    Logger logger = LoggerFactory.getLogger(UserService.class);

    public UserDTO findByEmail(String email) {

        UserDTO user = userFeignClient.findByEmail(email).getBody();// buscar no microsservicos hr-user o usuário
        if (user.equals(null)){
            logger.error("E-mail não encontrado " + email);
            throw new IllegalArgumentException("Usuário não encontrado: ");
        }
        logger.info("E-mail encontrado: " + email);
        return user;
    }
}
