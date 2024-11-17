package streevdm.NotifyMyProcess;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CommandExecutor {

    public static void executeCommand(Command command) {
        command.setStartTime();
        try {
            Process process = new ProcessBuilder(command.getCommand().split(" ")).start();
            int exitCode = process.waitFor();
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            command.setEndTime();
            checkExitCode(exitCode, command);
        } catch (Exception e) {
            System.out.println("Command failed with exception: " + e.getMessage());
            System.exit(1);
        }

    }

    private static void checkExitCode(int exitCode, Command command) {
        SendMessage sendMessage = new SendMessage();
        long executionTime = command.getDuration();
        String[] commandArgs = command.getCommand().split(" ");
        String firstTwoArgs = commandArgs.length > 1 ? commandArgs[0] + " " + commandArgs[1] : commandArgs[0];

        if (exitCode != 0) {
            String message = String.format("Command '%s' failed with exit code: %d. Execution time: %d ms", firstTwoArgs, exitCode, executionTime);
            System.out.println(message);
            sendMessage.send(message);
            System.exit(1);
        } else {
            String message = String.format("Command '%s' executed successfully. Execution time: %d ms", firstTwoArgs, executionTime);
            System.out.println(message);
            sendMessage.send(message);
        }
    }
}