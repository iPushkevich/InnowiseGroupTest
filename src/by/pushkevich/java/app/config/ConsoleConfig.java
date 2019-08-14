package app.config;

import app.action.*;

import java.util.HashMap;
import java.util.Map;

public class ConsoleConfig {
    public static Map<Integer, Action> getActions() {
        Map<Integer, Action> actionMap = new HashMap<>();
        actionMap.put(1, new AddUserAction());
        actionMap.put(2, new GetAllUsersAction());
        actionMap.put(3, new RemoveUserAction());
        actionMap.put(4, new EditUserAction());

        return actionMap;
    }
}
