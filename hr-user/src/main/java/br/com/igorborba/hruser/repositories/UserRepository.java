package br.com.igorborba.hruser.repositories;

import br.com.igorborba.hruser.entites.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);
}
