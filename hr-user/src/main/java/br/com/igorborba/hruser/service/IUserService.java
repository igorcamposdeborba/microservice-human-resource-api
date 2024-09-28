package br.com.igorborba.hruser.service;

import br.com.igorborba.hruser.entites.dto.UserDTO;

public interface IUserService {

    UserDTO findByID(Long id);

    UserDTO findByEmail(String email);
}
