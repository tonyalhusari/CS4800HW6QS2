package org.example;

import java.util.List;

public interface User {

    void sendMessage(String content);

    void sendMessage(String content, List<User> recipients);

    void sendMessage(String content, User user);

    void receiveMessage(Message message);

    void blockUser(User blockedUser);

    void viewChatHistory(User user);

    void printChatHistory();

    void undoLastMessage();


}
