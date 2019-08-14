package app.action;

import entity.User;

import java.util.List;

public class GetAllUsersAction extends BasicAction implements Action {
    @Override
    public String getActionName() {
        return "Вывод всех пользователей";
    }

    @Override
    public void execute() {
        List<User> list = controller.getUsers();
        if (list.isEmpty()) System.out.println("Пользователи отсутсвуют");
        for (User user : list) {
            System.out.println(user);
        }
    }
}
