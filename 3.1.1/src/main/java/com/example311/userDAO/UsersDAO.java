package com.example311.userDAO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import com.example311.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UsersDAO implements UserDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void addUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public void deleteUser(Long id) {
        entityManager
                .createQuery("delete from User where id=: id")
                .setParameter("id", id)
                .executeUpdate();
    }

    @Override
    public void editUser(User user) {
        entityManager.merge(user);
    }

    @Override
    public User getUserById(Long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery("From User").getResultList();
    }
}


