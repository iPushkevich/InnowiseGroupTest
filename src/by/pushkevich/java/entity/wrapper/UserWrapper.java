package entity.wrapper;

import entity.User;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "Пользователи")
public class UserWrapper {
    private List<User> users;

    public UserWrapper(List<User> users) {
        this.users = users;
    }

    public UserWrapper() {
    }

    @XmlElement(name = "Пользователь")
    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
