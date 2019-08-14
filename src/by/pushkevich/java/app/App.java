package app;

import app.action.Action;
import app.config.ConsoleConfig;
import app.utils.ConsoleInput;
import exception.StopAppException;

import java.util.Map;

public class App {
    private Map<Integer, Action> actionMap;

    private void showMenu() {
        for (Map.Entry<Integer, Action> entry : actionMap.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue().getActionName());
        }
        System.out.println("0 - Выход");
    }

    private Action getChoice() throws StopAppException {
        System.out.println("Выберите действие:");
        showMenu();
        int i = ConsoleInput.getInt();
        if (i == 0) throw new StopAppException();
        Action action = actionMap.get(i);
        if (action != null) return action;
        System.out.println("Действия не существует");
        return getChoice();
    }

    private void run() {
        while (true) {
            try {
                Action action = getChoice();
                action.execute();
            } catch (StopAppException e) {
                System.out.println(e.message());
                break;
            }
        }
    }

    public void start() {
        actionMap = ConsoleConfig.getActions();
        run();
    }

}
