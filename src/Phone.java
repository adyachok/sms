import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by eandgya on 12/21/16.
 */
public class Phone {
    String number;
    List<Message> receivedMessages;

    public Phone(String number) {
        this.number = number;
        receivedMessages = new ArrayList<>();
    }
    public void getMessages() {
        Iterator it = receivedMessages.listIterator();
        while(it.hasNext()) {
            Message m = (Message)it.next();
            System.out.println("From: " + m.getFrom());
            System.out.println("Message" + m.getPayload());
        }

    }
    public void receiveMessage(Message message) {
        receivedMessages.add(message);
    }
}
