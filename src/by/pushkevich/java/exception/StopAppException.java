package exception;

public class StopAppException extends Exception {
    public String message(){
        return "Приложение остановлено";
    }
}
