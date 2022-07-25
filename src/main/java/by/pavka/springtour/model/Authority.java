package by.pavka.springtour.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="authorities")
public class Authority implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="username")
    private String username;

//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name="username")
//    private LibraryUser user;

    @Enumerated(EnumType.STRING)
    @Column(name="authority")
    private Role role;

    public int getId() {
        return id;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
