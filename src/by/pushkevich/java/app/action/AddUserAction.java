package app.action;

import entity.User;
import role.Role;
import validator.*;

import java.util.HashSet;
import java.util.Set;

public class AddUserAction extends BasicAction implements Action {
    private static final String IS_ROLE_EXIST = "Пользователь уже обладает данной ролью";
    private static final String IS_NUMBER_EXIST = "Данный номер уже существует";

    public Set<Role> roleChoice() {
        Set<Role> roles = new HashSet<>();

        System.out.println("Выберите роль (колличество 1 - 3):" + "\n" +
                "Список ролей: администратор, пользователь, сотрудник, стажёр, мужчина, женщина");
        while (roles.size() < 3) {
            String role = getString("Нажмите 0 для выхода");
            if (!roles.isEmpty() && role.equals("0")) break;

            if (role.equalsIgnoreCase("администратор")) {
                if (!roles.contains(Role.ADMIN)) roles.add(Role.ADMIN);
                else System.out.println(IS_ROLE_EXIST);

            } else if (role.equalsIgnoreCase("пользователь")) {
                if (!roles.contains(Role.USER)) roles.add(Role.USER);
                else System.out.println(IS_ROLE_EXIST);

            } else if (role.equalsIgnoreCase("сотрудник")) {
                if (!roles.contains(Role.EMPLOYEE)) roles.add(Role.EMPLOYEE);
                else System.out.println(IS_ROLE_EXIST);

            } else if (role.equalsIgnoreCase("стажёр")) {
                if (!roles.contains(Role.TRAINEE)) roles.add(Role.TRAINEE);
                else System.out.println(IS_ROLE_EXIST);

            } else if (role.equalsIgnoreCase("мужчина")) {
                if (!roles.contains(Role.MAN)) roles.add(Role.MAN);
                else System.out.println(IS_ROLE_EXIST);

            } else if (role.equalsIgnoreCase("женщина")) {
                if (!roles.contains(Role.WOMAN)) roles.add(Role.WOMAN);
                else System.out.println(IS_ROLE_EXIST);

            } else if (role.equals("0") && roles.isEmpty()) System.out.println("Выберите минимум 1 роль");

            else System.out.println("Данной роли не существует, повторите");

            if (roles.size() == 2) System.out.println("Максимум 3 роли, осталась последняя");

        }
        return roles;
    }

    public String getEmail() {
        String tmp = getString("Введите почтовый адрес:");
        if (EmailValidator.isValidEmail(tmp)) return tmp;
        System.out.println("Неверный формат! Повторите");
        return getEmail();
    }

    private int isExistId() {
        int tmp = getInt("Введите ID пользователя:");
        User tmpUser = new User(tmp);
        if (!controller.getUsers().contains(tmpUser)) return tmp;
        System.out.println("Данный ID занят, повторите ввод");
        return isExistId();
    }

    public Set<String> phoneNumberChoice() {
        Set<String> set = new HashSet<>();
        System.out.println("Введите номер в формате 375ХХ ХХХХХХ (колличество 1 - 3)");
        while (set.size() < 3) {
            String number = getString("Нажмите 0 для выхода");
            if (!set.isEmpty() && number.equals("0")) break;
            else if (PhoneNumberValidator.isValidNumber(number)) {
                if (set.contains(number)) System.out.println(IS_NUMBER_EXIST);
                else set.add(number);
            } else if (set.isEmpty() && number.equals("0")) System.out.println("Введите минимум 1 номер");

            else System.out.println("Неверный формат ввода");

            if (set.size() == 2) System.out.println("Максимум 3 номера, остался последний");
        }
        return set;
    }

    @Override
    public String getActionName() {
        return "Добавление пользователя";
    }

    @Override
    public void execute() {
        int id = isExistId();
        String firstName = getString("Введите имя:");
        String lastName = getString("Введите фамилию:");
        String email = getEmail();
        Set<Role> roles = roleChoice();
        Set<String> numbers = phoneNumberChoice();

        User user = new User(id, firstName, lastName, email, roles, numbers);
        boolean isAdd = controller.addUser(user);
        if (isAdd) System.out.println("Пользователь добавлен");
        else System.out.println("Ошибка при добавлении");

    }
}
