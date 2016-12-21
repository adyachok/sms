import junit.extensions.TestSetup;
import org.junit.After;

import static org.junit.Assert.*;

/**
 * Created by eandgya on 12/21/16.
 */
public class SMSServiceTest {

    @org.junit.Test
    public void getInstance() throws Exception {
        SMSService s1 = SMSService.getInstance(10);
        SMSService s2 = SMSService.getInstance(20);
        assertTrue(s1.equals(s2));
    }

    @org.junit.Test
    public void addUser() throws Exception {
        User user = new User("Andras");
        SMSService s1 = SMSService.getInstance(10);
        assertTrue(s1.addUser(user));
    }

    @org.junit.Test
    public void addToMuchUser() throws Exception {
        // TODO: fix this test , removing
        SMSService s2 = SMSService.getInstance(4);

        User user1 = new User("Andras");
        User user2 = new User("Bandras");
        User user3 = new User("Candras");
        User user4 = new User("Dandras");
        User user5 = new User("Fandras");

        assertTrue(s2.addUser(user1));
        assertTrue(s2.addUser(user2));
        assertTrue(s2.addUser(user3));
        assertTrue(s2.addUser(user4));
        assertFalse(s2.addUser(user5));
    }

    @org.junit.Test
    public void removeUser() throws Exception {

    }

    @org.junit.Test
    public void sendSMS() throws Exception {

    }

    @After
    public void tearDown() throws Exception {
        SMSService.removeInstance();
    }


}