package by.pavka.springtour.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.security.SecureRandom;
import java.util.List;

@Entity
@Table(name="users")
public class LibraryUser implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="name")
    private String name;

    @Column(name="surname")
    private String surname;

    @Column(name="email")
    private String email;

    @Column(name="username")
    @Size(min=3, message="Too short username")
    private String username;

//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name="username")
//    private Authority authority;

    @Column(name="password")
    private String password;

    @Transient
    private String checkPassword;

    public String getCheckPassword() {
        return checkPassword;
    }

    public void setCheckPassword(String checkPassword) {
        this.checkPassword = checkPassword;
    }

    @Column(name="enabled")
    private int enabled;

//    public List<Tour> getTours() {
//        return tours;
//    }
//
//    public void setTours(List<Tour> tours) {
//        this.tours = tours;
//    }

    @ManyToMany
    @JoinTable(
            name="bookings"
            , joinColumns = @JoinColumn(name="tourist_id")
            , inverseJoinColumns = @JoinColumn(name="tour_id")
    )
    @JsonManagedReference
    private List<Tour> tours;

    public List<Tour> getTours() {
        return tours;
    }

    public void setTours(List<Tour> tours) {
        this.tours = tours;
    }

    public LibraryUser() {
    }

//    public LibraryUser(String name, String surname, String email, String username, String password, int enabled) {
//        this.name = name;
//        this.surname = surname;
//        this.email = email;
////        this.username = username;
//        this.auth
//        this.password = password;
//        this.enabled = enabled;
//    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

//    public Authority getAuthority() {
//        return authority;
//    }
//
//    public void setAuthority(Authority authority) {
//        this.authority = authority;
//    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getEnabled() {
        return enabled;
    }

    public void setEnabled(int enabled) {
        this.enabled = enabled;
    }

    @Override
    public String toString() {
        return id + " " + name + " " + surname + " " + email;
    }

}
