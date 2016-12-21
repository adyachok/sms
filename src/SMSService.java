import java.util.*;

/**
 * Created by eandgya on 12/21/16.
 */
public class SMSService {
    private static SMSService instance;
    private int maxNumOfUsers;
    private int currentNumOfUsers;
    private Set<User> userList;
    private Set <UserGroup> groupList;

    public static SMSService getInstance(int maxNumOfUsers) {
        if(SMSService.instance == null) {
            SMSService instance = new SMSService();
            SMSService.instance = instance;
            instance.maxNumOfUsers = maxNumOfUsers;
        }
        return instance;
    }

    public static void removeInstance() {
        SMSService.instance = null;
    }

    // I think it would be good to have singleton here
    private SMSService() {
        userList = new HashSet<>();
        groupList = new HashSet<>();
    }

    public boolean addUser(User user){
        // This method is responsible to add User to the service.
        // Method checks if there is no reached limit of users.
        // In success it returns true, in fail returns false
        if((currentNumOfUsers + 1) < maxNumOfUsers && !userList.contains(user)) {
            currentNumOfUsers++;
            System.out.println(currentNumOfUsers);
            System.out.println(maxNumOfUsers);
            userList.add(user);
            String group = user.getGroup();
            if (group != null) {
                UserGroup ug = getOrCreateUserGroup(group);
                ug.addUsertoGroup(user);
            }
            return true;
        }
        return false;
    }

    public  boolean removeUser(User user) {
        if(userList.contains(user)) {
            userList.remove(user);
            currentNumOfUsers--;

            String group = user.getGroup();
            if (group != null) {
                UserGroup ug = getUserGroup(group);
                if(ug == null) {
                    // Kind of logging
                    System.out.println("Cannot find user group: " + group);
                }
            }
            return true;
        }
        return false;
    }

    private User getUser(String name) {
        for(User u: userList){
            if(u.getName().equals(name)){
                return u;
            }
        }
        return null;
    }

    public void sendSMS(Message message) {
        switch (message.getType().name()){
            case "user":
                sendSMSToUser(message);
                break;
            case "group":
                sendSMSToGroup(message);
                break;
            case "all":
                sendSMSToAll(message);
                break;
            default:
                System.out.println("Message receiver: " + message.getType() +
                        " is not found in the list of possible deleveries");
        }
    }

    private UserGroup getOrCreateUserGroup(String name) {
        UserGroup ug = getUserGroup(name);
        if(ug == null){
            ug = new UserGroup(name);
        }
        groupList.add(ug);
        return ug;
    }

    private UserGroup getUserGroup(String name) {
        for(UserGroup group: groupList) {
            if (group.getName().equals(name)) {
                return group;
            }
        }
        return null;
    }

    private void sendSMSToUser(Message message) {
        Phone phone = getUserPhone(message.getTo());
        if(phone != null) {
            phone.receiveMessage(message);
        }

    }

    private Phone getUserPhone(String number) {
        for(User u: userList) {
            Phone phone = u.getPhone(number);
            if( phone != null) {
                return phone;
            }
        }
        return null;
    }

    private void sendSMSToGroup(Message message) {
        UserGroup ug = getUserGroup(message.getTo());
        if(ug != null) {
            for(User u: ug.getUserList()) {
                Set<Phone> phones = u.getPhones();
                for(Phone ph: phones) {
                    ph.receiveMessage(message);
                }
            }
        }
    }

    private void sendSMSToAll(Message message) {
        for(User u: userList) {
            Set<Phone> phones = u.getPhones();
            for(Phone ph:phones) {
                ph.receiveMessage(message);
            }
        }
    }

}
