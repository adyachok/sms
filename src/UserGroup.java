import java.util.ArrayList;
import java.util.List;

/**
 * Created by eandgya on 12/21/16.
 */
public class UserGroup {
    private String name;
    private List<User> userList;

    public UserGroup(String name) {
        this.name = name;
        this.userList = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void addUsertoGroup(User user) {
        if (!this.userList.contains(user)) {
            this.userList.add(user);
        }
    }
}
