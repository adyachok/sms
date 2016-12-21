import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by eandgya on 12/21/16.
 */
public class User {
    private Set<Phone> phones;
    private String name;
    private String group;

    public User(String name) {
        this.name = name;
        this.phones = new HashSet<>();
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void addPhone(String number) {
        phones.add(new Phone(number));
    }

    public Phone getPhone(String number) {
        for(Phone ph: phones) {
            if(ph.number.equals(number)) {
                return ph;
            }
        }
        return null;
    }

    public Set<Phone> getPhones() {
        return phones;
    }
}
