package ies.p1.rooms_scanner.Entities;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;


@Entity
@Table(name = "user")
public class User {
    @Id
    private int nmecUser;
    @NotBlank(message = "Enter your username")
    private String username;
    @NotBlank(message = "Enter your email")
    private String email;
    @NotBlank(message = "Enter your password")
    private String password;
    @NotBlank(message = "Enter your role (Student, Teacher, Employee)")
    private String role; // ENUM? -> FUNCIONARIO , PROFESSOR OU ESTUDANTE

    // room(id, departamento, andar, numLugaresOcupados, maxSeats)
    public User() {}

    public User(int nmecUser, String username, String email, String password, String role) {
    }

    public int getNmecUser() {
        return nmecUser;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }

}
