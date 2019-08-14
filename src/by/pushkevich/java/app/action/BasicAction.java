package app.action;

import app.utils.*;
import controller.UserController;

public abstract class BasicAction {
    protected UserController controller = new UserController();

    protected int getInt(String message) {
        System.out.println(message);
        return ConsoleInput.getInt();
    }

    protected String getString(String message) {
        System.out.println(message);
        return ConsoleInput.getString();
    }

    protected long getLong(String message){
        System.out.println(message);
        return ConsoleInput.getLong();
    }
}
