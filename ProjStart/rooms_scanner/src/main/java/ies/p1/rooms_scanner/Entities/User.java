package ies.p1.rooms_scanner.Entities;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "users")
public class User {
    @Id
    private int nmecUser;
    private String username;
    private String email;
    private String role; // ENUM? -> FUNCIONARIO , PROFESSOR OU ESTUDANTE

    // room(id, departamento, andar, numLugaresOcupados, maxSeats)
    public User() {}

    public int getNmecUser() {
        return nmecUser;
    }

    public void setNmecUser(int nmecUser) {
        this.nmecUser = nmecUser;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
