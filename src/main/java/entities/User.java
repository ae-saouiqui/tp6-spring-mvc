package entities;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="USERS")
public class User {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;

    @Enumerated(EnumType.ORDINAL)
    private Roles role;

    public User(){}
    public User(String username,String password,Roles role){
        this(username,password);
        this.role = role;
    }
    public User(String username,String password){
        this.username = username;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    
    public String getUsername() {
        return username;
    }

    public void setId(Long id){
        this.id = id;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public Roles getRole() {
        return role;
    }
    public void setRole(Roles role) {
        this.role = role;
    }
}
