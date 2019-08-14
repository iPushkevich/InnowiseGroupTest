package app.action;

import entity.User;
import role.FamilyStatus;
import role.WorkStatus;
import validator.*;

import java.util.HashSet;
import java.util.Set;

public class AddUserAction extends BasicAction implements Action {
    public FamilyStatus familyStatusChoice() {
        int familyStatus = getInt("Выберите семейное положение:" + "\n" +
                "1 - женат / замужем" + "\n" +
                "2 - холост / не замужем");
        if (familyStatus < 1 || familyStatus > 2) System.out.println("Ошибка ввода! Повторите");
        if (familyStatus == 1) return FamilyStatus.MARRIED;
        if (familyStatus == 2) return FamilyStatus.NOT_MARRIED;

        return familyStatusChoice();
    }

    public WorkStatus workStatusChoice() {
        int workStatus = getInt("Выберите занятость:" + "\n" +
                "1 - студент" + "\n" +
                "2 - рабочий" + "\n" +
                "3 - безработный" + "\n" +
                "4 - пенсионер");
        if (workStatus < 1 || workStatus > 4) {
            System.out.println("Ошибка ввода! Повторите");
        }
        if (workStatus == 1) return WorkStatus.STUDENT;
        if (workStatus == 2) return WorkStatus.WORKER;
        if (workStatus == 3) return WorkStatus.UNEMPLOYED;
        if (workStatus == 4) return WorkStatus.RETIREE;
        return workStatusChoice();
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

    public Set<Long> getPhoneNumbers() {
        Set<Long> set = new HashSet<>();
        while (set.size() < 3) {
            long number = getLong("Введите номер в формате 375ХХХХХХХХ");
            System.out.println("0 - выход");
            if (number == 0) break;
            if (PhoneNumberValidator.isValidNumber(number)) set.add((long) number);
            else System.out.println("Неверный формат воода");
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
        WorkStatus wStatus = workStatusChoice();
        FamilyStatus fStatus = familyStatusChoice();
        Set<Long> numbers = getPhoneNumbers();

        User user = new User(id, firstName, lastName, email, wStatus, fStatus, numbers);
        boolean isAdd = controller.addUser(user);
        if (isAdd) System.out.println("Пользователь добавлен");
        else System.out.println("Ошибка при добавлении");

    }
}
