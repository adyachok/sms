/**
 * Created by eandgya on 12/21/16.
 */
public class App {
    public static void main(String[] args) {
        SMSService smss = SMSService.getInstance(12);
        User u = new User("Andras");
        u.addPhone("555-555");
        Message m = new Message();
        m.setFrom(u.getName());
        m.setPayload("Heelo!");
        m.setTo("colleagues");
        m.setType(ReceiverType.group);
        smss.sendSMS(m);
    }
}
