package web.repository;

import web.model.User;

import java.util.List;

public interface UserRepository {

    List<User> getAllUsers();

    User readUser(Long id);

    void createUser(User user);

    void editUser(Long id, User user);

    void deleteUser(Long id);

    User getUserByEmail(String email);
}
