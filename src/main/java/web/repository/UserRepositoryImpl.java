package web.repository;

import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> getAllUsers() {

        return entityManager.createQuery("from User", User.class).getResultList();
    }

    @Override
    public User readUser(Long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void createUser(User user) {
        entityManager.persist(user);
        entityManager.flush();
    }

    @Override
    public void editUser(Long id, User user) {
        entityManager.merge(user);
        entityManager.flush();
    }

    @Override
    public void deleteUser(Long id) {
        User user = readUser(id);

        entityManager.remove(user);
        entityManager.flush();
    }

    @Override
    public User getUserByEmail(String email) {
        return entityManager
                .createQuery("SELECT u from User u WHERE u.email = :email", User.class)
                .setParameter("email", email)
                .getSingleResult();
    }
}
