package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ChatServerImpl implements ChatServer {

    private List<User> users;
    private HashMap<User, List<User>> blockedUsers;
    public ChatServerImpl() {
        this.users = new ArrayList<>();
        this.blockedUsers = new HashMap<>();
    }
    @Override
    public void registerUser(User user) {
        // add user to the list of users
        users.add(user);
    }

    @Override
    public void unregisterUser(User user) {
        // remove user from the list of users
        users.remove(user);
    }

    @Override
    public void forwardMessage(User sender,Message message) {
        // send the message to each user in the list of users unless they are blocked
        for (User user : users) {
            if (!isBlocked(user, sender) && user != sender) {
                // set the message recipients
                message.setRecipients(user);
                // send the message
                user.receiveMessage(message);
            }
        }
        System.out.println(message);
    }

    @Override
    public void forwardMessage(User sender, Message message, List<User> recipients) {
        // send the message to each user in the list of users unless they are blocked
        for (User user : recipients) {
            if (!isBlocked(user, sender) && user != sender && users.contains(user)) {
                // set the message recipients
                message.setRecipients(user);
                // send the message
                user.receiveMessage(message);
            }
        }
        System.out.println(message);
    }

    @Override
    public void forwardMessage(User sender, Message message, User recipient) {
        // send the message to the recipient
        // check if the recipient is registered
        if (users.contains(recipient)) {
            // check if the sender is not blocked by the recipient
            if (!isBlocked(recipient, sender)) {
                // set the message recipients
                message.setRecipients(recipient);
                // send the message
                recipient.receiveMessage(message);
                // print the message
                System.out.println(message);
            }
        }

    }

    @Override
    public void blockUser(User user , User blockedUser) {
        // block user so they cannot send messages this user messages
        List<User> blocked = blockedUsers.get(user);
        if (blocked == null) {
            blocked = new ArrayList<>();
            blockedUsers.put(user, blocked);
        }
        blocked.add(blockedUser);
    }

    @Override
    public void viewChatHistory(User user) {
        if (users.contains(user)) {
            user.printChatHistory();
        }
    }

    public boolean isBlocked(User user, User blockedUser) {
        List<User> blocked = blockedUsers.get(user);
        if (blocked == null) {
            return false;
        }
        return blocked.contains(blockedUser);
    }
}
