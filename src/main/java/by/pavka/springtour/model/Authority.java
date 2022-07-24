package by.pavka.springtour.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="authorities")
@IdClass(Authority.class)
public class Authority implements Serializable {
    @Id
    @Column(name="username")
    private String Id;

    @Id
    @Column(name="authority")
    private String role;

    public String getId() {
        return Id;
    }

    public void setId(String username) {
        this.Id = username;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
