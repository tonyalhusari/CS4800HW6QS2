package org.example;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SearchMessagesByUser implements Iterator<Message> {
    private User user;
    private Iterator messageIterator;

    public SearchMessagesByUser(User user, ChatHistory chatHistory) {
        this.user = user;
        this.messageIterator = chatHistory.iterator(user);
    }

    @Override
    public boolean hasNext() {
        while (messageIterator.hasNext()) {
            Message message = (Message) messageIterator.next();
            if (message.getSender().equals(user) || message.isRecipient(user)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Message next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return (Message) messageIterator.next();
    }
}
