package tcp.text_chat.server.message;


import tcp.text_chat.common.ChatMessage;

public interface MessageSender {
    void send(ChatMessage message);
}
