package org.example;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class ChatHistory implements IterableByUser{

    private List<Message> messageHistory;

    public ChatHistory() {
        this.messageHistory = new Stack<>();
    }


    public void printChatHistory() {
        // print chat history
        for (Message message : messageHistory) {
            System.out.println(message);
        }
    }

    public void addMessage(Message message) {
        // add message to chat history
        messageHistory.add(message);
    }

    public Message getLastMessage() {
        return messageHistory.get(messageHistory.size() - 1);
    }

    @Override
    public Iterator iterator(User user) {
        return new ChatHistoryIterator(user,messageHistory);
    }
}
