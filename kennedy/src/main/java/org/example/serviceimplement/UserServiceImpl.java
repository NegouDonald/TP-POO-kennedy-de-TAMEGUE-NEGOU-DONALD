package org.example.serviceimplement;
// userimplement prend les donnees sur
// les interface graphique et passe les donnnee au service et le service appel repository
//serimplet verifie si les donnee sont correct
import org.example.model.User;
import org.example.repository.UserRepository;
import org.example.service.UserService;
import java.util.List;

public class UserServiceImpl implements UserService {
    private final UserRepository repository;

    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    public User getUserById(int id) {
        return repository.findById(id);//
    }

    public User login(String username, String password) {
        User user = repository.findByUsername(username);
        return user != null && user.getPassword().equals(password) ? user : null;
    }

    public boolean register(User user) {
        return repository.save(user);
    }

    public List<User> getAllUsers() {
        return repository.findAll();
    }

    public boolean deleteUser(int id) {
        return repository.delete(id);
    }
}