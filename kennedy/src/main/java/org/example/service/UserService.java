package org.example.service;
// definit les methode que userservice va imple
import org.example.model.User;
import java.util.List;

public interface UserService {
    User getUserById(int id);
    User login(String username, String password);
    boolean register(User user);
    List<User> getAllUsers();
    boolean deleteUser(int id);
}
