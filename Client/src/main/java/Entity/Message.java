package Entity;

public class Message {
    private String sequence;
    private String timestamp;
    private String fromId;
    private String toId;
    private String message;

    public Message() {
    }

    public Message(String sequence, String timestamp, String fromId, String toId, String message) {
        this.sequence = sequence;
        this.timestamp = timestamp;
        this.fromId = fromId;
        this.toId = toId;
        this.message = message;
    }

    public String getSequence() {
        return sequence;
    }

    public void setSequence(String sequence) {
        this.sequence = sequence;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getFromId() {
        return fromId;
    }

    public void setFromId(String fromId) {
        this.fromId = fromId;
    }

    public String getToId() {
        return toId;
    }

    public void setToId(String toId) {
        this.toId = toId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Entity.Message{" +
                "sequence='" + sequence + '\'' +
                ", timestamp='" + timestamp + '\'' +
                ", fromId='" + fromId + '\'' +
                ", toId='" + toId + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
