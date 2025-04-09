package org.example.repository;
// methde du user quui accede a la base de donnee
import org.example.model.User;
import java.util.List;

public interface UserRepository {
    User findById(int id);
    User findByUsername(String username);
    List<User> findAll();
    boolean save(User user);
    boolean delete(int id);
}