/**
 * Created by eandgya on 12/21/16.
 */
public class Message {
    private String from;
    // User number  or a group
    private ReceiverType type;
    private String to;
    private String payload;

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getPayload() {
        return payload;
    }

    public void setPayload(String payload) {
        this.payload = payload;
    }
    public ReceiverType getType() {
        return type;
    }

    public void setType(ReceiverType type) {
        this.type = type;
    }
}
