package org.example;

import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class UserImpl implements User , IterableByUser {
    private String name;
    private ChatServer mediator;
    private ChatHistory chatHistory;
    public UserImpl(String name, ChatServer mediator) {
        this.name = name;
        this.mediator = mediator;
        this.chatHistory = new ChatHistory();
    }
    @Override
    public void sendMessage(String content) {
        // create the message
        Message message = new Message(content);
        // add sender to message
        message.setSender(this);
        // send message via mediator to each recipient
        mediator.forwardMessage(this, message);
        // add message to chat history
        chatHistory.addMessage(message);
    }

    @Override
    public void sendMessage(String content, List<User> recipients) {
        // create the message
        Message message = new Message(content);
        // add sender to message
        message.setSender(this);
        // send message via mediator
        mediator.forwardMessage(this, message, recipients);
        // add message to chat history
        chatHistory.addMessage(message);
    }

    @Override
    public void sendMessage(String content, User recipient) {
        // create the message
        Message message = new Message(content);
        // add sender to message
        message.setSender(this);
        // send message via mediator
        mediator.forwardMessage(this, message, recipient);
        // add message to chat history
        chatHistory.addMessage(message);
    }

    @Override
    public void receiveMessage(Message message) {
        // add message to chat history
        chatHistory.addMessage(message);
    }

    public void blockUser(User user) {
        // block user so they cannot send messages this user messages
        mediator.blockUser(this, user);

    }
    @Override
    public void viewChatHistory(User user) {
        // print the chat history
        mediator.viewChatHistory(user);
    }

    public void printChatHistory() {
        // print the chat history
        chatHistory.printChatHistory();
    }


    @Override
    public void undoLastMessage() {
        // undo the last message
        chatHistory.getLastMessage();
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserImpl user = (UserImpl) o;
        return Objects.equals(name, user.name);
    }

    @Override
    public Iterator iterator(User user) {
        return chatHistory.iterator(user);
    }
}
