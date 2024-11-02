package com.example311.userDAO;


import com.example311.model.User;

import java.util.List;

public interface UserDAO {
    void addUser(User user);

    void deleteUser(Long id);

    void editUser(User user);

    User getUserById(Long id);

    List<User> getAllUsers();


}
