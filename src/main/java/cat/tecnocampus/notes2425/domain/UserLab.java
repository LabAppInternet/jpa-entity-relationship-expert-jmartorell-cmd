package cat.tecnocampus.notes2425.domain;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "user_lab")
public class UserLab{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String email;


    public UserLab(String username, String email){
        this.username = username;
        this.email = email;
    }

    public UserLab() {}

    public Long getId() {
        return id;
    }
    public String getEmail() {
        return email;
    }
    public String getUsername() {
        return username;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public boolean equals(Object o) {
        if(o instanceof UserLab){
            return ((UserLab)o).getId() == id;
        }
        return false;

    }
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
