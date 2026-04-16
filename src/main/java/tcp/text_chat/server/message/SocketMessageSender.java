package tcp.text_chat.server.message;

import lombok.AllArgsConstructor;
import tcp.text_chat.common.ChatMessage;
import tcp.text_chat.common.MessageCodec;

import java.io.PrintWriter;

@AllArgsConstructor
public class SocketMessageSender implements MessageSender{

    private final PrintWriter writer;

    @Override
    public void send(ChatMessage message) {
        writer.println(MessageCodec.encode(message));
        writer.flush();
    }
}
