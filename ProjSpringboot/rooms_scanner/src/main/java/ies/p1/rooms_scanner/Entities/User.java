package ies.p1.rooms_scanner.Entities;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "users")
public class User {
    @Id
    private int nmec;
    private String username;
    private String email;
    private String role;

    // room(id, departamento, andar, numLugaresOcupados, maxSeats)
    public User() {}

    public int getNmecUser() {
        return nmec;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getRole() {
        return role;
    }

}
