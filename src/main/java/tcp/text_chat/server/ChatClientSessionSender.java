package tcp.text_chat.server;

import lombok.AllArgsConstructor;
import tcp.text_chat.common.ChatMessage;
import tcp.text_chat.server.message.MessageSender;

@AllArgsConstructor
public class ChatClientSessionSender implements ChatClientSession {

    private final String username;

    private final MessageSender sender;

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public void send(ChatMessage message) {
        sender.send(message);
    }
}
