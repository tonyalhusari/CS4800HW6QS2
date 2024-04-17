package org.example;

import java.util.List;

public interface ChatServer {

    public void registerUser(User user);
    public void unregisterUser(User user);

    void forwardMessage(User user, Message message);

    void forwardMessage(User sender, Message message, List<User> recipients);
    void forwardMessage(User sender, Message message, User recipient);

    void blockUser(User user, User blockedUser);

    void viewChatHistory(User user);
}
