package streevdm.NotifyMyProcess;

public class Main {
    public static void main(String[] args) {
        String command = String.join(" ", args);
        Command cmd = new Command(command);
        CommandExecutor.executeCommand(cmd);
    }
}