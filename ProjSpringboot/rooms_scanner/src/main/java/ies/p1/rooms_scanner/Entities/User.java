package ies.p1.rooms_scanner.Entities;
import javax.persistence.*;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "auth_user")
public class User {
    @Id
    @Column(name = "auth_user_nmec")
    private int nmec;

    @Column(name = "username")
    private String username;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;

    public User() {}

    public int getNmec() { return nmec; }
    public String getUsername() { return username; }
    public String getEmail() { return email; }
    public String getPassword() { return password; }
    public Set<Role> getRoles() { return roles; }
    // public String getType() { return type; }
    // public String getStatus() { return status; }

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "auth_user_role", joinColumns = @JoinColumn(name = "auth_user_nmec"), inverseJoinColumns = @JoinColumn(name = "auth_role_id"))
    private Set<Role> roles;


}
