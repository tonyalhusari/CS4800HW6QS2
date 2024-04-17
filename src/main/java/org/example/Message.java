package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Message {
    private User sender;
    private List<User> recipients;
    private String content;
    private TimeStamp timestamp;

    public Message(String content) {
        this.sender = null;
        this.recipients = new ArrayList<>();
        this.content = content;
        this.timestamp = new TimeStamp();
    }

    public MessageMemento saveMessageToMemento() {
        return new MessageMemento(content, timestamp);
    }

    public void restoreMessageFromMemento(MessageMemento messageMemento) {
        content = messageMemento.getContent();
        timestamp = messageMemento.getTimestamp();
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public User getSender() {
        return sender;
    }

    public void setRecipients(User user) {
        recipients.add(user);
    }

    @Override
    public String toString() {
        return timestamp +
                " sender=" + sender +
                ", content='" + content + '\'' +
                ", recipient=" + recipients.toString()
                ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Message message = (Message) o;
        return Objects.equals(sender, message.sender) &&
                Objects.equals(recipients, message.recipients) &&
                Objects.equals(content, message.content) &&
                Objects.equals(timestamp, message.timestamp);
    }


    public boolean isRecipient(User user) {
        // check if user is recipient
        return recipients.contains(user);
    }
}
