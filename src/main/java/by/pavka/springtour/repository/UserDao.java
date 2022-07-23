package by.pavka.springtour.repository;

import by.pavka.springtour.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao {
    User getUserById(int id);
    List<User> getAllUsers();
    int addUser(User user);
    int updateUser(User user);
    int deleteUser(int id);
}
