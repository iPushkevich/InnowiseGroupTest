package app.action;

import entity.User;

public class RemoveUserAction extends BasicAction implements Action {
    @Override
    public String getActionName() {
        return "Удаление пользователя";
    }

    @Override
    public void execute() {
        int id = getInt("Введите ID пользователя:");
        User user = new User(id);
        controller.removeUser(user);
    }
}
