package tcp.text_chat.server.message;


import tcp.text_chat.common.ChatMessage;

import java.io.IOException;

public interface MessageReceiver {
    ChatMessage receive() throws IOException;
}
