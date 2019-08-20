package controller;

import dao.SerializableUserDao;
import dao.UserDao;
import dao.XmlUserDao;
import entity.User;

import java.util.List;

public class UserController {
    private UserDao dao = new XmlUserDao();

    public boolean addUser(User user) {
        if (dao.isExist(user)) return false;
        dao.addUser(user);
        return true;
    }

    public List<User> getUsers() {
        return dao.getUsers();
    }

    public void removeUser(User user) {
        if (dao.isExist(user)) {
            dao.removeUser(user);
            System.out.println("Пользователь удален");
        } else System.out.println("Пользователь не найден");
    }

    public void editUser(User user) {
        if (dao.isExist(user)) {
            dao.editUser(user);
            System.out.println("Пользователь изменен");
        } else System.out.println("Пользователь не найден");
    }
}
