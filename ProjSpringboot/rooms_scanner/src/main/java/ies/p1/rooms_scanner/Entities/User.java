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
<<<<<<< Updated upstream
    @NotBlank(message = "Enter your password")
    private String password;
    @NotBlank(message = "Enter your role (Student, Teacher, Employee)")
    private String role;
=======
    @NotBlank(message = "Enter your role")
    private String role;

>>>>>>> Stashed changes

    public User() {}

    public User(int nmecUser, String username, String email, String password, String role) {
        this.nmecUser = nmecUser;
        this.username = username;
        this.email = email;
        this.password = password;
        this.role = role;
    }

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

<<<<<<< Updated upstream
    public String getPassword() {
        return password;
=======
    public void setEmail(String email) {
        this.email = email;
>>>>>>> Stashed changes
    }

    public String getRole() {
        return role;
    }
<<<<<<< Updated upstream
=======

    public void setRole(String role) {
        this.role = role;
    }

    @java.lang.Override
    public String toString() {
        return "User{" +
                "nmecUser=" + nmecUser +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
>>>>>>> Stashed changes
}
