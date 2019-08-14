package dao;

import entity.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SerializableUserDao implements UserDao {

    private static final String PATH = "users.bin";

    private List<User> users = getUsers();

    @Override
    public void addUser(User user) {
        if (!users.contains(user)) {
            users.add(user);
            saveUsers(users);
        }
    }

    @Override
    public List<User> getUsers() {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(PATH))) {
            return (List<User>) objectInputStream.readObject();
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

    @Override
    public void removeUser(User user) {
            users.remove(user);
            saveUsers(users);
    }
    public void editUser(User user){
       if (users.contains(user)){
           int i = users.indexOf(user);
           users.set(i, user);
           saveUsers(users);
       }
    }

    private void saveUsers(List<User> users) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(PATH))) {
            objectOutputStream.writeObject(users);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
