package org.example;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ChatServer mediator = new ChatServerImpl();

        UserImpl user1 = new UserImpl("user1", mediator);
        User user2 = new UserImpl("user2", mediator);
        User user3 = new UserImpl("user3", mediator);

        mediator.registerUser(user1);
        mediator.registerUser(user2);
        mediator.registerUser(user3);

        user1.sendMessage("message1", user3);
        user1.sendMessage("message2", List.of(user2, user3));
        user3.sendMessage("message3", user1);
        user1.sendMessage("message4", user2);

        System.out.println("---------");
        System.out.println("---------");

        Iterator iterator = user1.iterator(user3);
        while (iterator.hasNext()) {
            Message message = (Message) iterator.next();
            System.out.println(message);
        }
    }
}