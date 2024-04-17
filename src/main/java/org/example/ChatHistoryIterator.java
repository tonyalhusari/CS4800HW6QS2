package org.example;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class ChatHistoryIterator implements Iterator {
    private int index;
    private int size;
    private List<Message> messageHistory;
    private User user;
    public ChatHistoryIterator(User user, List<Message> messageHistory) {
        this.index = 0;
        this.size = messageHistory.size();
        this.messageHistory = messageHistory;
        this.user = user;
    }

    @Override
    public boolean hasNext() {
        while (index < size) {
            Message message = messageHistory.get(index);
            if (message.getSender().equals(user) || message.isRecipient(user)) {
                return true;
            }
            index++;
        }
        return false;
    }

    @Override
    public Message next() {
        if (!hasNext()) {
            throw  new NoSuchElementException();
        }
        return messageHistory.get(index++);
    }
}
