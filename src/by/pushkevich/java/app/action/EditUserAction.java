package app.action;

import entity.User;

import java.util.List;

public class EditUserAction extends BasicAction implements Action {
    AddUserAction action = new AddUserAction();
    @Override
    public String getActionName() {
        return "Изменить пользователя";
    }

    @Override
    public void execute() {
        List<User> users = controller.getUsers();
        int id = getInt("Введите ID:");
        User tmpUser = new User(id);
        if (users.contains(tmpUser)){
            System.out.println("----- ИЗМЕНЕНИЕ ПОЛЬЗОВАТЕЛЯ -----");
            tmpUser.setId(id);
            tmpUser.setFirstName(getString("Введите имя:"));
            tmpUser.setLastName(getString("Введите фамилию:"));
            tmpUser.setEmail(action.getEmail());
            tmpUser.setRoles(action.roleChoice());
            tmpUser.setPhoneNumbers(action.phoneNumberChoice());
            controller.editUser(tmpUser);
        }
        else System.out.println("Пользователь не найден");
    }
}
