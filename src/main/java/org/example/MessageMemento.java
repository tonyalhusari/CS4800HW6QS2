package org.example;

public class MessageMemento {

    private String content;
    private TimeStamp timestamp;

    public MessageMemento(String content, TimeStamp timestamp) {
        this.content = content;
        this.timestamp = timestamp;
    }

    public String getContent() {
        return content;
    }

    public TimeStamp getTimestamp() {
        return timestamp;
    }
}
