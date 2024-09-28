package br.com.igorborba.hruser.service.impl;

import br.com.igorborba.hruser.entites.User;
import br.com.igorborba.hruser.entites.dto.UserDTO;
import br.com.igorborba.hruser.repositories.UserRepository;
import br.com.igorborba.hruser.service.IUserService;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDTO findByID(Long id) {
        User user = userRepository.findById(id).orElseThrow(IllegalArgumentException::new);
        return new UserDTO(user);
    }

    @Override
    public UserDTO findByEmail(String email) {
        User user = userRepository.findByEmail(email);
        if (user.equals(null) || user.getEmail() == null) {
            throw new IllegalArgumentException("Usuário não encontrado");
        }
        return new UserDTO(user);
    }
}
