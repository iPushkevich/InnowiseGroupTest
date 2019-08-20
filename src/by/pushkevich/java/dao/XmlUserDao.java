package dao;

import entity.User;
import entity.wrapper.UserWrapper;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class XmlUserDao implements UserDao {

    private File file = new File("resources/usersfile.xml");

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

        try {
            JAXBContext context = JAXBContext.newInstance(UserWrapper.class, User.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            UserWrapper userWrapper = (UserWrapper) unmarshaller.unmarshal(file);
            return userWrapper.getUsers();
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

    @Override
    public void removeUser(User user) {
        users.remove(user);
        saveUsers(users);
    }

    @Override
    public void editUser(User user) {
        if (users.contains(user)) {
            int i = users.indexOf(user);
            users.set(i, user);
            saveUsers(users);
        }
    }

    private void saveUsers(List<User> users) {
        UserWrapper userWrapper = new UserWrapper(users);
        try {
            JAXBContext context = JAXBContext.newInstance(UserWrapper.class, User.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(userWrapper, file);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
