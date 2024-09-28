package br.com.igorborba.hruser.controller;

import br.com.igorborba.hruser.entites.dto.UserDTO;
import br.com.igorborba.hruser.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

@RefreshScope //atualizar configurações quando o servidor de configuracao ser atualizado
@RestController
@RequestMapping(value = "/user")
public class UserController {
    private static final String ID = "/{id}";

    @Autowired
    private Environment environment; // contexto da aplicacao spring boot

    private static Logger logger = Logger.getLogger(UserController.class.getName());

    @Autowired
    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = ID)
    public ResponseEntity<UserDTO> findById(@PathVariable Long id) {
        UserDTO user = userService.findByID(id);
        return ResponseEntity.ok(user);
    }

    @GetMapping(value = "/search")
    public ResponseEntity<UserDTO> findByEmail(@RequestParam String email) {
        UserDTO user = userService.findByEmail(email);
        return ResponseEntity.ok(user);
    }
}
