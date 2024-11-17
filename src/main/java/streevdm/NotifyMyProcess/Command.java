package streevdm.NotifyMyProcess;

public class Command {

    private final String command;
    private int startTime;
    private int endTime;

    public Command(String command) {
        this.command = command;
    }

    public void setStartTime() {
        this.startTime = (int) System.currentTimeMillis();
    }

    public void setEndTime() {
        this.endTime = (int) System.currentTimeMillis();
    }

    public int getDuration() {
        return this.endTime - this.startTime;
    }

    public String getCommand() {
        return this.command;
    }
}
