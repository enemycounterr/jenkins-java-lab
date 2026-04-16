package tcp.text_chat.server;

public class ChatServerApp {

    private static final int DEFAULT_PORT = 7150;
    private static final int DEFAULT_THREADS = 10;

    public static void main(String[] args) {
        try {
            int port = getEnvInt("CHAT_SERVER_PORT", DEFAULT_PORT);
            int threads = getEnvInt("CHAT_SERVER_THREADS", DEFAULT_THREADS);

            ServerConfig config = new ServerConfig(port, threads);
            new ChatServer(config).start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static int getEnvInt(String envName, int defaultValue) {
        String value = System.getenv(envName);
        if (value != null) {
            try {
                return Integer.parseInt(value);
            } catch (NumberFormatException e) {
                System.out.println("Invalid " + envName + ", using default: " + defaultValue);
            }
        }
        return defaultValue;
    }
}
