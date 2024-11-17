package streevdm.NotifyMyProcess;

import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.io.entity.StringEntity;

import java.io.Closeable;

public class SendMessage {

    private static final String API_TOKEN = "MyTelegramBotToken";
    private static final String API_URL = "https://api.telegram.org/bot" + API_TOKEN + "/sendMessage";
    private static final String CHAT_ID = "MyChatId";

    public void send(String message) {
        try (CloseableHttpClient client = HttpClients.createDefault()) {
            HttpPost post = new HttpPost(API_URL);
            String payload = String.format("{\"chat_id\":\"%s\",\"text\":\"%s\"}", CHAT_ID, message);

            post.setEntity(new StringEntity(payload));
            post.setHeader("Content-Type", "application/json");

            try (CloseableHttpResponse response = client.execute(post)) {
                System.out.println("Bericht verzonden: " + response.getCode());
            }
        } catch (Exception e) {
            System.out.println("Failed to send message: " + e.getMessage());
        }
    }
}
