package tcp.text_chat.server;

import tcp.text_chat.common.ChatMessage;

public interface ChatClientSession {
    String getUsername();

    void send(ChatMessage message);
}
