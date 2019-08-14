package dao;

import entity.User;

import java.util.List;

public interface UserDao {
    void addUser(User user);

    List<User> getUsers();

    void removeUser(User user);

    void editUser(User user);

    default boolean isExist(User user) {
        return getUsers().contains(user);
    }
}
