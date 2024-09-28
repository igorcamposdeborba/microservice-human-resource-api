package br.com.igorborba.hruser.entites;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Role implements Serializable {
    private static final long serialVersionUID = 1L; // transformar o objeto em bytes para trafegar pela rede

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // id gerado pelo banco de dados
    private Long id;
    private String roleName;

    @ManyToMany(mappedBy = "roles") // Associação gerenciada pela outra classe
    private Set<User> users = new HashSet<>();

    public Role(Long id, String roleName) {
        this.id = id;
        this.roleName = roleName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Role role = (Role) o;
        return Objects.equals(roleName, role.roleName);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(roleName);
    }
}
