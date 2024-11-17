package streevdm.NotifyMyProcess;

import org.junit.jupiter.api.Test;

class MainTest {


    @Test
    void testCommandExecutor() {
        SendMessage sendMessage = new SendMessage();
        sendMessage.send("Test message");
    }

}