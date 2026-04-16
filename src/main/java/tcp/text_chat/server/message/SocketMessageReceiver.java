package tcp.text_chat.server.message;


import lombok.AllArgsConstructor;
import tcp.text_chat.common.ChatMessage;
import tcp.text_chat.common.MessageCodec;


import java.io.BufferedReader;
import java.io.IOException;

@AllArgsConstructor
public class SocketMessageReceiver implements MessageReceiver {

    private final BufferedReader reader;

    @Override
    public ChatMessage receive() throws IOException {
        String line = reader.readLine();
        if (line == null) {
            return null;
        }
        return MessageCodec.decode(line);
    }
}
